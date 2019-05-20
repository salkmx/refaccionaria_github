/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amickom.service.impl;

import com.amickom.autopartdao.dao.ClienteDao;
import com.amickom.autopartdao.dao.PedidoDao;
import com.amickom.autopartdao.dao.PedidoProductoDao;
import com.amickom.autopartdao.dao.ProductosDao;
import com.amickom.autopartdao.dao.ProveedorDao;
import com.amickom.autopartdao.dto.Cliente;
import com.amickom.autopartdao.dto.NotaRemisionDTO;
import com.amickom.autopartdao.dto.Pedido;
import com.amickom.autopartdao.dto.PedidoPk;
import com.amickom.autopartdao.dto.PedidoProducto;
import com.amickom.autopartdao.dto.Productos;
import com.amickom.autopartdao.dto.Proveedor;
import com.amickom.autopartdao.exceptions.ClienteDaoException;
import com.amickom.service.IPedidoService;
import com.amickom.service.IServiciosMail;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author david
 */
@Service("pedidoService")
public class PedidoService implements IPedidoService {

    /**
     * 
     */
    private static Logger log = Logger.getLogger(PedidoService.class);
    @Autowired
    @Qualifier("ClienteDao")
    private ClienteDao clienteDAO;
    @Autowired
    @Qualifier("PedidoDao")
    private PedidoDao pedidoDAO;
    @Autowired
    @Qualifier("PedidoProductoDao")
    private PedidoProductoDao pedidoproductoDAO;
    @Autowired
    @Qualifier("ProductosDao")
    private ProductosDao productosDAO;
    @Autowired
    @Qualifier("ProveedorDao")
    private ProveedorDao proveedorDao;
    @Autowired
    @Qualifier("mailService")
    private IServiciosMail iServiciosMail;

    @Override
    public NotaRemisionDTO altaPedido(String nombre,
            List<PedidoProducto> productos, double iva, double subtotal) {
        NotaRemisionDTO nota = null;
        try {
            log.debug("Buscando id cliente para ligarlo al pedido");
            List<Cliente> clientes = clienteDAO.findWhereNombreEquals(nombre);
            if (clientes != null && !clientes.isEmpty()) {
                double total = iva + subtotal;
                log.debug("Se encontraron clientes " + clientes.size());
                Cliente cliente = clientes.get(0);
                Pedido pedido = new Pedido();
                pedido.setIdCliente(cliente.getId());
                pedido.setIdUsuario(1);
                pedido.setIva(iva);
                pedido.setPrecio(total);
                pedido.setSubtotal(subtotal);
                log.debug("Insertando el pedido");
                PedidoPk pk = pedidoDAO.insert(pedido);
                if (pk.getId() != null) {
                    log.debug("Pedido insertado " + pk.getId());
                    pedido.setId(pk.getId());
                    for (PedidoProducto pedidoproducto : productos) {
                        Productos producto = pedidoproducto.getProductos();
                        log.debug("Insertando productos del pedido ");
                        try {
                            int i = productosDAO.findId(producto.getCodigo(),
                                    producto.getMarca(), producto.getPrecio());
                            if (i > 0) {
                                log.debug("Se encontro el producto: " + i);
                                pedidoproducto.setIdPedido(pk.getId());
                                pedidoproducto.setIdProducto(i);
                                if (pedidoproductoDAO.insert(pedidoproducto)) {
                                    log.debug("Se iserto correctamente el pedido ");
                                } else {
                                    log.debug("No se puede insertar el producto al pedido "
                                            + pedidoproducto.toString());
                                }
                            }
                        } catch (Exception e) {
                            log.error("Error al insertar el producto al pedido "
                                    + pedidoproducto.toString() + e.getMessage(), e);
                        }

                    }
                    try {
                        log.debug("Eliminando tabla temporal");
                        productosDAO.deleteAllTemp();
                    }
                    catch (Exception e) {
                        log.debug("Error al eliminar la tabla temporal " + e.getMessage(), e);
                    }
                    try {
                        log.debug("Enviando correo a proveedores ");
                        List<Proveedor> proveedores = proveedorDao.findForPedido(pedido.getId());
                        log.debug("Se encontraron proveedores " + proveedores.size());
                        for (Proveedor proveedor : proveedores) {
                            log.debug("Buscando productos para el proveedor " + proveedor.getEmpresa());
                            List<PedidoProducto> productosproveedor =
                                    pedidoproductoDAO.obtieneProductosPedidoProveedor(pedido.getId(),
                                    proveedor.getId());
                            log.debug("Se encontraron productos " + productosproveedor.size());
                            log.debug("Enviando mail ");
                            if (iServiciosMail.enviaMail(proveedor, productosproveedor)) {
                                log.debug("El mail se envio correctamente ");
                            } else {
                                log.debug("No se envío el mail, mandar manualmente");
                            }
                        }
                    } catch (Exception e) {
                        log.error("Error al enviar el correo electronico "
                                + e.getMessage(), e);
                    }
                    nota = new NotaRemisionDTO();
                    nota.setCliente(cliente);
                    nota.setPedido(pedido);
                    nota.setPedidoproducto(productos);
                    nota.setSubtotal(subtotal);
                    nota.setTotal(total);
                }
            }

        } catch (ClienteDaoException ex) {
            log.error("Error al ligar al buscar al cliente "
                    + ex.getMessage(), ex);
        }
        return nota;
    }
}
