/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amickom.service.impl;

import com.amickom.autopartdao.dao.PedidoProductoDao;
import com.amickom.autopartdao.dao.ProductosDao;
import com.amickom.autopartdao.dto.PedidoProducto;
import com.amickom.autopartdao.dto.Productos;
import com.amickom.autopartdao.exceptions.ProductosDaoException;
import com.amickom.service.IProductoService;
import com.amickom.service.exception.RefaccionariaException;
import com.amickom.service.util.ComboModelMarca;
import com.amickom.service.util.TableModelConfirmacion;
import com.amickom.service.util.TableModelProductos;
import java.text.DecimalFormat;
import java.util.List;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author david
 */
@Service("productosService")
public class ProductoService implements IProductoService {

    public static final DecimalFormat df = new DecimalFormat("###,###,###,###.00");
    /**
     * 
     */
    private static Logger log = Logger.getLogger(ProductoService.class);
    /**
     * 
     */
    @Autowired
    @Qualifier("ProductosDao")
    private ProductosDao dao;
    @Autowired
    @Qualifier("PedidoProductoDao")
    private PedidoProductoDao daoPedidoProducto;

    @Override
    public ComboModelMarca obtieneMarcas() throws RefaccionariaException {
        ComboModelMarca combo = null;
        try {
            log.debug("Buscando marcas");
            List<String> marcas = dao.findAllMarcas();
            marcas.add("Todas las marcas");
            log.debug("Se encontraron: " + marcas.size());
            combo = new ComboModelMarca(marcas);

        } catch (ProductosDaoException ex) {
            log.error("Error al encontrar las marca "
                    + ex.getMessage(), ex);
        }
        return combo;
    }

    /** @Override
    public DefaultTableModel obtieneProductos(String marca, String codigo)
    throws RefaccionariaException {
    DefaultTableModel model = new DefaultTableModel(
    new Object[][]{},
    new String[]{
    "Seleccionar", "Código", "Descripción", "Precio", "Marca", "Utilidad", "Cantidad"
    }) {
    
    Class[] types = new Class[]{
    Boolean.class, String.class, String.class,
    Double.class, String.class, Double.class, Integer.class
    };
    boolean[] canEdit = new boolean[]{
    false, false, false, false, false, false, false
    };
    
    @Override
    public Class getColumnClass(int columnIndex) {
    return types[columnIndex];
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
    return canEdit[columnIndex];
    }
    };
    try {
    log.debug("Buscando productos");
    List<Productos> productos = dao.findForSale(codigo, marca);
    log.debug("Se encontraron: " + productos.size());
    int i = 0;
    for (Productos producto : productos) {
    model.insertRow(i, new Object[]{Boolean.FALSE,
    producto.getCodigo(), producto.getDescripcion(),
    producto.getPrecio(), producto.getMarca()});
    i++;
    }
    } catch (ProductosDaoException ex) {
    log.error("Error al encontrar las marca "
    + ex.getMessage(), ex);
    }
    return model;
    }**/
    @Override
    public TableModelProductos obtieneProductosP(String marca, String codigo, String proveedor, 
            String nombre)
            throws RefaccionariaException {
        TableModelProductos model = new TableModelProductos(
                new Object[][]{},
                new String[]{
                    "Seleccionar", "Código", "Descripción", "Precio", "Marca", "Utilidad %", "Cantidad", "Precio Venta"
                });
        try {
            log.debug("Buscando productos");
            List<Productos> productos = dao.findForSaleP(codigo, marca, proveedor, nombre);
            log.debug("Se encontraron: " + productos.size());
            int i = 0;
            for (Productos producto : productos) {
                model.insertRow(i, new Object[]{Boolean.FALSE,
                            producto.getCodigo(), producto.getDescripcion(),
                            producto.getPrecio(), producto.getMarca(), producto.getComision(), 0});
                i++;
            }
        } catch (ProductosDaoException ex) {
            log.error("Error al encontrar las marca "
                    + ex.getMessage(), ex);
        }
        return model;
    }

    @Override
    public TableModelConfirmacion obtieneProductosTemp()
            throws RefaccionariaException {
        TableModelConfirmacion model = new TableModelConfirmacion(
                new Object[][]{},
                new String[]{
                    "Código", "Descripción", "Precio", "Marca", "Utilidad %", "Cantidad", "Precio Venta"
                });
        try {
            log.debug("Buscando productos");
            log.debug("Buscando productos");
            List<PedidoProducto> pedidos = dao.findAllTemp();
            log.debug("Se encontraron: " + pedidos.size());
            int i = 0;
            for (PedidoProducto pedido : pedidos) {
                Double precioVenta = ((pedido.getUtilidad() / 100)
                        * pedido.getProductos().getPrecio() + pedido.getProductos().getPrecio()) * pedido.getCantidad();
                model.insertRow(i, new Object[]{
                            pedido.getProductos().getCodigo(), pedido.getProductos().getDescripcion(),
                            pedido.getProductos().getPrecio(), pedido.getProductos().getMarca(),
                            pedido.getUtilidad(), pedido.getCantidad(), precioVenta});
                i++;
            }
        } catch (Exception ex) {
            log.error("Error al encontrar las marca "
                    + ex.getMessage(), ex);
        }
        return model;
    }

    @Override
    public boolean insertaTemp(PedidoProducto producto) throws RefaccionariaException {
        log.debug("Insertando un prodcuto en la tabla temporal ");
        boolean seInserto = false;
        try {
            seInserto = dao.insertTemp(producto);
            log.debug("Se inserto un producto " + seInserto);
        } catch (Exception e) {
            log.error("Error al encontrar las marca "
                    + e.getMessage(), e);
        }
        return seInserto;
    }

    @Override
    public boolean deleteTemp(PedidoProducto producto) throws RefaccionariaException {
        log.debug("Eliminando un producto de la tabla temporal ");
        boolean seInserto = false;
        try {
            seInserto = dao.deleteTemp(producto);
            log.debug("Se elimino un producto " + seInserto);
        } catch (Exception e) {
            log.error("Error al encontrar las marca "
                    + e.getMessage(), e);
        }
        return seInserto;
    }

    @Override
    public boolean deleteAllTemp() throws RefaccionariaException {
        log.debug("Eliminando la tabla temporal ");
        boolean seInserto = false;
        try {
            seInserto = dao.deleteAllTemp();
            log.debug("Se elimino la tabla temporal " + seInserto);
        } catch (Exception e) {
            log.error("Error al encontrar las marca "
                    + e.getMessage(), e);
        }
        return seInserto;
    }

    @Override
    public List<PedidoProducto> obtieneListaProductosPedidoCliente(String nombre) throws RefaccionariaException {
        log.debug("Obteniendo lista de productos por x cliente ");
        List<PedidoProducto> productos = null;
        try {
            productos = daoPedidoProducto.obtieneProductosPedidoCliente(nombre);
            log.debug("Se obtuvieron productos " + productos.size());
        } catch (Exception e) {
            log.error("Error al obtener los productos "
                    + e.getMessage(), e);
        }
        return productos;
    }

    @Override
    public boolean findTemp(String codigo, int cantidad, double utilidad) throws RefaccionariaException {
        log.debug("Buscando si el producto ya está en el pedido ");
        boolean existe = false;
        List<PedidoProducto> productos = null;
        try {
            productos = dao.findTemp(codigo, cantidad, utilidad);
            log.debug("Se obtuvieron productos " + productos.size());
            if (productos != null && !productos.isEmpty()) {
                existe = true;
            }
        } catch (Exception e) {
            log.error("Error al obtener los productos "
                    + e.getMessage(), e);
        }
        return existe;
    }
}
