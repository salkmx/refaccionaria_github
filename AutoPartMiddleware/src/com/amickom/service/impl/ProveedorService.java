/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amickom.service.impl;

import com.amickom.autopartdao.dao.ExcelDAO;
import com.amickom.autopartdao.dao.PedidoProductoDao;
import com.amickom.autopartdao.dao.ProductosDao;
import com.amickom.autopartdao.dao.ProveedorDao;
import com.amickom.autopartdao.dto.Productos;
import com.amickom.autopartdao.dto.Proveedor;
import com.amickom.autopartdao.dto.ProveedorPk;
import com.amickom.autopartdao.dto.VentasxProveedorDTO;
import com.amickom.autopartdao.exceptions.PedidoProductoDaoException;
import com.amickom.autopartdao.exceptions.ProveedorDaoException;
import com.amickom.service.IProveedorService;
import com.amickom.service.exception.RefaccionariaException;
import com.amickom.service.util.ComboModelProveedor;
import com.amickom.autopartdao.dto.PedidoProducto;
import com.amickom.service.util.Formatter;
import java.text.ParseException;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author GRUPO HERA HP2
 */
@Service("proveedorService")
public class ProveedorService implements IProveedorService {

    @Autowired
    @Qualifier("ProductosDao")
    private ProductosDao prodDAO;
    @Autowired
    @Qualifier("ExcelDAO")
    private ExcelDAO excelDAO;
    @Autowired
    @Qualifier("ProveedorDao")
    private ProveedorDao dao;
    @Autowired
    @Qualifier("PedidoProductoDao")
    private PedidoProductoDao pedidoProductoDao;
    private static Logger logger = Logger.getLogger(ProveedorService.class);

    @Override
    public boolean insertaProveedor(Proveedor proveedor, String ruta) throws RefaccionariaException {
        logger.debug("Iniciando inserción de proveedor ");
        boolean seInserto = false;
        try {
            ProveedorPk pk = dao.insert(proveedor);
            if (pk.getId() != null) {
                logger.debug("Se inserto correctamente el proveedor " + pk.getId());
                List<Productos> productos = excelDAO.procesaProductos(ruta);
                if (productos != null && !productos.isEmpty()) {
                    logger.debug("Insertando lista de productos");
                    prodDAO.insertaBatch(productos, pk.getId());
                    logger.debug("InsertandO ARCHIVOS");
                    //daoArchivo.insert(ruta, pk.getId());
                }
                seInserto = true;
            }
        } catch (Exception e) {
            logger.error("Error al realizar la inserción " + e.getMessage(), e);
        }
        return seInserto;
    }

    @Override
    public ComboModelProveedor obtieneModelProveedor() throws RefaccionariaException {
        ComboModelProveedor model = null;
        try {
            logger.debug("Obteniendo modelo de datos para proveedores");
            List<Proveedor> proveedores = dao.findAll();
            model = new ComboModelProveedor(proveedores);
        } catch (ProveedorDaoException ex) {
            logger.error("Error al obetner la lista de proveedores " + ex.getMessage(), ex);
        }
        return model;
    }

    @Override
    public ComboModelProveedor obtieneModelProveedorConsulta() throws RefaccionariaException {
        ComboModelProveedor model = null;
        try {
            logger.debug("Obteniendo modelo de datos para proveedores");
            List<Proveedor> proveedores = dao.findAll();
            Proveedor p = new Proveedor();
            p.setEmpresa("Todos los proveedores");
            proveedores.add(p);
            model = new ComboModelProveedor(proveedores);
        } catch (ProveedorDaoException ex) {
            logger.error("Error al obetner la lista de proveedores " + ex.getMessage(), ex);
        }
        return model;
    }

