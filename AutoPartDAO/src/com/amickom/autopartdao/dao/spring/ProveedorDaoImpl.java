package com.amickom.autopartdao.dao.spring;

import com.amickom.autopartdao.dao.ProveedorDao;
import com.amickom.autopartdao.dto.Proveedor;
import com.amickom.autopartdao.dto.ProveedorPk;
import com.amickom.autopartdao.exceptions.ProveedorDaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.transaction.annotation.Transactional;

public class ProveedorDaoImpl extends AbstractDAO implements ParameterizedRowMapper<Proveedor>, ProveedorDao {

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
     * @return ProveedorPk
     */
    @Transactional
    public ProveedorPk insert(final Proveedor dto) {
        ProveedorPk pk = dto.createPk();
        GeneratedKeyHolder gkh = new GeneratedKeyHolder();
        try {
            PreparedStatementCreator psc = new PreparedStatementCreator() {

                @Override
                public PreparedStatement createPreparedStatement(Connection connection)
                        throws SQLException {
                    PreparedStatement stmtSaveFile =
                            connection.prepareStatement("INSERT INTO " + getTableName() + " (EMPRESA, RFC, DIRECCION, CP, CIUDAD, TELEFONO, CELULAR, EMAIL, FECHA_REGISTRO, estatus, COMISION_FIJA, porcentaje_comision ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, 1, ?, ? )",
                            new int[]{1});
                    stmtSaveFile.setString(1, dto.getEmpresa());
                    stmtSaveFile.setString(2, dto.getRfc());
                    stmtSaveFile.setString(3, dto.getDireccion());
                    stmtSaveFile.setString(4, dto.getCp());
                    stmtSaveFile.setString(5, dto.getCiudad());
                    stmtSaveFile.setString(6, dto.getTelefono());
                    stmtSaveFile.setString(7, dto.getCelular());
                    stmtSaveFile.setString(8, dto.getEmail());
                    stmtSaveFile.setDate(9, new java.sql.Date(dto.getFechaRegistro().getTime()));
                    stmtSaveFile.setInt(10, dto.getComision_fija());
                    stmtSaveFile.setDouble(11, dto.getPorcentaje_comision());
                    return stmtSaveFile;
                }
            };
            //int i = jdbcTemplate.update("INSERT INTO " + getTableName() + " (EMPRESA, RFC, DIRECCION, CP, CIUDAD, TELEFONO, CELULAR, EMAIL, FECHA_REGISTRO ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? )", dto.getEmpresa(),dto.getRfc(),dto.getDireccion(),dto.getCp(),dto.getCiudad(),dto.getTelefono(),dto.getCelular(),dto.getEmail(),dto.getFechaRegistro());
            jdbcTemplate.update(psc, gkh);
            pk.setId(gkh.getKey().intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pk;
    }

    /** 
     * Updates a single row in the PROVEEDOR table.
     */
    @Transactional
    public void update(ProveedorPk pk, Proveedor dto) throws ProveedorDaoException {
        jdbcTemplate.update("UPDATE " + getTableName() + " SET ID = ?, EMPRESA = ?, RFC = ?, DIRECCION = ?, CP = ?, CIUDAD = ?, TELEFONO = ?, CELULAR = ?, EMAIL = ?, FECHA_REGISTRO = ? WHERE ID = ?", dto.getId(), dto.getEmpresa(), dto.getRfc(), dto.getDireccion(), dto.getCp(), dto.getCiudad(), dto.getTelefono(), dto.getCelular(), dto.getEmail(), dto.getFechaRegistro(), pk.getId());
    }

    /** 
     * Deletes a single row in the PROVEEDOR table.
     */
    @Transactional
    public void delete(ProveedorPk pk) throws ProveedorDaoException {
        jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID = ?", pk.getId());
    }

    /**
     * Method 'mapRow'
     * 
     * @param rs
     * @param row
     * @throws SQLException
     * @return Proveedor
     */
    public Proveedor mapRow(ResultSet rs, int row) throws SQLException {
        Proveedor dto = new Proveedor();
        dto.setId(new Integer(rs.getInt(1)));
        dto.setEmpresa(rs.getString(2));
        dto.setRfc(rs.getString(3));
        dto.setDireccion(rs.getString(4));
        dto.setCp(rs.getString(5));
        dto.setCiudad(rs.getString(6));
        dto.setTelefono(rs.getString(7));
        dto.setCelular(rs.getString(8));
        dto.setEmail(rs.getString(9));
        dto.setFechaRegistro(rs.getDate(10));
        dto.setComision_fija(rs.getInt(11));
        dto.setPorcentaje_comision(rs.getDouble(12));
        return dto;
    }

    /**
     * Method 'getTableName'
     * 
     * @return String
     */
    public String getTableName() {
        return "app.PROVEEDOR";
    }

    /** 
     * Returns all rows from the PROVEEDOR table that match the criteria 'ID = :id'.
     */
    @Transactional
    public Proveedor findByPrimaryKey(Integer id) throws ProveedorDaoException {
        try {
            List<Proveedor> list = jdbcTemplate.query("SELECT ID, EMPRESA, RFC, DIRECCION, CP, CIUDAD, TELEFONO, CELULAR, EMAIL, FECHA_REGISTRO FROM " + getTableName() + " WHERE ID = ?", this, id);
            return list.size() == 0 ? null : list.get(0);
        } catch (Exception e) {
            throw new ProveedorDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PROVEEDOR table that match the criteria ''.
     */
    @Transactional
    public List<Proveedor> findAll() throws ProveedorDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, EMPRESA, RFC, DIRECCION, CP, CIUDAD, TELEFONO, CELULAR, EMAIL, FECHA_REGISTRO, COMISION_FIJA, porcentaje_comision FROM " + getTableName() + " where estatus = 1 ORDER BY ID", this);
        } catch (Exception e) {
            throw new ProveedorDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PROVEEDOR table that match the criteria 'ID = :id'.
     */
    @Transactional
    public List<Proveedor> findWhereIdEquals(Integer id) throws ProveedorDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, EMPRESA, RFC, DIRECCION, CP, CIUDAD, TELEFONO, CELULAR, EMAIL, FECHA_REGISTRO FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this, id);
        } catch (Exception e) {
            throw new ProveedorDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PROVEEDOR table that match the criteria 'EMPRESA = :empresa'.
     */
    @Transactional
    public List<Proveedor> findWhereEmpresaEquals(String empresa) throws ProveedorDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, EMPRESA, RFC, DIRECCION, CP, CIUDAD, TELEFONO, CELULAR, EMAIL, FECHA_REGISTRO, COMISION_FIJA, porcentaje_comision FROM " + getTableName() + " WHERE EMPRESA = ? ORDER BY EMPRESA", this, empresa);
        } catch (Exception e) {
            throw new ProveedorDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PROVEEDOR table that match the criteria 'RFC = :rfc'.
     */
    @Transactional
    public List<Proveedor> findWhereRfcEquals(String rfc) throws ProveedorDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, EMPRESA, RFC, DIRECCION, CP, CIUDAD, TELEFONO, CELULAR, EMAIL, FECHA_REGISTRO FROM " + getTableName() + " WHERE RFC = ? ORDER BY RFC", this, rfc);
        } catch (Exception e) {
            throw new ProveedorDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PROVEEDOR table that match the criteria 'DIRECCION = :direccion'.
     */
    @Transactional
    public List<Proveedor> findWhereDireccionEquals(String direccion) throws ProveedorDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, EMPRESA, RFC, DIRECCION, CP, CIUDAD, TELEFONO, CELULAR, EMAIL, FECHA_REGISTRO FROM " + getTableName() + " WHERE DIRECCION = ? ORDER BY DIRECCION", this, direccion);
        } catch (Exception e) {
            throw new ProveedorDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PROVEEDOR table that match the criteria 'CP = :cp'.
     */
    @Transactional
    public List<Proveedor> findWhereCpEquals(String cp) throws ProveedorDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, EMPRESA, RFC, DIRECCION, CP, CIUDAD, TELEFONO, CELULAR, EMAIL, FECHA_REGISTRO FROM " + getTableName() + " WHERE CP = ? ORDER BY CP", this, cp);
        } catch (Exception e) {
            throw new ProveedorDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PROVEEDOR table that match the criteria 'CIUDAD = :ciudad'.
     */
    @Transactional
    public List<Proveedor> findWhereCiudadEquals(String ciudad) throws ProveedorDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, EMPRESA, RFC, DIRECCION, CP, CIUDAD, TELEFONO, CELULAR, EMAIL, FECHA_REGISTRO FROM " + getTableName() + " WHERE CIUDAD = ? ORDER BY CIUDAD", this, ciudad);
        } catch (Exception e) {
            throw new ProveedorDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PROVEEDOR table that match the criteria 'TELEFONO = :telefono'.
     */
    @Transactional
    public List<Proveedor> findWhereTelefonoEquals(String telefono) throws ProveedorDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, EMPRESA, RFC, DIRECCION, CP, CIUDAD, TELEFONO, CELULAR, EMAIL, FECHA_REGISTRO FROM " + getTableName() + " WHERE TELEFONO = ? ORDER BY TELEFONO", this, telefono);
        } catch (Exception e) {
            throw new ProveedorDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PROVEEDOR table that match the criteria 'CELULAR = :celular'.
     */
    @Transactional
    public List<Proveedor> findWhereCelularEquals(String celular) throws ProveedorDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, EMPRESA, RFC, DIRECCION, CP, CIUDAD, TELEFONO, CELULAR, EMAIL, FECHA_REGISTRO FROM " + getTableName() + " WHERE CELULAR = ? ORDER BY CELULAR", this, celular);
        } catch (Exception e) {
            throw new ProveedorDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PROVEEDOR table that match the criteria 'EMAIL = :email'.
     */
    @Transactional
    public List<Proveedor> findWhereEmailEquals(String email) throws ProveedorDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, EMPRESA, RFC, DIRECCION, CP, CIUDAD, TELEFONO, CELULAR, EMAIL, FECHA_REGISTRO FROM " + getTableName() + " WHERE EMAIL = ? ORDER BY EMAIL", this, email);
        } catch (Exception e) {
            throw new ProveedorDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PROVEEDOR table that match the criteria 'FECHA_REGISTRO = :fechaRegistro'.
     */
    @Transactional
    public List<Proveedor> findWhereFechaRegistroEquals(Date fechaRegistro) throws ProveedorDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, EMPRESA, RFC, DIRECCION, CP, CIUDAD, TELEFONO, CELULAR, EMAIL, FECHA_REGISTRO FROM " + getTableName() + " WHERE FECHA_REGISTRO = ? ORDER BY FECHA_REGISTRO", this, fechaRegistro);
        } catch (Exception e) {
            throw new ProveedorDaoException("Query failed", e);
        }

    }

    /** 
     * Returns the rows from the PROVEEDOR table that matches the specified primary-key value.
     */
    public Proveedor findByPrimaryKey(ProveedorPk pk) throws ProveedorDaoException {
        return findByPrimaryKey(pk.getId());
    }

    /** 
     * Updates a single row in the CLIENTE table.
     */
    @Transactional
    public boolean update(Proveedor dto) throws ProveedorDaoException {
        int i = 0;
        Object[] args = {dto.getRfc(), dto.getDireccion(), dto.getTelefono(), dto.getCelular(), dto.getCp(), dto.getCiudad(), dto.getEmail(), dto.getComision_fija(), dto.getPorcentaje_comision(), dto.getEmpresa()};
        try {
            i = jdbcTemplate.update("UPDATE " + getTableName() + " set rfc = ?, DIRECCION = ?, TELEFONO = ?, celular = ?, cp = ?, ciudad = ?, EMAIL = ?, COMISION_FIJA = ?, porcentaje_comision = ? WHERE empresa = ?", args);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return i > 0 ? true : false;
    }

    /** 
     * Deletes a single row in the CLIENTE table.
     */
    @Transactional
    public boolean delete(String nombre) throws ProveedorDaoException {
        int i = jdbcTemplate.update("UPDATE " + getTableName() + " set estatus = 0 WHERE empresa = ?", nombre);
        return i > 0 ? true : false;
    }

    /** 
     * Returns all rows from the CLIENTE table that match the criteria 'NOMBRE = :nombre'.
     *         dto.setId(new Integer(rs.getInt(1)));
    dto.setEmpresa(rs.getString(2));
    dto.setRfc(rs.getString(3));
    dto.setDireccion(rs.getString(4));
    dto.setCp(rs.getString(5));
    dto.setCiudad(rs.getString(6));
    dto.setTelefono(rs.getString(7));
    dto.setCelular(rs.getString(8));
    dto.setEmail(rs.getString(9));
    dto.setFechaRegistro(rs.getDate(10));
     */
    @Transactional
    public List<Proveedor> findWhereNombreEquals(String nombre) throws ProveedorDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, empresa, RFC, DIRECCION, cp, ciudad, TELEFONO, celular,   EMAIL, FECHA_REGISTRO, COMISION_FIJA, porcentaje_comision FROM " + getTableName() + " WHERE empresa = ? and estatus = 1 ORDER BY empresa", this, nombre);
        } catch (Exception e) {
            throw new ProveedorDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PROVEEDOR table that match the criteria ''.
     *         dto.setId(new Integer(rs.getInt(1)));
        dto.setEmpresa(rs.getString(2));
        dto.setRfc(rs.getString(3));
        dto.setDireccion(rs.getString(4));
        dto.setCp(rs.getString(5));
        dto.setCiudad(rs.getString(6));
        dto.setTelefono(rs.getString(7));
        dto.setCelular(rs.getString(8));
        dto.setEmail(rs.getString(9));
        dto.setFechaRegistro(rs.getDate(10));
     */
    @Transactional
    public List<Proveedor> findForPedido(int pedido) throws ProveedorDaoException {
        
        try {
            return jdbcTemplate.query("select pro.id, pro.empresa, pro.rfc, pro.direccion, " +
                                    "pro.cp, pro.ciudad, pro.telefono,  " +
                                    "pro.celular, pro.EMAIL, pro.fecha_registro, pro.COMISION_FIJA, pro.porcentaje_comision " +
                                    "from app.PEDIDO ped,  " +
                                    "app.PEDIDO_PRODUCTO pp,  " +
                                    "app.PROVEEDOR pro, app.PRODUCTOS prod  " +
                                    "where ped.id = ? " +
                                    "and pp.id_pedido = ped.id " +
                                    "and prod.id_producto = pp.id_producto " +
                                    "and pro.id = prod.id_proveedor " +
                                    "group by pro.id, pro.empresa, pro.rfc, pro.direccion,  " +
                                    "pro.cp, pro.ciudad, pro.telefono,  " +
                                    "pro.celular, pro.EMAIL, pro.fecha_registro, pro.COMISION_FIJA, pro.porcentaje_comision ", 
                    this, pedido);
        } catch (Exception e) {
            throw new ProveedorDaoException("Query failed", e);
        }

    }
}
