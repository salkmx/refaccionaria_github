/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amickom.service.impl;

import com.amickom.autopartdao.dao.ClienteDao;
import com.amickom.autopartdao.dao.PedidoProductoDao;
import com.amickom.autopartdao.dto.Cliente;
import com.amickom.autopartdao.dto.ClientePk;
import com.amickom.autopartdao.dto.PedidoProducto;
import com.amickom.autopartdao.dto.VentasUtilidadDTO;
import com.amickom.autopartdao.dto.VentasxClienteDTO;
import com.amickom.autopartdao.exceptions.ClienteDaoException;
import com.amickom.autopartdao.exceptions.PedidoProductoDaoException;
import com.amickom.service.IClienteService;
import com.amickom.service.exception.RefaccionariaException;
import com.amickom.service.util.ComboModelCliente;
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
@Service("clienteService")
public class ClienteService implements IClienteService {

    private static Logger logger = Logger.getLogger(ClienteService.class);
    @Autowired
    @Qualifier("ClienteDao")
    private ClienteDao dao;
    @Autowired
    @Qualifier("PedidoProductoDao")
    private PedidoProductoDao pedidoProductoDao;

    @Override
    public boolean insertaCliente(Cliente cliente) throws RefaccionariaException {
        logger.debug("Iniciando inserción de Cliente ");
        boolean seInserto = false;
        try {
            ClientePk pk = dao.insert(cliente);
            if (pk.getId() != null) {
                logger.debug("Se inserto correctamente el Cliente " + pk.getId());
                seInserto = true;
            }
        } catch (Exception e) {
            logger.error("Error al realizar la inserción " + e.getMessage(), e);
        }
        return seInserto;
    }

    @Override
    public ComboModelCliente obtieneModelCliente() throws RefaccionariaException {
        ComboModelCliente model = null;
        try {
            logger.debug("Obteniendo modelo de datos para clientes");
            List<Cliente> clientes = dao.findAll();
            model = new ComboModelCliente(clientes);
        } catch (ClienteDaoException ex) {
            logger.error("Error al obetner la lista de clientes" + ex.getMessage(), ex);
        }
        return model;
    }

    @Override
    public Cliente obtieneDatosCliente(String nombre) throws RefaccionariaException {
        Cliente cliente = null;
        logger.debug("Buscando los datos del cliente " + nombre);
        try {
            List<Cliente> clientes = dao.findWhereNombreEquals(nombre);
            if (clientes != null && !clientes.isEmpty()) {
                logger.debug("Se encontraron " + clientes.size());
                cliente = clientes.get(0);
            }
        } catch (ClienteDaoException ex) {
            logger.error("Error al obtener los datos del cliente " + ex.getMessage(), ex);
        }
        return cliente;
    }

    @Override
    public boolean eliminaCliente(String nombre) throws RefaccionariaException {
        boolean eliminado = false;
        logger.debug("Eliminando el cliente " + nombre);
        try {
            eliminado = dao.delete(nombre);
        } catch (ClienteDaoException ex) {
            logger.error("Error al eliminar el cliente " + ex.getMessage(), ex);
        }
        return eliminado;
    }

    @Override
    public boolean updateCliente(Cliente cliente) throws RefaccionariaException {
        boolean eliminado = false;
        logger.debug("Actualizando el cliente " + cliente.getNombre());
        try {
            eliminado = dao.update(cliente);
        } catch (ClienteDaoException ex) {
            logger.error("Error al Actualizando el cliente " + ex.getMessage(), ex);
        }
        return eliminado;
    }

    @Override
    public VentasxClienteDTO obtieneVentasxCliente(String nombre) throws RefaccionariaException {
        VentasxClienteDTO ventas = new VentasxClienteDTO();
        Cliente cliente = null;
        logger.debug("Buscando los datos del cliente " + nombre);
        try {
            List<Cliente> clientes = dao.findWhereNombreEquals(nombre);
            if (clientes != null && !clientes.isEmpty()) {
                logger.debug("Se encontraron " + clientes.size());
                cliente = clientes.get(0);
                if (cliente != null) {
                    logger.debug("Obteniendo las ventas que se han realizado al cliente ");
                    List<PedidoProducto> pedidoproducto = pedidoProductoDao.obtieneProductosPedidoCliente(nombre);
                    if (pedidoproducto != null && !pedidoproducto.isEmpty()) {
                        logger.debug("Se encontraron productos " + pedidoproducto.size());
                        ventas.setCliente(cliente);
                        ventas.setProductopedido(pedidoproducto);
                    }
                }
            }
        } catch (PedidoProductoDaoException ex) {
            logger.error("Error al obtener las ventas x cliente " + ex.getMessage(), ex);
        } catch (ClienteDaoException ex) {
            logger.error("Error al obtener los datos del cliente " + ex.getMessage(), ex);
        }
        return ventas;
    }

    @Override
    public VentasxClienteDTO obtieneVentasxClienteFecha(String nombre, 
            String fechaInicial, String fechaFinal) throws RefaccionariaException {
        VentasxClienteDTO ventas = new VentasxClienteDTO();
        Cliente cliente = null;
        logger.debug("Buscando los datos del cliente " + nombre);
        try {
            List<Cliente> clientes = dao.findWhereNombreEquals(nombre);
            if (clientes != null && !clientes.isEmpty()) {
                logger.debug("Se encontraron " + clientes.size());
                cliente = clientes.get(0);
                if (cliente != null) {
                    logger.debug("Obteniendo las ventas que se han realizado al cliente ");
                    List<PedidoProducto> pedidoproducto = pedidoProductoDao.obtieneProductosPedidoCliente(nombre, 
                            Formatter.ddMMyyFormat.parse(fechaInicial), Formatter.ddMMyyFormat.parse(fechaFinal));
                    if (pedidoproducto != null && !pedidoproducto.isEmpty()) {
                        logger.debug("Se encontraron productos " + pedidoproducto.size());
                        ventas.setCliente(cliente);
                        ventas.setProductopedido(pedidoproducto);
                    }
                }
            }
        } catch (ParseException ex) {
            logger.error("Error al obtener las ventas x cliente " + ex.getMessage(), ex);
        } catch (PedidoProductoDaoException ex) {
            logger.error("Error al obtener las ventas x cliente " + ex.getMessage(), ex);
        } catch (ClienteDaoException ex) {
            logger.error("Error al obtener los datos del cliente " + ex.getMessage(), ex);
        }
        return ventas;
    }

    @Override
    public List<VentasUtilidadDTO> obtieneUtilidadVentasxCliente(String fechaInicial,
            String fechaFinal) throws RefaccionariaException {
        List<VentasUtilidadDTO> ventas = null;
        logger.debug("Iniciado la consulta de reporte de "
                + "utilidad/ventas para las fechas " + fechaInicial + " " + fechaFinal);
        try {

            logger.debug("Obteniendo las ventas que se han realizado al cliente ");
            ventas = dao.obtieneVentasUtilidad(
                    Formatter.ddMMyyFormat.parse(fechaInicial),
                    Formatter.ddMMyyFormat.parse(fechaFinal));
            if (ventas != null && !ventas.isEmpty()) {
                logger.debug("Se encontraron ventas " + ventas.size());
            }


        } catch (ParseException ex) {
            logger.error("Error al obtener los datos del cliente " + ex.getMessage(), ex);
        } catch (ClienteDaoException ex) {
            logger.error("Error al obtener los datos del cliente " + ex.getMessage(), ex);
        }
        return ventas;
    }
}