    @Override
    public boolean actualizaCatalogo(String proveedor, String ruta) throws RefaccionariaException {
        logger.debug("Iniciando actualización del catalogo de proveedor " + proveedor);
        boolean seInserto = false;
        try {
            List<Proveedor> proveedores = dao.findWhereEmpresaEquals(proveedor);
            if (proveedores != null && !proveedores.isEmpty()) {
                logger.debug("Obteniendo productos ");
                List<Productos> productos = excelDAO.procesaProductos(ruta);
                logger.debug("Iniciando actualización de catalogo ");
                if (productos != null && !productos.isEmpty()) {
                    logger.debug("Borrando catalogo anterior ");
                    if (prodDAO.deleteIdProveedor(proveedores.get(0).getId())) {
                        logger.debug("Actualizando catalogo ");
                        logger.debug("Insertando lista de productos");
                        prodDAO.insertaBatch(productos, proveedores.get(0).getId());
                        logger.debug("Termino con éxito ");
                        seInserto = true;
                    }
                }

            }
        } catch (Exception e) {
            logger.error("Error al realizar la inserción " + e.getMessage(), e);
        }
        return seInserto;
    }

    @Override
    public boolean eliminaProveedor(String nombre) throws RefaccionariaException {
        boolean eliminado = false;
        logger.debug("Eliminando el proveedor " + nombre);
        try {
            eliminado = dao.delete(nombre);
        } catch (ProveedorDaoException ex) {
            logger.error("Error al eliminar el proveedor " + ex.getMessage(), ex);
        }
        return eliminado;
    }

    @Override
    public boolean updateProveedor(Proveedor proveedor) throws RefaccionariaException {
        boolean eliminado = false;
        logger.debug("Actualizando el proveedor " + proveedor.getEmpresa());
        try {
            eliminado = dao.update(proveedor);
        } catch (ProveedorDaoException ex) {
            logger.error("Error al Actualizando el proveedor " + ex.getMessage(), ex);
        }
        return eliminado;
    }

    @Override
    public Proveedor obtieneDatosProveedor(String nombre) throws RefaccionariaException {
        Proveedor proveedor = null;
        logger.debug("Buscando los datos del proveedor " + nombre);
        try {
            List<Proveedor> proveedores = dao.findWhereNombreEquals(nombre);
            if (proveedores != null && !proveedores.isEmpty()) {
                logger.debug("Se encontraron " + proveedores.size());
                proveedor = proveedores.get(0);
            }
        } catch (ProveedorDaoException ex) {
            logger.error("Error al obtener los datos del proveedor " + ex.getMessage(), ex);
        }
        return proveedor;
    }

    @Override
    public VentasxProveedorDTO obtieneVentasxClienteFecha(String nombre,
            String fechaInicial, String fechaFinal) throws RefaccionariaException {
        VentasxProveedorDTO ventas = new VentasxProveedorDTO();
        Proveedor proveedor = null;
        logger.debug("Buscando los datos del proveedor " + nombre);
        try {
            List<Proveedor> proveedores = dao.findWhereNombreEquals(nombre);
            if (proveedores != null && !proveedores.isEmpty()) {
                logger.debug("Se encontraron " + proveedores.size());
                proveedor = proveedores.get(0);
                if (proveedor != null) {
                    logger.debug("Obteniendo los pedidos que se han realizado al proveedor");
                    List<PedidoProducto> pedidoproducto = pedidoProductoDao.obtieneProductosPedidoProveedor(nombre,
                            Formatter.ddMMyyFormat.parse(fechaInicial), Formatter.ddMMyyFormat.parse(fechaFinal));
                    if (pedidoproducto != null && !pedidoproducto.isEmpty()) {
                        logger.debug("Se encontraron productos " + pedidoproducto.size());
                        ventas.setProveedor(proveedor);
                        ventas.setProductopedido(pedidoproducto);
                    }
                }
            }
        } catch (ParseException ex) {
            logger.error("Error al obtener las ventas x cliente " + ex.getMessage(), ex);
        } catch (PedidoProductoDaoException ex) {
            logger.error("Error al obtener las ventas x cliente " + ex.getMessage(), ex);
        } catch (ProveedorDaoException ex) {
            logger.error("Error al obtener los datos del cliente " + ex.getMessage(), ex);
        }
        return ventas;
    }
}
