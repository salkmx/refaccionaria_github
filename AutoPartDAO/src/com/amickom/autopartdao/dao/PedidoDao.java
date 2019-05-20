package com.amickom.autopartdao.dao;

import com.amickom.autopartdao.dto.Pedido;
import com.amickom.autopartdao.dto.PedidoPk;
import com.amickom.autopartdao.exceptions.PedidoDaoException;
import java.util.Date;
import java.util.List;

public interface PedidoDao {

    /**
     * Method 'insert'
     * 
     * @param dto
     * @return PedidoPk
     */
    public PedidoPk insert(Pedido dto);

    /** 
     * Updates a single row in the PEDIDO table.
     */
    public void update(PedidoPk pk, Pedido dto) throws PedidoDaoException;

    /** 
     * Deletes a single row in the PEDIDO table.
     */
    public void delete(PedidoPk pk) throws PedidoDaoException;

    /** 
     * Returns all rows from the PEDIDO table that match the criteria 'ID = :id'.
     */
    public Pedido findByPrimaryKey(Integer id) throws PedidoDaoException;

    /** 
     * Returns all rows from the PEDIDO table that match the criteria ''.
     */
    public List<Pedido> findAll() throws PedidoDaoException;

    /** 
     * Returns all rows from the PEDIDO table that match the criteria 'ID = :id'.
     */
    public List<Pedido> findByCliente(Integer id) throws PedidoDaoException;

    /** 
     * Returns all rows from the PEDIDO table that match the criteria 'ID = :id'.
     */
    public List<Pedido> findWhereIdEquals(Integer id) throws PedidoDaoException;

    /** 
     * Returns all rows from the PEDIDO table that match the criteria 'ID_CLIENTE = :idCliente'.
     */
    public List<Pedido> findWhereIdClienteEquals(Integer idCliente) throws PedidoDaoException;

    /** 
     * Returns all rows from the PEDIDO table that match the criteria 'FECHA_ALTA = :fechaAlta'.
     */
    public List<Pedido> findWhereFechaAltaEquals(Date fechaAlta) throws PedidoDaoException;

    /** 
     * Returns all rows from the PEDIDO table that match the criteria 'PRECIO = :precio'.
     */
    public List<Pedido> findWherePrecioEquals(Double precio) throws PedidoDaoException;

    /** 
     * Returns all rows from the PEDIDO table that match the criteria 'IVA = :iva'.
     */
    public List<Pedido> findWhereIvaEquals(Double iva) throws PedidoDaoException;

    /** 
     * Returns all rows from the PEDIDO table that match the criteria 'ID_USUARIO = :idUsuario'.
     */
    public List<Pedido> findWhereIdUsuarioEquals(Integer idUsuario) throws PedidoDaoException;

    /** 
     * Returns the rows from the PEDIDO table that matches the specified primary-key value.
     */
    public Pedido findByPrimaryKey(PedidoPk pk) throws PedidoDaoException;
}
