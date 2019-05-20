package com.amickom.autopartdao.dao.spring;

import com.amickom.autopartdao.dao.ClienteDao;
import com.amickom.autopartdao.dao.mapper.VentasUtilidadMapper;
import com.amickom.autopartdao.dto.Cliente;
import com.amickom.autopartdao.dto.ClientePk;
import com.amickom.autopartdao.dto.VentasUtilidadDTO;
import com.amickom.autopartdao.exceptions.ClienteDaoException;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class ClienteDaoImpl extends AbstractDAO implements ParameterizedRowMapper<Cliente>, ClienteDao {

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
     * @return ClientePk
     */
    @Transactional
    public ClientePk insert(Cliente dto) {
        int i = jdbcTemplate.update("INSERT INTO " + getTableName() + " ( NOMBRE, RFC, DIRECCION, TELEFONO, celular, cp, ciudad, EMAIL, FECHA_REGISTRO, estatus ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?,  CURRENT_DATE, 1 )", dto.getNombre(), dto.getRfc(), dto.getDireccion(), dto.getTelefono(), dto.getCelular(), dto.getCp(), dto.getCiudad(), dto.getEmail());
        ClientePk pk = new ClientePk();
        pk.setId(i);
        return pk;
    }

    /** 
     * Updates a single row in the CLIENTE table.
     */
    @Transactional
    public void update(ClientePk pk, Cliente dto) throws ClienteDaoException {
        jdbcTemplate.update("UPDATE " + getTableName() + " SET ID = ?, NOMBRE = ?, RFC = ?, DIRECCION = ?, TELEFONO = ?, EMAIL = ?, FECHA_REGISTRO = ? WHERE ID = ?", dto.getId(), dto.getNombre(), dto.getRfc(), dto.getDireccion(), dto.getTelefono(), dto.getEmail(), dto.getFechaRegistro(), pk.getId());
    }

    /** 
     * Updates a single row in the CLIENTE table.
     */
    @Transactional
    public boolean update(Cliente dto) throws ClienteDaoException {
        int i = jdbcTemplate.update("UPDATE " + getTableName() + " set rfc = ?, DIRECCION = ?, TELEFONO = ?, celular = ?, cp = ?, ciudad = ?, EMAIL = ? WHERE nombre = ?", dto.getRfc(), dto.getDireccion(), dto.getTelefono(), dto.getCelular(), dto.getCp(), dto.getCiudad(), dto.getEmail(), dto.getNombre());
        return i > 0 ? true : false;
    }

    /** 
     * Deletes a single row in the CLIENTE table.
     */
    @Transactional
    public void delete(ClientePk pk) throws ClienteDaoException {
        jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID = ?", pk.getId());
    }

    /** 
     * Deletes a single row in the CLIENTE table.
     */
    @Transactional
    public boolean delete(String nombre) throws ClienteDaoException {
        int i = jdbcTemplate.update("UPDATE " + getTableName() + " set estatus = 0 WHERE nombre = ?", nombre);
        return i > 0 ? true : false;
    }

    /**
     * Method 'mapRow'
     * 
     * @param rs
     * @param row
     * @throws SQLException
     * @return Cliente
     */
    public Cliente mapRow(ResultSet rs, int row) throws SQLException {
        Cliente dto = new Cliente();
        dto.setId(new Integer(rs.getInt(1)));
        dto.setNombre(rs.getString(2) != null ? rs.getString(2) : "");
        dto.setRfc(rs.getString(3) != null ? rs.getString(3) : "");
        dto.setDireccion(rs.getString(4) != null ? rs.getString(4) : "");
        dto.setTelefono(rs.getString(5) != null ? rs.getString(5) : "");
        dto.setCelular(rs.getString(6) != null ? rs.getString(6) : "");
        dto.setCp(rs.getString(7) != null ? rs.getString(7) : "");
        dto.setCiudad(rs.getString(8) != null ? rs.getString(8) : "");
        dto.setEmail(rs.getString(9) != null ? rs.getString(9) : "");
        dto.setFechaRegistro(rs.getDate(10) != null ? rs.getDate(10) : Calendar.getInstance().getTime());
        return dto;
    }

    /**
     * Method 'getTableName'
     * 
     * @return String
     */
    public String getTableName() {
        return "app.CLIENTE";
    }

    /** 
     * Returns all rows from the CLIENTE table that match the criteria 'ID = :id'.
     */
    @Transactional
    public Cliente findByPrimaryKey(Integer id) throws ClienteDaoException {
        try {
            List<Cliente> list = jdbcTemplate.query("SELECT ID, NOMBRE, RFC, DIRECCION, TELEFONO, EMAIL, FECHA_REGISTRO FROM " + getTableName() + " WHERE ID = ?", this, id);
            return list.size() == 0 ? null : list.get(0);
        } catch (Exception e) {
            throw new ClienteDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the CLIENTE table that match the criteria ''.
     */
    @Transactional
    public List<Cliente> findAll() throws ClienteDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, NOMBRE, RFC, DIRECCION, TELEFONO, celular, cp, ciudad, EMAIL, FECHA_REGISTRO FROM " + getTableName() + " where estatus = 1 ORDER BY ID", this);
        } catch (Exception e) {
            throw new ClienteDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the CLIENTE table that match the criteria 'ID = :id'.
     */
    @Transactional
    public List<Cliente> findWhereIdEquals(Integer id) throws ClienteDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, NOMBRE, RFC, DIRECCION, TELEFONO, EMAIL, FECHA_REGISTRO FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this, id);
        } catch (Exception e) {
            throw new ClienteDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the CLIENTE table that match the criteria 'NOMBRE = :nombre'.
     */
    @Transactional
    public List<Cliente> findWhereNombreEquals(String nombre) throws ClienteDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, NOMBRE, RFC, DIRECCION, TELEFONO, celular, cp, ciudad, EMAIL, FECHA_REGISTRO FROM " + getTableName() + " WHERE NOMBRE = ? and estatus = 1 ORDER BY NOMBRE", this, nombre);
        } catch (Exception e) {
            throw new ClienteDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the CLIENTE table that match the criteria 'RFC = :rfc'.
     */
    @Transactional
    public List<Cliente> findWhereRfcEquals(String rfc) throws ClienteDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, NOMBRE, RFC, DIRECCION, TELEFONO, EMAIL, FECHA_REGISTRO FROM " + getTableName() + " WHERE RFC = ? ORDER BY RFC", this, rfc);
        } catch (Exception e) {
            throw new ClienteDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the CLIENTE table that match the criteria 'DIRECCION = :direccion'.
     */
    @Transactional
    public List<Cliente> findWhereDireccionEquals(String direccion) throws ClienteDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, NOMBRE, RFC, DIRECCION, TELEFONO, EMAIL, FECHA_REGISTRO FROM " + getTableName() + " WHERE DIRECCION = ? ORDER BY DIRECCION", this, direccion);
        } catch (Exception e) {
            throw new ClienteDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the CLIENTE table that match the criteria 'TELEFONO = :telefono'.
     */
    @Transactional
    public List<Cliente> findWhereTelefonoEquals(String telefono) throws ClienteDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, NOMBRE, RFC, DIRECCION, TELEFONO, EMAIL, FECHA_REGISTRO FROM " + getTableName() + " WHERE TELEFONO = ? ORDER BY TELEFONO", this, telefono);
        } catch (Exception e) {
            throw new ClienteDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the CLIENTE table that match the criteria 'EMAIL = :email'.
     */
    @Transactional
    public List<Cliente> findWhereEmailEquals(String email) throws ClienteDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, NOMBRE, RFC, DIRECCION, TELEFONO, EMAIL, FECHA_REGISTRO FROM " + getTableName() + " WHERE EMAIL = ? ORDER BY EMAIL", this, email);
        } catch (Exception e) {
            throw new ClienteDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the CLIENTE table that match the criteria 'FECHA_REGISTRO = :fechaRegistro'.
     */
    @Transactional
    public List<Cliente> findWhereFechaRegistroEquals(Date fechaRegistro) throws ClienteDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, NOMBRE, RFC, DIRECCION, TELEFONO, EMAIL, FECHA_REGISTRO FROM " + getTableName() + " WHERE FECHA_REGISTRO = ? ORDER BY FECHA_REGISTRO", this, fechaRegistro);
        } catch (Exception e) {
            throw new ClienteDaoException("Query failed", e);
        }

    }

    /** 
     * Returns the rows from the CLIENTE table that matches the specified primary-key value.
     */
    public Cliente findByPrimaryKey(ClientePk pk) throws ClienteDaoException {
        return findByPrimaryKey(pk.getId());
    }

    @Transactional
    public List<VentasUtilidadDTO> obtieneVentasUtilidad(Date fechaInicial, Date fechaFinal)
            throws ClienteDaoException {
        try {
            VentasUtilidadMapper mapper = new VentasUtilidadMapper();
            Object[] args = new Object[]{fechaInicial,
                fechaFinal};
            return jdbcTemplate.query("select sum((((pp.utlidad/100) * pro.precio) * pp.cantidad) + (pro.precio * "
                    + " pp.cantidad)) total, sum(((pp.utlidad/100) * pro.precio)* pp.cantidad ) utilidad, "
                    + " cli.NOMBRE cliente "
                    + " from   "
                    + " app.Pedido ped,   "
                    + " app.CLIENTE cli,    "
                    + " app.PEDIDO_PRODUCTO pp,  "
                    + " app.PRODUCTOS pro,   "
                    + " app.PROVEEDOR ppv  "
                    + " where ped.ID_CLIENTE = cli.ID  "
                    + " and pp.ID_PEDIDO = ped.ID  "
                    + " and pro.ID_PRODUCTO = pp.ID_PRODUCTO  "
                    + " and ppv.id =  pro.ID_PROVEEDOR  "
                    + " and ped.fecha_alta >= ? "
                    + " and ped.fecha_alta <= ? "
                    + " group by cli.nombre", args, mapper);
        } catch (Exception e) {
            throw new ClienteDaoException("Query failed", e);
        }
    }
}
