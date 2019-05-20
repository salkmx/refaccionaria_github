/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amickom.service.impl;

import com.amickom.autopartdao.dto.Cliente;
import com.amickom.autopartdao.dto.NotaRemisionDTO;
import com.amickom.autopartdao.dto.Pedido;
import com.amickom.autopartdao.dto.PedidoProducto;
import com.amickom.autopartdao.dto.Proveedor;
import com.amickom.autopartdao.dto.VentasUtilidadDTO;
import com.amickom.autopartdao.dto.VentasxClienteDTO;
import com.amickom.autopartdao.dto.VentasxProveedorDTO;
import com.amickom.service.IReportService;
import com.amickom.service.exception.RefaccionariaException;
import com.amickom.service.util.ConversionNumTexto;
import com.amickom.service.util.Formatter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author david
 */
@Service("reporteService")
public class ReporteService implements IReportService {

    private static Logger log = Logger.getLogger(ProveedorService.class);

    @Override
    public String generaNotaRemision(NotaRemisionDTO remisionDTO)
            throws RefaccionariaException {
        log.debug("Iniciando la generación de la nota de remisión: ");
        List<PedidoProducto> pedidos = remisionDTO.getPedidoproducto();
        List<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
        for (PedidoProducto producto : pedidos) {
            HashMap<String, String> fields = new HashMap<String, String>();
            fields.put("cantidad", String.valueOf(producto.getCantidad()));
            fields.put("codigo", producto.getProductos().getCodigo());
            fields.put("descripcion", producto.getProductos().getDescripcion());
            // El precio total del producto se calcula de la siguiente forma:
            // se toma el precio de cada producto y se multiplica por la cantidad
            // se toma la utilidad de cada producto y se multiplica por la cantidad
            // se suman ambas cantidades y así quedá el precio de cada producto
            // dentro del pedido
            double precioTotalProducto =
                    (producto.getProductos().getPrecio()
                    * producto.getCantidad());
            double utilidadProducto =
                    (producto.getUtilidad() / 100
                    * producto.getProductos().getPrecio());
            //Al precio de cada producto se le suma la utilidad 
            double precioUnitario = producto.getProductos().getPrecio() + utilidadProducto;
            fields.put("preciounitario", Formatter.formatMonto(precioUnitario));
            fields.put("preciototal", Formatter.formatMonto(precioTotalProducto + (utilidadProducto * producto.getCantidad())));
            //Copia del recibo
            fields.put("cantidad_1", String.valueOf(producto.getCantidad()));
            fields.put("codigo_1", producto.getProductos().getCodigo());
            fields.put("descripcion_1", producto.getProductos().getDescripcion());
            fields.put("preciounitario_1", Formatter.formatMonto(precioUnitario));
            fields.put("preciototal_1", Formatter.formatMonto(precioTotalProducto + (utilidadProducto * producto.getCantidad())));
            data.add(fields);
        }
        Pedido pedido = remisionDTO.getPedido();
        Cliente cliente = remisionDTO.getCliente();
        HashMap<String, String> parameters = new HashMap<String, String>();
        parameters.put("NOMBRE_USUARIO", "Artemio Vergara Tolentino");
        parameters.put("FECHA_CREACION", Formatter.formatFechaCorta(
                Calendar.getInstance().getTime()));
        parameters.put("PEDIDO", String.valueOf(pedido.getId()));
        parameters.put("NOMBRE_CLIENTE", cliente.getNombre());
        parameters.put("DIRECCION_CLIENTE", cliente.getDireccion());
        parameters.put("TELEFONO_CELULAR", cliente.getTelefono());//Arreglar bd para tener el telefono celular
        parameters.put("CP_CLIENTE", cliente.getCp());//Arreglar bd para tener el cp_cliente
        parameters.put("CIUDAD_CLIENTE", cliente.getEmail()); //Arreglar bd para tener la ciudad del cliente        
        parameters.put("RFC_CLIENTE", cliente.getRfc());
        parameters.put("NUMERO_USUARIO", "1");
        parameters.put("PRECIO_LETRA", ConversionNumTexto.cantidadLetra(remisionDTO.getTotal()));
        parameters.put("SUBTOTAL_PEDIDO", Formatter.formatMonto(remisionDTO.getSubtotal()));
        parameters.put("TOTAL_PEDIDO", Formatter.formatMonto(remisionDTO.getTotal()));
        
        parameters.put("NOMBRE_USUARIO_1", "Artemio Vergara Tolentino");
        parameters.put("FECHA_CREACION_1", Formatter.formatFechaCorta(
                Calendar.getInstance().getTime()));
        parameters.put("PEDIDO_1", String.valueOf(pedido.getId()));
        parameters.put("NOMBRE_CLIENTE_1", cliente.getNombre());
        parameters.put("DIRECCION_CLIENTE_1", cliente.getDireccion());
        parameters.put("TELEFONO_CELULAR_1", cliente.getTelefono());//Arreglar bd para tener el telefono celular
        parameters.put("CP_CLIENTE_1", cliente.getCp());//Arreglar bd para tener el cp_cliente
        parameters.put("CIUDAD_CLIENTE_1", cliente.getEmail()); //Arreglar bd para tener la ciudad del cliente        
        parameters.put("RFC_CLIENTE_1", cliente.getRfc());
        parameters.put("NUMERO_USUARIO_1", "1");
        parameters.put("PRECIO_LETRA_1", ConversionNumTexto.cantidadLetra(remisionDTO.getTotal()));
        parameters.put("SUBTOTAL_PEDIDO_1", Formatter.formatMonto(remisionDTO.getSubtotal()));
        parameters.put("TOTAL_PEDIDO_1", Formatter.formatMonto(remisionDTO.getTotal()));
        OutputStream os = null;
        File reporte = null;
        try {
            JRDataSource datasource = new JRBeanCollectionDataSource(
                    data);
            InputStream jasper = ReporteService.class.getClassLoader().getResourceAsStream(
                    "com/amickom/reportes/casavertical.jasper");
            byte[] report = JasperRunManager.runReportToPdf(jasper,
                    parameters, datasource);
            reporte = new File("/notaremision" + pedido.getId() + ".pdf");
            os = new FileOutputStream(reporte);
            os.write(report);
        } catch (JRException e) {
            log.error("Error al generar el reporte " + e.getMessage(), e);
        } catch (FileNotFoundException e) {
            log.error("Error al generar el reporte " + e.getMessage(), e);
        } catch (IOException e) {
            log.error("Error al generar el reporte " + e.getMessage(), e);
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException ex) {
                    log.error("Error al generar el reporte "
                            + ex.getMessage(), ex);
                }
            }
        }
        return reporte.getAbsolutePath();
    }

    @Override
    public String ventasxCliente(VentasxClienteDTO ventas) throws RefaccionariaException {
        log.debug("Iniciando la generación de reporte de ventas x cliente: ");
        List<PedidoProducto> pedidos = ventas.getProductopedido();
        List<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
        for (PedidoProducto producto : pedidos) {
            HashMap<String, String> fields = new HashMap<String, String>();
            fields.put("cantidad", String.valueOf(producto.getCantidad()));
            fields.put("codigo", producto.getProductos().getCodigo());
            fields.put("descripcion", producto.getProductos().getDescripcion());
            double precioTotalProducto =
                    (producto.getProductos().getPrecio()
                    * producto.getCantidad());
            double utilidadProducto =
                    (producto.getUtilidad() / 100
                    * (producto.getProductos().getPrecio()));
            //Al precio de cada producto se le suma la utilidad 
            double precioUnitario = producto.getProductos().getPrecio() + utilidadProducto;
            fields.put("preciounitario", Formatter.formatMonto(precioUnitario));
            fields.put("preciototal", Formatter.formatMonto(precioTotalProducto + (utilidadProducto * producto.getCantidad())));
            fields.put("proveedor", producto.getEmpresa());
            fields.put("pedido", String.valueOf(producto.getIdPedido()));
            fields.put("fecha", Formatter.formatFechaCorta(producto.getFecha()));
            data.add(fields);
        }
        Cliente cliente = ventas.getCliente();
        HashMap<String, String> parameters = new HashMap<String, String>();
        parameters.put("FECHA_CREACION", Formatter.formatFechaCorta(
                Calendar.getInstance().getTime()));
        parameters.put("NOMBRE_CLIENTE", cliente.getNombre());
        parameters.put("DIRECCION_CLIENTE", cliente.getDireccion());
        parameters.put("TELEFONO_CELULAR", cliente.getTelefono());//Arreglar bd para tener el telefono celular
        parameters.put("CP_CLIENTE", cliente.getCp());//Arreglar bd para tener el cp_cliente
        parameters.put("CIUDAD_CLIENTE", cliente.getEmail()); //Arreglar bd para tener la ciudad del cliente        
        parameters.put("RFC_CLIENTE", cliente.getRfc());
        OutputStream os = null;
        File reporte = null;
        try {
            JRDataSource datasource = new JRBeanCollectionDataSource(
                    data);
            InputStream jasper = ReporteService.class.getClassLoader().getResourceAsStream(
                    "com/amickom/reportes/ventasxclientehorizontal.jasper");
            byte[] report = JasperRunManager.runReportToPdf(jasper,
                    parameters, datasource);
            reporte = new File("/Ventas al cliente " + cliente.getNombre() + ".pdf");
            os = new FileOutputStream(reporte);
            os.write(report);
        } catch (JRException e) {
            log.error("Error al generar el reporte " + e.getMessage(), e);
        } catch (FileNotFoundException e) {
            log.error("Error al generar el reporte " + e.getMessage(), e);
        } catch (IOException e) {
            log.error("Error al generar el reporte " + e.getMessage(), e);
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException ex) {
                    log.error("Error al generar el reporte "
                            + ex.getMessage(), ex);
                }
            }
        }
        return reporte.getAbsolutePath();
    }

    /**
     * Método que genera el reporte de ventas/utilidad por cliente
     * @param ventas ventas encontradas en el periodo de fechas
     * @param fechaInicial fecha Inicial de la venta
     * @param fechaFinal fecha final de la venta
     * @return ruta donde se genero el reporte
     * @throws RefaccionariaException en caso de cualquier excepción 
     */
    public String ventasUtilidadxCliente(List<VentasUtilidadDTO> ventas,
            String fechaInicial, String fechaFinal) throws RefaccionariaException {
        log.debug("Iniciando la generación de reporte de ventas x cliente: ");
        List<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
        double utilidad = 0;
        double total = 0;
        for (VentasUtilidadDTO venta : ventas) {
            HashMap<String, String> fields = new HashMap<String, String>();
            fields.put("cliente", venta.getCliente());
            fields.put("utilidad", Formatter.formatMonto(venta.getUtilidad()));
            fields.put("preciototal", Formatter.formatMonto(venta.getPrecioTotal()));
            utilidad = venta.getUtilidad() + utilidad;
            total = venta.getPrecioTotal() + total;
            data.add(fields);
        }
        HashMap<String, String> parameters = new HashMap<String, String>();
        parameters.put("FECHA_INICIAL", fechaInicial);
        parameters.put("FECHA_FINAL", fechaFinal);
        parameters.put("TOTAL_PEDIDO", Formatter.formatMonto(utilidad));
        parameters.put("SUBTOTAL_PEDIDO", Formatter.formatMonto(total));
        OutputStream os = null;
        File reporte = null;
        try {
            JRDataSource datasource = new JRBeanCollectionDataSource(
                    data);
            InputStream jasper = ReporteService.class.getClassLoader().getResourceAsStream(
                    "com/amickom/reportes/ventasutilidad.jasper");
            byte[] report = JasperRunManager.runReportToPdf(jasper,
                    parameters, datasource);
            reporte = new File("/ReporteUtilidad "
                    + Formatter.formatFechaLarga(Calendar.getInstance().getTime()) + ".pdf");
            os = new FileOutputStream(reporte);
            os.write(report);
        } catch (JRException e) {
            log.error("Error al generar el reporte " + e.getMessage(), e);
        } catch (FileNotFoundException e) {
            log.error("Error al generar el reporte " + e.getMessage(), e);
        } catch (IOException e) {
            log.error("Error al generar el reporte " + e.getMessage(), e);
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException ex) {
                    log.error("Error al generar el reporte "
                            + ex.getMessage(), ex);
                }
            }
        }
        return reporte.getAbsolutePath();
    }

    @Override
    public String ventasxProveedor(VentasxProveedorDTO ventas) throws RefaccionariaException {
        log.debug("Iniciando la generación de reporte de ventas x cliente: ");
        List<PedidoProducto> pedidos = ventas.getProductopedido();
        List<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
        for (PedidoProducto producto : pedidos) {
            HashMap<String, String> fields = new HashMap<String, String>();
            fields.put("cantidad", String.valueOf(producto.getCantidad()));
            fields.put("codigo", producto.getProductos().getCodigo());
            fields.put("descripcion", producto.getProductos().getDescripcion());
            double precioTotalProducto =
                    (producto.getProductos().getPrecio()
                    * producto.getCantidad());
            double utilidadProducto =
                    (producto.getUtilidad() / 100
                    * producto.getProductos().getPrecio());
            //Al precio de cada producto se le suma la utilidad 
            double precioUnitario = producto.getProductos().getPrecio() + utilidadProducto;
            fields.put("preciounitario", Formatter.formatMonto(precioUnitario));
            fields.put("preciototal", Formatter.formatMonto(precioTotalProducto + (utilidadProducto * producto.getCantidad())));
            fields.put("proveedor", producto.getEmpresa());
            fields.put("pedido", String.valueOf(producto.getIdPedido()));
            fields.put("fecha", Formatter.formatFechaCorta(producto.getFecha()));
            data.add(fields);
        }
        Proveedor cliente = ventas.getProveedor();
        HashMap<String, String> parameters = new HashMap<String, String>();
        parameters.put("FECHA_CREACION", Formatter.formatFechaCorta(
                Calendar.getInstance().getTime()));
        parameters.put("NOMBRE_CLIENTE", cliente.getEmpresa());
        parameters.put("DIRECCION_CLIENTE", cliente.getDireccion());
        parameters.put("TELEFONO_CELULAR", cliente.getTelefono());//Arreglar bd para tener el telefono celular
        parameters.put("CP_CLIENTE", cliente.getCp());//Arreglar bd para tener el cp_cliente
        parameters.put("CIUDAD_CLIENTE", cliente.getEmail()); //Arreglar bd para tener la ciudad del cliente        
        parameters.put("RFC_CLIENTE", cliente.getRfc());
        OutputStream os = null;
        File reporte = null;
        try {
            JRDataSource datasource = new JRBeanCollectionDataSource(
                    data);
            InputStream jasper = ReporteService.class.getClassLoader().getResourceAsStream(
                    "com/amickom/reportes/ventasxproveedor.jasper");
            byte[] report = JasperRunManager.runReportToPdf(jasper,
                    parameters, datasource);
            reporte = new File("/Pedidos a la empresa " + cliente.getEmpresa() + ".pdf");
            os = new FileOutputStream(reporte);
            os.write(report);
        } catch (JRException e) {
            log.error("Error al generar el reporte " + e.getMessage(), e);
        } catch (FileNotFoundException e) {
            log.error("Error al generar el reporte " + e.getMessage(), e);
        } catch (IOException e) {
            log.error("Error al generar el reporte " + e.getMessage(), e);
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException ex) {
                    log.error("Error al generar el reporte "
                            + ex.getMessage(), ex);
                }
            }
        }
        return reporte.getAbsolutePath();
    }
}
