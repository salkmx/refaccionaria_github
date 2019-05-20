package com.amickom.autopartdao.dao;

import com.amickom.autopartdao.dto.Cliente;
import com.amickom.autopartdao.dto.ClientePk;
import com.amickom.autopartdao.dto.VentasUtilidadDTO;
import com.amickom.autopartdao.exceptions.ClienteDaoException;
import java.util.Date;
import java.util.List;

public interface ClienteDao {

    /**
     * Method 'insert'
     * 
     * @param dto
     * @return ClientePk
     */
    public ClientePk insert(Cliente dto);

    /** 
     * Updates a single row in the CLIENTE table.
     */
    public void update(ClientePk pk, Cliente dto) throws ClienteDaoException;
    
        /** 
     * Updates a single row in the CLIENTE table.
     */
    public boolean update(Cliente dto) throws ClienteDaoException;

    /** 
     * Deletes a single row in the CLIENTE table.
     */
    public void delete(ClientePk pk) throws ClienteDaoException;

    /** 
     * Deletes a single row in the CLIENTE table.
     */
    public boolean delete(String nombre) throws ClienteDaoException;

    /** 
     * Returns all rows from the CLIENTE table that match the criteria 'ID = :id'.
     */
    public Cliente findByPrimaryKey(Integer id) throws ClienteDaoException;

    /** 
     * Returns all rows from the CLIENTE table that match the criteria ''.
     */
    public List<Cliente> findAll() throws ClienteDaoException;

    /** 
     * Returns all rows from the CLIENTE table that match the criteria 'ID = :id'.
     */
    public List<Cliente> findWhereIdEquals(Integer id) throws ClienteDaoException;

    /** 
     * Returns all rows from the CLIENTE table that match the criteria 'NOMBRE = :nombre'.
     */
    public List<Cliente> findWhereNombreEquals(String nombre) throws ClienteDaoException;

    /** 
     * Returns all rows from the CLIENTE table that match the criteria 'RFC = :rfc'.
     */
    public List<Cliente> findWhereRfcEquals(String rfc) throws ClienteDaoException;

    /** 
     * Returns all rows from the CLIENTE table that match the criteria 'DIRECCION = :direccion'.
     */
    public List<Cliente> findWhereDireccionEquals(String direccion) throws ClienteDaoException;

    /** 
     * Returns all rows from the CLIENTE table that match the criteria 'TELEFONO = :telefono'.
     */
    public List<Cliente> findWhereTelefonoEquals(String telefono) throws ClienteDaoException;

    /** 
     * Returns all rows from the CLIENTE table that match the criteria 'EMAIL = :email'.
     */
    public List<Cliente> findWhereEmailEquals(String email) throws ClienteDaoException;

    /** 
     * Returns all rows from the CLIENTE table that match the criteria 'FECHA_REGISTRO = :fechaRegistro'.
     */
    public List<Cliente> findWhereFechaRegistroEquals(Date fechaRegistro) throws ClienteDaoException;

    /** 
     * Returns the rows from the CLIENTE table that matches the specified primary-key value.
     */
    public Cliente findByPrimaryKey(ClientePk pk) throws ClienteDaoException;
    
    /**
     * Método que obtiene la utilidad y las ventas que se han realizado a un grupo 
     * de clientes en base a una fecha inicial y final
     * @param fechaInicial Inicio del perido
     * @param fechaFinal Fin del periodo
     * @return List<VentasUtilidadDTO> lista con la utilidad
     * @throws ClienteDaoException en caso de cualquier excepción 
     */
    public List<VentasUtilidadDTO> obtieneVentasUtilidad(Date fechaInicial, Date fechaFinal) 
            throws ClienteDaoException;

}
