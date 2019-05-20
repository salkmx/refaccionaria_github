package com.amickom.autopartdao.dao.spring;

import com.amickom.autopartdao.dao.PedidoProductoDao;
import com.amickom.autopartdao.dao.mapper.PedidoProductosMapper;
import com.amickom.autopartdao.dto.PedidoProducto;
import com.amickom.autopartdao.dto.PedidoProductoPk;
import com.amickom.autopartdao.exceptions.PedidoProductoDaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class PedidoProductoDaoImpl extends AbstractDAO implements ParameterizedRowMapper<PedidoProducto>, PedidoProductoDao {

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
     * @return PedidoProductoPk
     */
    @Transactional
    public boolean insert(PedidoProducto dto) {
        int i = jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_PEDIDO, ID_PRODUCTO, cantidad, utlidad ) VALUES ( ?, ?, ?, ? )", dto.getIdPedido(), dto.getIdProducto(), dto.getCantidad(), dto.getUtilidad());
        return i > 0 ? true : false;
    }

    /** 
     * Updates a single row in the PEDIDO_PRODUCTO table.
     */
    @Transactional
    public void update(PedidoProductoPk pk, PedidoProducto dto) throws PedidoProductoDaoException {
        jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_PEDIDO = ?, ID_PRODUCTO = ? WHERE ID_PEDIDO = ? AND ID_PRODUCTO = ?", dto.getIdPedido(), dto.getIdProducto(), pk.getIdPedido(), pk.getIdProducto());
    }

    /** 
     * Deletes a single row in the PEDIDO_PRODUCTO table.
     */
    @Transactional
    public void delete(PedidoProductoPk pk) throws PedidoProductoDaoException {
        jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_PEDIDO = ? AND ID_PRODUCTO = ?", pk.getIdPedido(), pk.getIdProducto());
    }

    /**
     * Method 'mapRow'
     * 
     * @param rs
     * @param row
     * @throws SQLException
     * @return PedidoProducto
     */
    public PedidoProducto mapRow(ResultSet rs, int row) throws SQLException {
        PedidoProducto dto = new PedidoProducto();
        dto.setIdPedido(new Integer(rs.getInt(1)));
        dto.setIdProducto(new Integer(rs.getInt(2)));
        return dto;
    }

    /**
     * Method 'getTableName'
     * 
     * @return String
     */
    public String getTableName() {
        return "app.PEDIDO_PRODUCTO";
    }

    /** 
     * Returns all rows from the PEDIDO_PRODUCTO table that match the criteria 'ID_PEDIDO = :idPedido AND ID_PRODUCTO = :idProducto'.
     */
    @Transactional
    public PedidoProducto findByPrimaryKey(Integer idPedido, Integer idProducto) throws PedidoProductoDaoException {
        try {
            List<PedidoProducto> list = jdbcTemplate.query("SELECT ID_PEDIDO, ID_PRODUCTO FROM " + getTableName() + " WHERE ID_PEDIDO = ? AND ID_PRODUCTO = ?", this, idPedido, idProducto);
            return list.size() == 0 ? null : list.get(0);
        } catch (Exception e) {
            throw new PedidoProductoDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PEDIDO_PRODUCTO table that match the criteria ''.
     */
    @Transactional
    public List<PedidoProducto> findAll() throws PedidoProductoDaoException {
        try {
            return jdbcTemplate.query("SELECT ID_PEDIDO, ID_PRODUCTO FROM " + getTableName() + " ORDER BY ID_PEDIDO, ID_PRODUCTO", this);
        } catch (Exception e) {
            throw new PedidoProductoDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PEDIDO_PRODUCTO table that match the criteria 'ID_PEDIDO = :idPedido'.
     */
    @Transactional
    public List<PedidoProducto> findByPedido(Integer idPedido) throws PedidoProductoDaoException {
        try {
            return jdbcTemplate.query("SELECT ID_PEDIDO, ID_PRODUCTO FROM " + getTableName() + " WHERE ID_PEDIDO = ?", this, idPedido);
        } catch (Exception e) {
            throw new PedidoProductoDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PEDIDO_PRODUCTO table that match the criteria 'ID_PRODUCTO = :idProducto'.
     */
    @Transactional
    public List<PedidoProducto> findByProductos(Integer idProducto) throws PedidoProductoDaoException {
        try {
            return jdbcTemplate.query("SELECT ID_PEDIDO, ID_PRODUCTO FROM " + getTableName() + " WHERE ID_PRODUCTO = ?", this, idProducto);
        } catch (Exception e) {
            throw new PedidoProductoDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PEDIDO_PRODUCTO table that match the criteria 'ID_PEDIDO = :idPedido'.
     */
    @Transactional
    public List<PedidoProducto> findWhereIdPedidoEquals(Integer idPedido) throws PedidoProductoDaoException {
        try {
            return jdbcTemplate.query("SELECT ID_PEDIDO, ID_PRODUCTO FROM " + getTableName() + " WHERE ID_PEDIDO = ? ORDER BY ID_PEDIDO", this, idPedido);
        } catch (Exception e) {
            throw new PedidoProductoDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PEDIDO_PRODUCTO table that match the criteria 'ID_PRODUCTO = :idProducto'.
     */
    @Transactional
    public List<PedidoProducto> findWhereIdProductoEquals(Integer idProducto) throws PedidoProductoDaoException {
        try {
            return jdbcTemplate.query("SELECT ID_PEDIDO, ID_PRODUCTO FROM " + getTableName() + " WHERE ID_PRODUCTO = ? ORDER BY ID_PRODUCTO", this, idProducto);
        } catch (Exception e) {
            throw new PedidoProductoDaoException("Query failed", e);
        }

    }

    /** 
     * Returns the rows from the PEDIDO_PRODUCTO table that matches the specified primary-key value.
     */
    public PedidoProducto findByPrimaryKey(PedidoProductoPk pk) throws PedidoProductoDaoException {
        return findByPrimaryKey(pk.getIdPedido(), pk.getIdProducto());
    }

    @Transactional
    public List<PedidoProducto> obtieneProductosPedidoCliente(String cliente) throws PedidoProductoDaoException {
        try {
            PedidoProductosMapper mapper = new PedidoProductosMapper();
            Object[] args = new Object[]{cliente};
            return jdbcTemplate.query("select "
                    + "pro.ID_PRODUCTO, "
                    + "pro.ID_PROVEEDOR, "
                    + "pro.CODIGO, "
                    + "pro.PRECIO, "
                    + "ped.FECHA_ALTA, "
                    + "pro.MARCA, "
                    + "pro.DESCRIPCION, "
                    + "pp.CANTIDAD, "
                    + "pp.UTLIDAD, "
                    + "ppv.empresa, "
                    + "ped.ID "
                    + "from  "
                    + "app.Pedido ped,  "
                    + "app.CLIENTE cli,   "
                    + "app.PEDIDO_PRODUCTO pp, "
                    + "app.PRODUCTOS pro,  "
                    + "app.PROVEEDOR ppv "
                    + "where ped.ID_CLIENTE = cli.ID "
                    + "and pp.ID_PEDIDO = ped.ID "
                    + "and pro.ID_PRODUCTO = pp.ID_PRODUCTO "
                    + "and ppv.id =  pro.ID_PROVEEDOR "
                    + "and cli.NOMBRE = ? ", args, mapper);
        } catch (Exception e) {
            throw new PedidoProductoDaoException("Query failed", e);
        }

    }

    @Transactional
    public List<PedidoProducto> obtieneProductosPedidoCliente(String cliente,
            Date fechaInicial, Date fechaFinal) throws PedidoProductoDaoException {
        try {
            PedidoProductosMapper mapper = new PedidoProductosMapper();
            Object[] args = new Object[]{cliente, fechaInicial, fechaFinal};
            return jdbcTemplate.query("select "
                    + "pro.ID_PRODUCTO, "
                    + "pro.ID_PROVEEDOR, "
                    + "pro.CODIGO, "
                    + "pro.PRECIO, "
                    + "ped.FECHA_ALTA, "
                    + "pro.MARCA, "
                    + "pro.DESCRIPCION, "
                    + "pp.CANTIDAD, "
                    + "pp.UTLIDAD, "
                    + "ppv.empresa, "
                    + "ped.ID "
                    + "from  "
                    + "app.Pedido ped,  "
                    + "app.CLIENTE cli,   "
                    + "app.PEDIDO_PRODUCTO pp, "
                    + "app.PRODUCTOS pro,  "
                    + "app.PROVEEDOR ppv "
                    + "where ped.ID_CLIENTE = cli.ID "
                    + "and pp.ID_PEDIDO = ped.ID "
                    + "and pro.ID_PRODUCTO = pp.ID_PRODUCTO "
                    + "and ppv.id =  pro.ID_PROVEEDOR "
                    + "and cli.NOMBRE = ? "
                    + "and ped.FECHA_ALTA >= ? "
                    + "and ped.FECHA_ALTA <= ? ", args, mapper);
        } catch (Exception e) {
            throw new PedidoProductoDaoException("Query failed", e);
        }

    }

    @Transactional
    public List<PedidoProducto> obtieneProductosPedidoProveedor(String empresa,
            Date fechaInicial, Date fechaFinal) throws PedidoProductoDaoException {
        try {
            PedidoProductosMapper mapper = new PedidoProductosMapper();
            Object[] args = new Object[]{empresa, fechaInicial, fechaFinal};
            return jdbcTemplate.query("select "
                    + "pro.ID_PRODUCTO, "
                    + "pro.ID_PROVEEDOR, "
                    + "pro.CODIGO, "
                    + "pro.PRECIO, "
                    + "ped.FECHA_ALTA, "
                    + "pro.MARCA, "
                    + "pro.DESCRIPCION, "
                    + "pp.CANTIDAD, "
                    + "pp.UTLIDAD, "
                    + "cli.nombre, "
                    + "ped.ID "
                    + "from  "
                    + "app.Pedido ped,  "
                    + "app.CLIENTE cli,   "
                    + "app.PEDIDO_PRODUCTO pp, "
                    + "app.PRODUCTOS pro,  "
                    + "app.PROVEEDOR ppv "
                    + "where ped.ID_CLIENTE = cli.ID "
                    + "and pp.ID_PEDIDO = ped.ID "
                    + "and pro.ID_PRODUCTO = pp.ID_PRODUCTO "
                    + "and ppv.id =  pro.ID_PROVEEDOR "
                    + "and ppv.empresa = ? "
                    + "and ped.FECHA_ALTA >= ? "
                    + "and ped.FECHA_ALTA <= ? ", args, mapper);
        } catch (Exception e) {
            throw new PedidoProductoDaoException("Query failed", e);
        }

    }

    @Transactional
    public List<PedidoProducto> obtieneProductosPedidoProveedor(int pedido,
            int proveedor) throws PedidoProductoDaoException {
        try {
            PedidoProductosMapper mapper = new PedidoProductosMapper();
            Object[] args = new Object[]{pedido, proveedor};
            return jdbcTemplate.query("select prod.id_producto, prod.id_proveedor, "
                    + "prod.codigo, prod.precio, prod.fecha_alta,  "
                    + "prod.marca, prod.descripcion, "
                    + "pp.cantidad, pp.utlidad, pro.empresa, ped.id "
                    + "from app.PEDIDO ped,  "
                    + "app.PEDIDO_PRODUCTO pp,  "
                    + "app.PROVEEDOR pro, app.PRODUCTOS prod  "
                    + "where ped.id = ? "
                    + "and pro.id = ? "
                    + "and pp.id_pedido = ped.id "
                    + "and prod.id_producto = pp.id_producto "
                    + "and pro.id = prod.id_proveedor", args, mapper);
        } catch (Exception e) {
            throw new PedidoProductoDaoException("Query failed", e);
        }

    }
}
