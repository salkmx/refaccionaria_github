package com.amickom.autopartdao.dao.spring;

import com.amickom.autopartdao.dao.UsuarioDao;
import com.amickom.autopartdao.dto.Usuario;
import com.amickom.autopartdao.dto.UsuarioPk;
import com.amickom.autopartdao.exceptions.UsuarioDaoException;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class UsuarioDaoImpl extends AbstractDAO implements ParameterizedRowMapper<Usuario>, UsuarioDao {

    protected SimpleJdbcTemplate jdbcTemplate;
    protected DataSource dataSource;

    /**
     * Method 'setDataSource'
     * 
     * @param dataSource
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }

    /**
     * Method 'insert'
     * 
     * @param dto
     * @return UsuarioPk
     */
    @Transactional
    public UsuarioPk insert(Usuario dto) {
        jdbcTemplate.update("INSERT INTO " + getTableName() + " (  CLAVE, PASSWORD, FECHA_ALTA, ROL ) VALUES ( ?, ?, ?, ? )", dto.getClave(), dto.getPassword(), dto.getFechaAlta(), dto.getRol());
        return dto.createPk();
    }

    /** 
     * Updates a single row in the USUARIO table.
     */
    @Transactional
    public void update(UsuarioPk pk, Usuario dto) throws UsuarioDaoException {
        jdbcTemplate.update("UPDATE " + getTableName() + " SET ID = ?, CLAVE = ?, PASSWORD = ?, FECHA_ALTA = ?, ROL = ? WHERE ID = ?", dto.getId(), dto.getClave(), dto.getPassword(), dto.getFechaAlta(), dto.getRol(), pk.getId());
    }

    /** 
     * Deletes a single row in the USUARIO table.
     */
    @Transactional
    public void delete(UsuarioPk pk) throws UsuarioDaoException {
        jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID = ?", pk.getId());
    }

    /**
     * Method 'mapRow'
     * 
     * @param rs
     * @param row
     * @throws SQLException
     * @return Usuario
     */
    public Usuario mapRow(ResultSet rs, int row) throws SQLException {
        Usuario dto = new Usuario();
        dto.setId(new Integer(rs.getInt(1)));
        dto.setClave(rs.getString(2));
        dto.setPassword(rs.getString(3));
        dto.setFechaAlta(rs.getDate(4));
        dto.setRol(rs.getString(5));
        return dto;
    }

    /**
     * Method 'getTableName'
     * 
     * @return String
     */
    public String getTableName() {
        return "app.USUARIO";
    }

    /** 
     * Returns all rows from the USUARIO table that match the criteria 'ID = :id'.
     */
    @Transactional
    public Usuario findByPrimaryKey(Integer id) throws UsuarioDaoException {
        try {
            List<Usuario> list = jdbcTemplate.query("SELECT ID, CLAVE, PASSWORD, FECHA_ALTA, ROL FROM " + getTableName() + " WHERE ID = ?", this, id);
            return list.size() == 0 ? null : list.get(0);
        } catch (Exception e) {
            throw new UsuarioDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the USUARIO table that match the criteria ''.
     */
    @Transactional
    public List<Usuario> findAll() throws UsuarioDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, CLAVE, PASSWORD, FECHA_ALTA, ROL FROM " + getTableName() + " ORDER BY ID", this);
        } catch (Exception e) {
            throw new UsuarioDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the USUARIO table that match the criteria 'ID = :id'.
     */
    @Transactional
    public List<Usuario> findWhereIdEquals(Integer id) throws UsuarioDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, CLAVE, PASSWORD, FECHA_ALTA, ROL FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this, id);
        } catch (Exception e) {
            throw new UsuarioDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the USUARIO table that match the criteria 'CLAVE = :clave'.
     */
    @Transactional
    public List<Usuario> findWhereClaveEquals(String clave) throws UsuarioDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, CLAVE, PASSWORD, FECHA_ALTA, ROL FROM " + getTableName() + " WHERE CLAVE = ? ORDER BY CLAVE", this, clave);
        } catch (Exception e) {
            throw new UsuarioDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the USUARIO table that match the criteria 'PASSWORD = :password'.
     */
    @Transactional
    public List<Usuario> findWherePasswordEquals(String password) throws UsuarioDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, CLAVE, PASSWORD, FECHA_ALTA, ROL FROM " + getTableName() + " WHERE PASSWORD = ? ORDER BY PASSWORD", this, password);
        } catch (Exception e) {
            throw new UsuarioDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the USUARIO table that match the criteria 'FECHA_ALTA = :fechaAlta'.
     */
    @Transactional
    public List<Usuario> findWhereFechaAltaEquals(Date fechaAlta) throws UsuarioDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, CLAVE, PASSWORD, FECHA_ALTA, ROL FROM " + getTableName() + " WHERE FECHA_ALTA = ? ORDER BY FECHA_ALTA", this, fechaAlta);
        } catch (Exception e) {
            throw new UsuarioDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the USUARIO table that match the criteria 'ROL = :rol'.
     */
    @Transactional
    public List<Usuario> findWhereRolEquals(String rol) throws UsuarioDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, CLAVE, PASSWORD, FECHA_ALTA, ROL FROM " + getTableName() + " WHERE ROL = ? ORDER BY ROL", this, rol);
        } catch (Exception e) {
            throw new UsuarioDaoException("Query failed", e);
        }

    }

    /**
     * Verifica las credenciales de seguridad del usuario
     * @param clave usuario con el que se realiza el login en el sistema
     * @param password password del usuario a realizar el login
     * @return boolean true si la scredenciales son verificadas false en 
     * caso contrario
     * @throws UsuarioDaoException en caso de cualquier excepción
     */
    public boolean login(String clave, String password) throws UsuarioDaoException {
        try {
            Object[] args = new Object[]{clave, password};
            List<Usuario> list = jdbcTemplate.query("SELECT ID, CLAVE, PASSWORD, FECHA_ALTA, ROL FROM " + getTableName() + " WHERE CLAVE = ? and PASSWORD = ?", this, args);
            return list.size() == 0 ? false : true;
        } catch (Exception e) {
            throw new UsuarioDaoException("Query failed", e);
        }
    }

    /** 
     * Returns the rows from the USUARIO table that matches the specified primary-key value.
     */
    public Usuario findByPrimaryKey(UsuarioPk pk) throws UsuarioDaoException {
        return findByPrimaryKey(pk.getId());
    }
}
