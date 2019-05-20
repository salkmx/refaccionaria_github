package com.amickom.autopartdao.dao.spring;

import com.amickom.autopartdao.dao.PedidoDao;
import com.amickom.autopartdao.dto.Pedido;
import com.amickom.autopartdao.dto.PedidoPk;
import com.amickom.autopartdao.exceptions.PedidoDaoException;
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

public class PedidoDaoImpl extends AbstractDAO implements ParameterizedRowMapper<Pedido>, PedidoDao {

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
     * @return PedidoPk
     */
    @Transactional
    public PedidoPk insert(final Pedido dto) {
        GeneratedKeyHolder gkh = new GeneratedKeyHolder();
        PedidoPk pk = new PedidoPk();
        try {
            PreparedStatementCreator psc = new PreparedStatementCreator() {

                @Override
                public PreparedStatement createPreparedStatement(Connection connection)
                        throws SQLException {
                    PreparedStatement stmtSaveFile =
                            connection.prepareStatement("INSERT INTO " + getTableName() + " ( ID_CLIENTE, FECHA_ALTA, PRECIO, IVA, ID_USUARIO, subtotal) VALUES ( ?, CURRENT_DATE, ?, ?, ?, ? )",
                            new int[]{1});
                    stmtSaveFile.setInt(1, dto.getIdCliente());
                    stmtSaveFile.setDouble(2, dto.getPrecio());
                    stmtSaveFile.setDouble(3, dto.getIva());
                    stmtSaveFile.setInt(4, dto.getIdUsuario());
                    stmtSaveFile.setDouble(5, dto.getSubtotal());
                    return stmtSaveFile;
                }
            };            
            jdbcTemplate.update(psc, gkh);
            pk.setId(gkh.getKey().intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pk;
    }

    /** 
     * Updates a single row in the PEDIDO table.
     */
    @Transactional
    public void update(PedidoPk pk, Pedido dto) throws PedidoDaoException {
        jdbcTemplate.update("UPDATE " + getTableName() + " SET ID = ?, ID_CLIENTE = ?, FECHA_ALTA = ?, PRECIO = ?, IVA = ?, ID_USUARIO = ? WHERE ID = ?", dto.getId(), dto.getIdCliente(), dto.getFechaAlta(), dto.getPrecio(), dto.getIva(), dto.getIdUsuario(), pk.getId());
    }

    /** 
     * Deletes a single row in the PEDIDO table.
     */
    @Transactional
    public void delete(PedidoPk pk) throws PedidoDaoException {
        jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID = ?", pk.getId());
    }

    /**
     * Method 'mapRow'
     * 
     * @param rs
     * @param row
     * @throws SQLException
     * @return Pedido
     */
    public Pedido mapRow(ResultSet rs, int row) throws SQLException {
        Pedido dto = new Pedido();
        dto.setId(new Integer(rs.getInt(1)));
        dto.setIdCliente(new Integer(rs.getInt(2)));
        dto.setFechaAlta(rs.getDate(3));
        dto.setPrecio(new Double(rs.getDouble(4)));
        dto.setIva(new Double(rs.getDouble(5)));
        dto.setIdUsuario(new Integer(rs.getInt(6)));
        return dto;
    }

    /**
     * Method 'getTableName'
     * 
     * @return String
     */
    public String getTableName() {
        return "app.PEDIDO";
    }

    /** 
     * Returns all rows from the PEDIDO table that match the criteria 'ID = :id'.
     */
    @Transactional
    public Pedido findByPrimaryKey(Integer id) throws PedidoDaoException {
        try {
            List<Pedido> list = jdbcTemplate.query("SELECT ID, ID_CLIENTE, FECHA_ALTA, PRECIO, IVA, ID_USUARIO FROM " + getTableName() + " WHERE ID = ?", this, id);
            return list.size() == 0 ? null : list.get(0);
        } catch (Exception e) {
            throw new PedidoDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PEDIDO table that match the criteria ''.
     */
    @Transactional
    public List<Pedido> findAll() throws PedidoDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, ID_CLIENTE, FECHA_ALTA, PRECIO, IVA, ID_USUARIO FROM " + getTableName() + " ORDER BY ID", this);
        } catch (Exception e) {
            throw new PedidoDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PEDIDO table that match the criteria 'ID = :id'.
     */
    @Transactional
    public List<Pedido> findByCliente(Integer id) throws PedidoDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, ID_CLIENTE, FECHA_ALTA, PRECIO, IVA, ID_USUARIO FROM " + getTableName() + " WHERE ID = ?", this, id);
        } catch (Exception e) {
            throw new PedidoDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PEDIDO table that match the criteria 'ID = :id'.
     */
    @Transactional
    public List<Pedido> findWhereIdEquals(Integer id) throws PedidoDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, ID_CLIENTE, FECHA_ALTA, PRECIO, IVA, ID_USUARIO FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this, id);
        } catch (Exception e) {
            throw new PedidoDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PEDIDO table that match the criteria 'ID_CLIENTE = :idCliente'.
     */
    @Transactional
    public List<Pedido> findWhereIdClienteEquals(Integer idCliente) throws PedidoDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, ID_CLIENTE, FECHA_ALTA, PRECIO, IVA, ID_USUARIO FROM " + getTableName() + " WHERE ID_CLIENTE = ? ORDER BY ID_CLIENTE", this, idCliente);
        } catch (Exception e) {
            throw new PedidoDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PEDIDO table that match the criteria 'FECHA_ALTA = :fechaAlta'.
     */
    @Transactional
    public List<Pedido> findWhereFechaAltaEquals(Date fechaAlta) throws PedidoDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, ID_CLIENTE, FECHA_ALTA, PRECIO, IVA, ID_USUARIO FROM " + getTableName() + " WHERE FECHA_ALTA = ? ORDER BY FECHA_ALTA", this, fechaAlta);
        } catch (Exception e) {
            throw new PedidoDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PEDIDO table that match the criteria 'PRECIO = :precio'.
     */
    @Transactional
    public List<Pedido> findWherePrecioEquals(Double precio) throws PedidoDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, ID_CLIENTE, FECHA_ALTA, PRECIO, IVA, ID_USUARIO FROM " + getTableName() + " WHERE PRECIO = ? ORDER BY PRECIO", this, precio);
        } catch (Exception e) {
            throw new PedidoDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PEDIDO table that match the criteria 'IVA = :iva'.
     */
    @Transactional
    public List<Pedido> findWhereIvaEquals(Double iva) throws PedidoDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, ID_CLIENTE, FECHA_ALTA, PRECIO, IVA, ID_USUARIO FROM " + getTableName() + " WHERE IVA = ? ORDER BY IVA", this, iva);
        } catch (Exception e) {
            throw new PedidoDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PEDIDO table that match the criteria 'ID_USUARIO = :idUsuario'.
     */
    @Transactional
    public List<Pedido> findWhereIdUsuarioEquals(Integer idUsuario) throws PedidoDaoException {
        try {
            return jdbcTemplate.query("SELECT ID, ID_CLIENTE, FECHA_ALTA, PRECIO, IVA, ID_USUARIO FROM " + getTableName() + " WHERE ID_USUARIO = ? ORDER BY ID_USUARIO", this, idUsuario);
        } catch (Exception e) {
            throw new PedidoDaoException("Query failed", e);
        }

    }

    /** 
     * Returns the rows from the PEDIDO table that matches the specified primary-key value.
     */
    public Pedido findByPrimaryKey(PedidoPk pk) throws PedidoDaoException {
        return findByPrimaryKey(pk.getId());
    }
}
