package com.amickom.autopartdao.dao;

import com.amickom.autopartdao.dto.PedidoProducto;
import com.amickom.autopartdao.dto.PedidoProductoPk;
import com.amickom.autopartdao.exceptions.PedidoProductoDaoException;
import java.util.Date;
import java.util.List;

public interface PedidoProductoDao {

    /**
     * Method 'insert'
     * 
     * @param dto
     * @return PedidoProductoPk
     */
    public boolean insert(PedidoProducto dto);

    /** 
     * Updates a single row in the PEDIDO_PRODUCTO table.
     */
    public void update(PedidoProductoPk pk, PedidoProducto dto) throws PedidoProductoDaoException;

    /** 
     * Deletes a single row in the PEDIDO_PRODUCTO table.
     */
    public void delete(PedidoProductoPk pk) throws PedidoProductoDaoException;

    /** 
     * Returns all rows from the PEDIDO_PRODUCTO table that match the criteria 'ID_PEDIDO = :idPedido AND ID_PRODUCTO = :idProducto'.
     */
    public PedidoProducto findByPrimaryKey(Integer idPedido, Integer idProducto) throws PedidoProductoDaoException;

    /** 
     * Returns all rows from the PEDIDO_PRODUCTO table that match the criteria ''.
     */
    public List<PedidoProducto> findAll() throws PedidoProductoDaoException;

    /** 
     * Returns all rows from the PEDIDO_PRODUCTO table that match the criteria 'ID_PEDIDO = :idPedido'.
     */
    public List<PedidoProducto> findByPedido(Integer idPedido) throws PedidoProductoDaoException;

    /** 
     * Returns all rows from the PEDIDO_PRODUCTO table that match the criteria 'ID_PRODUCTO = :idProducto'.
     */
    public List<PedidoProducto> findByProductos(Integer idProducto) throws PedidoProductoDaoException;

    /** 
     * Returns all rows from the PEDIDO_PRODUCTO table that match the criteria 'ID_PEDIDO = :idPedido'.
     */
    public List<PedidoProducto> findWhereIdPedidoEquals(Integer idPedido) throws PedidoProductoDaoException;

    /** 
     * Returns all rows from the PEDIDO_PRODUCTO table that match the criteria 'ID_PRODUCTO = :idProducto'.
     */
    public List<PedidoProducto> findWhereIdProductoEquals(Integer idProducto) throws PedidoProductoDaoException;

    /** 
     * Returns the rows from the PEDIDO_PRODUCTO table that matches the specified primary-key value.
     */
    public PedidoProducto findByPrimaryKey(PedidoProductoPk pk) throws PedidoProductoDaoException;

    /**
     * 
     * @param cliente
     * @return
     * @throws PedidoProductoDaoException 
     */
    public List<PedidoProducto> obtieneProductosPedidoCliente(String cliente) throws PedidoProductoDaoException;

    /**
     * 
     * @param cliente
     * @return
     * @throws PedidoProductoDaoException 
     */
    public List<PedidoProducto> obtieneProductosPedidoCliente(String cliente,
            Date fechaInicial, Date fechaFinal) throws PedidoProductoDaoException;
    
    /**
     * 
     * @param cliente
     * @return
     * @throws PedidoProductoDaoException 
     */
    public List<PedidoProducto> obtieneProductosPedidoProveedor(String empresa,
            Date fechaInicial, Date fechaFinal) throws PedidoProductoDaoException;

    /**
     * 
     * @param cliente
     * @return
     * @throws PedidoProductoDaoException 
     */
    public List<PedidoProducto> obtieneProductosPedidoProveedor(int pedido,
            int proveedor) throws PedidoProductoDaoException;
}
