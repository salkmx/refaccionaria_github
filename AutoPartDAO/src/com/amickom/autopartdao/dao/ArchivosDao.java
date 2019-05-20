package com.amickom.autopartdao.dao;

import com.amickom.autopartdao.dto.Archivos;
import com.amickom.autopartdao.dto.ArchivosPk;
import com.amickom.autopartdao.exceptions.ArchivosDaoException;
import java.util.Date;
import java.util.List;

public interface ArchivosDao {

    /**
     * Method 'insert'
     * 
     * @param dto
     * @return ArchivosPk
     */
    public ArchivosPk insert(String ruta, int idproveedor);

    /**
     * Method 'insert'
     * 
     * @param dto
     * @return ArchivosPk
     */
    public ArchivosPk insert(Archivos dto);

    /** 
     * Updates a single row in the ARCHIVOS table.
     */
    public void update(ArchivosPk pk, Archivos dto) throws ArchivosDaoException;

    /** 
     * Deletes a single row in the ARCHIVOS table.
     */
    public void delete(ArchivosPk pk) throws ArchivosDaoException;

    /** 
     * Returns all rows from the ARCHIVOS table that match the criteria 'ID = :id'.
     */
    public Archivos findByPrimaryKey(int id) throws ArchivosDaoException;

    /** 
     * Returns all rows from the ARCHIVOS table that match the criteria ''.
     */
    public List<Archivos> findAll() throws ArchivosDaoException;

    /** 
     * Returns all rows from the ARCHIVOS table that match the criteria 'ID_PROVEEDOR = :idProveedor'.
     */
    public List<Archivos> findByProveedor(int idProveedor) throws ArchivosDaoException;

    /** 
     * Returns all rows from the ARCHIVOS table that match the criteria 'ID = :id'.
     */
    public List<Archivos> findWhereIdEquals(int id) throws ArchivosDaoException;

    /** 
     * Returns all rows from the ARCHIVOS table that match the criteria 'NOMBRE = :nombre'.
     */
    public List<Archivos> findWhereNombreEquals(String nombre) throws ArchivosDaoException;

    /** 
     * Returns all rows from the ARCHIVOS table that match the criteria 'ARCHIVO = :archivo'.
     */
    public List<Archivos> findWhereArchivoEquals(String archivo) throws ArchivosDaoException;

    /** 
     * Returns all rows from the ARCHIVOS table that match the criteria 'ID_PROVEEDOR = :idProveedor'.
     */
    public List<Archivos> findWhereIdProveedorEquals(int idProveedor) throws ArchivosDaoException;

    /** 
     * Returns all rows from the ARCHIVOS table that match the criteria 'FECHA_CAPTURA = :fechaCaptura'.
     */
    public List<Archivos> findWhereFechaCapturaEquals(Date fechaCaptura) throws ArchivosDaoException;

    /** 
     * Returns the rows from the ARCHIVOS table that matches the specified primary-key value.
     */
    public Archivos findByPrimaryKey(ArchivosPk pk) throws ArchivosDaoException;
}
