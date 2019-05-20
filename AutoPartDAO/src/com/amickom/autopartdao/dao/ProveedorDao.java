package com.amickom.autopartdao.dao;

import com.amickom.autopartdao.dto.Proveedor;
import com.amickom.autopartdao.dto.ProveedorPk;
import com.amickom.autopartdao.exceptions.ProveedorDaoException;
import java.util.Date;
import java.util.List;

public interface ProveedorDao {

    /**
     * Method 'insert'
     * 
     * @param dto
     * @return ProveedorPk
     */
    public ProveedorPk insert(Proveedor dto);

    /** 
     * Updates a single row in the PROVEEDOR table.
     */
    public void update(ProveedorPk pk, Proveedor dto) throws ProveedorDaoException;

    /** 
     * Deletes a single row in the PROVEEDOR table.
     */
    public void delete(ProveedorPk pk) throws ProveedorDaoException;

    /** 
     * Returns all rows from the PROVEEDOR table that match the criteria 'ID = :id'.
     */
    public Proveedor findByPrimaryKey(Integer id) throws ProveedorDaoException;

    /** 
     * Returns all rows from the PROVEEDOR table that match the criteria ''.
     */
    public List<Proveedor> findAll() throws ProveedorDaoException;

    /** 
     * Returns all rows from the PROVEEDOR table that match the criteria 'ID = :id'.
     */
    public List<Proveedor> findWhereIdEquals(Integer id) throws ProveedorDaoException;

    /** 
     * Returns all rows from the PROVEEDOR table that match the criteria 'EMPRESA = :empresa'.
     */
    public List<Proveedor> findWhereEmpresaEquals(String empresa) throws ProveedorDaoException;

    /** 
     * Returns all rows from the PROVEEDOR table that match the criteria 'RFC = :rfc'.
     */
    public List<Proveedor> findWhereRfcEquals(String rfc) throws ProveedorDaoException;

    /** 
     * Returns all rows from the PROVEEDOR table that match the criteria 'DIRECCION = :direccion'.
     */
    public List<Proveedor> findWhereDireccionEquals(String direccion) throws ProveedorDaoException;

    /** 
     * Returns all rows from the PROVEEDOR table that match the criteria 'CP = :cp'.
     */
    public List<Proveedor> findWhereCpEquals(String cp) throws ProveedorDaoException;

    /** 
     * Returns all rows from the PROVEEDOR table that match the criteria 'CIUDAD = :ciudad'.
     */
    public List<Proveedor> findWhereCiudadEquals(String ciudad) throws ProveedorDaoException;

    /** 
     * Returns all rows from the PROVEEDOR table that match the criteria 'TELEFONO = :telefono'.
     */
    public List<Proveedor> findWhereTelefonoEquals(String telefono) throws ProveedorDaoException;

    /** 
     * Returns all rows from the PROVEEDOR table that match the criteria 'CELULAR = :celular'.
     */
    public List<Proveedor> findWhereCelularEquals(String celular) throws ProveedorDaoException;

    /** 
     * Returns all rows from the PROVEEDOR table that match the criteria 'EMAIL = :email'.
     */
    public List<Proveedor> findWhereEmailEquals(String email) throws ProveedorDaoException;

    /** 
     * Returns all rows from the PROVEEDOR table that match the criteria 'FECHA_REGISTRO = :fechaRegistro'.
     */
    public List<Proveedor> findWhereFechaRegistroEquals(Date fechaRegistro) throws ProveedorDaoException;

    /** 
     * Returns the rows from the PROVEEDOR table that matches the specified primary-key value.
     */
    public Proveedor findByPrimaryKey(ProveedorPk pk) throws ProveedorDaoException;

    /** 
     * Deletes a single row in the PROVEEDOR table.
     */
    public boolean delete(String nombre) throws ProveedorDaoException;

    /** 
     * Updates a single row in the PROVEEDOR table.
     */
    public boolean update(Proveedor dto) throws ProveedorDaoException;
    
        /** 
     * Returns all rows from the CLIENTE table that match the criteria 'NOMBRE = :nombre'.
     */
    public List<Proveedor> findWhereNombreEquals(String nombre) throws ProveedorDaoException;
    
     /** 
     * Returns all rows from the PROVEEDOR table that match the criteria ''.
     */
    public List<Proveedor> findForPedido(int pedido) throws ProveedorDaoException;
}
