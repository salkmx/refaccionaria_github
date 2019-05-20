package com.amickom.autopartdao.dao.spring;

import com.amickom.autopartdao.dao.ArchivosDao;
import com.amickom.autopartdao.dto.Archivos;
import com.amickom.autopartdao.dto.ArchivosPk;
import com.amickom.autopartdao.exceptions.ArchivosDaoException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.transaction.annotation.Transactional;

public class ArchivosDaoImpl extends AbstractDAO implements ParameterizedRowMapper<Archivos>, ArchivosDao {

    protected JdbcTemplate jdbcTemplate;
    protected DataSource dataSource;

    /**
     * Method 'setDataSource'
     * 
     * @param dataSource
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * Method 'insert'
     * 
     * @param dto
     * @return ArchivosPk
     */
    @Transactional
    public ArchivosPk insert(Archivos dto) {
        jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID, NOMBRE, ARCHIVO, ID_PROVEEDOR, FECHA_CAPTURA ) VALUES ( ?, ?, ?, ?, ? )", dto.getId(), dto.getNombre(), dto.getArchivo(), dto.getIdProveedor(), dto.getFechaCaptura());
        return dto.createPk();
    }

    /**
     * Method 'insert'
     * 
     * @param dto
     * @return ArchivosPk
     */
    @Transactional
    public ArchivosPk insert(String ruta, int idproveedor) {
        InputStream is = null;
        try {
            File file = new File(ruta);
            is = new FileInputStream(file);
            SqlLobValue clob = new SqlLobValue(is, new Long(file.length()).intValue());
            Object[] obj = new Object[]{file.getName(), clob, idproveedor};
            jdbcTemplate.update("INSERT INTO " + getTableName() + " ( NOMBRE, ARCHIVO, ID_PROVEEDOR, FECHA_CAPTURA ) VALUES ( ?, ?, ?, CURRENT_DATE)", obj);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArchivosDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                is.close();
            } catch (IOException ex) {
                Logger.getLogger(ArchivosDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return new ArchivosPk();
    }

    /** 
     * Updates a single row in the ARCHIVOS table.
     */
    @Transactional
    public void update(ArchivosPk pk, Archivos dto) throws ArchivosDaoException {
        jdbcTemplate.update("UPDATE " + getTableName() + " SET ID = ?, NOMBRE = ?, ARCHIVO = ?, ID_PROVEEDOR = ?, FECHA_CAPTURA = ? WHERE ID = ?", dto.getId(), dto.getNombre(), dto.getArchivo(), dto.getIdProveedor(), dto.getFechaCaptura(), pk.getId());
    }

    /** 
     * Deletes a single row in the ARCHIVOS table.
     */
    @Transactional
    public void delete(ArchivosPk pk) throws ArchivosDaoException {
        jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID = ?", pk.getId());
    }

    /**
     * Method 'mapRow'
     * 
     * @param rs
     * @param row
     * @throws SQLException
     * @return Archivos
     */
    public Archivos mapRow(ResultSet rs, int row) throws SQLException {
        Archivos dto = new Archivos();
        dto.setId(rs.getInt(1));
        dto.setNombre(rs.getString(2));
        dto.setArchivo(super.getClobColumn(rs, 3));
        dto.setIdProveedor(rs.getInt(4));
        dto.setFechaCaptura(rs.getDate(5));
        return dto;
    }

    /**
     * Method 'getTableName'
     * 
     * @return String
     */
    public String getTableName() {
        return "app.ARCHIVOS";
    }

    /** 
     * Returns all rows from the ARCHIVOS table that match the criteria 'ID = :id'.
     */
    @Transactional
    public Archivos findByPrimaryKey(int id) throws ArchivosDaoException {
        try {
            List<Archivos> list = jdbcTemplate.query("SELECT ID, NOMBRE, ARCHIVO, ID_PROVEEDOR, FECHA_CAPTURA FROM " + getTableName() + " WHERE ID = ?", this, id);
            return list.size() == 0 ? null : list.get(0);
        } catch (Exception e) {
            throw new ArchivosDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the ARCHIVOS table that match the criteria ''.
     */
    @Transactional
    public List<Archivos> findAll() throws ArchivosDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, NOMBRE, ARCHIVO, ID_PROVEEDOR, FECHA_CAPTURA FROM " + getTableName() + " ORDER BY ID", this);
        } catch (Exception e) {
            throw new ArchivosDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the ARCHIVOS table that match the criteria 'ID_PROVEEDOR = :idProveedor'.
     */
    @Transactional
    public List<Archivos> findByProveedor(int idProveedor) throws ArchivosDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, NOMBRE, ARCHIVO, ID_PROVEEDOR, FECHA_CAPTURA FROM " + getTableName() + " WHERE ID_PROVEEDOR = ?", this, idProveedor);
        } catch (Exception e) {
            throw new ArchivosDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the ARCHIVOS table that match the criteria 'ID = :id'.
     */
    @Transactional
    public List<Archivos> findWhereIdEquals(int id) throws ArchivosDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, NOMBRE, ARCHIVO, ID_PROVEEDOR, FECHA_CAPTURA FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this, id);
        } catch (Exception e) {
            throw new ArchivosDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the ARCHIVOS table that match the criteria 'NOMBRE = :nombre'.
     */
    @Transactional
    public List<Archivos> findWhereNombreEquals(String nombre) throws ArchivosDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, NOMBRE, ARCHIVO, ID_PROVEEDOR, FECHA_CAPTURA FROM " + getTableName() + " WHERE NOMBRE = ? ORDER BY NOMBRE", this, nombre);
        } catch (Exception e) {
            throw new ArchivosDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the ARCHIVOS table that match the criteria 'ARCHIVO = :archivo'.
     */
    @Transactional
    public List<Archivos> findWhereArchivoEquals(String archivo) throws ArchivosDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, NOMBRE, ARCHIVO, ID_PROVEEDOR, FECHA_CAPTURA FROM " + getTableName() + " WHERE ARCHIVO = ? ORDER BY ARCHIVO", this, archivo);
        } catch (Exception e) {
            throw new ArchivosDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the ARCHIVOS table that match the criteria 'ID_PROVEEDOR = :idProveedor'.
     */
    @Transactional
    public List<Archivos> findWhereIdProveedorEquals(int idProveedor) throws ArchivosDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, NOMBRE, ARCHIVO, ID_PROVEEDOR, FECHA_CAPTURA FROM " + getTableName() + " WHERE ID_PROVEEDOR = ? ORDER BY ID_PROVEEDOR", this, idProveedor);
        } catch (Exception e) {
            throw new ArchivosDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the ARCHIVOS table that match the criteria 'FECHA_CAPTURA = :fechaCaptura'.
     */
    @Transactional
    public List<Archivos> findWhereFechaCapturaEquals(Date fechaCaptura) throws ArchivosDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, NOMBRE, ARCHIVO, ID_PROVEEDOR, FECHA_CAPTURA FROM " + getTableName() + " WHERE FECHA_CAPTURA = ? ORDER BY FECHA_CAPTURA", this, fechaCaptura);
        } catch (Exception e) {
            throw new ArchivosDaoException("Query failed", e);
        }

    }

    /** 
     * Returns the rows from the ARCHIVOS table that matches the specified primary-key value.
     */
    public Archivos findByPrimaryKey(ArchivosPk pk) throws ArchivosDaoException {
        return findByPrimaryKey(pk.getId());
    }
}
