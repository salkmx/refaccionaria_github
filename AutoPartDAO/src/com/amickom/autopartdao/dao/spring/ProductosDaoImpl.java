package com.amickom.autopartdao.dao.spring;

import com.amickom.autopartdao.dao.ProductosDao;
import com.amickom.autopartdao.dao.mapper.ProductosTempMapper;
import com.amickom.autopartdao.dto.PedidoProducto;
import com.amickom.autopartdao.dto.Productos;
import com.amickom.autopartdao.dto.ProductosPk;
import com.amickom.autopartdao.exceptions.ProductosDaoException;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class ProductosDaoImpl extends AbstractDAO implements ParameterizedRowMapper<Productos>, ProductosDao {

    protected JdbcTemplate jdbcTemplate;
    protected DataSource dataSource;

    @Override
    public boolean insertaBatch(final List<Productos> productos,
            final int idProveedor) {
        boolean bEdited = false;
        try {
            BatchPreparedStatementSetter bpss = new BatchPreparedStatementSetter() {

                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ps.setInt(1, idProveedor);
                    ps.setString(2, productos.get(i).getCodigo());
                    ps.setDouble(3, productos.get(i).getPrecio());
                    ps.setString(4, productos.get(i).getMarca());
                    ps.setString(5, productos.get(i).getDescripcion());
                }

                public int getBatchSize() {
                    return productos.size();
                }
            };
            int[] i = jdbcTemplate.batchUpdate("INSERT INTO " + getTableName() + " (ID_PROVEEDOR, CODIGO, PRECIO, FECHA_ALTA, MARCA, descripcion, estatus ) VALUES ( ?, ?, ?, CURRENT_DATE, ?, ?, 1 )", bpss);
            if (i.length > 0) {
                bEdited = true;
            }

        } catch (Exception sqle) {
            sqle.printStackTrace();
        }
        return bEdited;
    }

    @Override
    public List<String> findAllMarcas() throws ProductosDaoException {
        List<String> marcas = new ArrayList<String>();
        try {
            marcas = jdbcTemplate.queryForList("select distinct marca from app.PRODUCTOS where estatus = 1", String.class);
        } catch (IncorrectResultSizeDataAccessException e) {
            throw new ProductosDaoException(e.getMessage(), e);
        } catch (DataAccessException e) {
            throw new ProductosDaoException(e.getMessage(), e);
        }
        return marcas;
    }

    /** 
     * Deletes a single row in the PRODUCTOS table.
     */
    public boolean deleteTemp(PedidoProducto dto) throws ProductosDaoException {
        Productos p = dto.getProductos();
        int i = jdbcTemplate.update("DELETE FROM app.PRODUCTOS_TEMP WHERE CODIGO = ? and MARCA = ? and DESCRIPCION = ?",
                p.getCodigo(), p.getMarca(), p.getDescripcion());
        return i > 0 ? true : false;
    }

    /** 
     * Deletes a single row in the PRODUCTOS table.
     */
    public boolean deleteAllTemp() throws ProductosDaoException {
        int i = jdbcTemplate.update("DELETE FROM app.PRODUCTOS_TEMP");
        return i > 0 ? true : false;
    }

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
     * @return ProductosPk
     */
    @Transactional
    public ProductosPk insert(Productos dto) {
        jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_PRODUCTO, ID_PROVEEDOR, CODIGO, PRECIO, FECHA_ALTA, MARCA ) VALUES ( ?, ?, ?, ?, ?, ? )", dto.getIdProducto(), dto.getIdProveedor(), dto.getCodigo(), dto.getPrecio(), dto.getFechaAlta(), dto.getMarca());
        return dto.createPk();
    }

    /**
     * Method 'insert'
     * 
     * @param dto
     * @return ProductosPk
     */
    @Transactional
    public boolean insertTemp(PedidoProducto dto) {
        Productos prod = dto.getProductos();
        int i = jdbcTemplate.update("INSERT INTO app.PRODUCTOS_TEMP( CODIGO, PRECIO, MARCA, descripcion, utilidad, cantidad) VALUES ( ?, ?, ?, ?, ?, ?)", prod.getCodigo(), prod.getPrecio(), prod.getMarca(), prod.getDescripcion(), dto.getUtilidad(), dto.getCantidad());
        return i > 0 ? true : false;
    }

    /** 
     * Updates a single row in the PRODUCTOS table.
     */
    @Transactional
    public void update(ProductosPk pk, Productos dto) throws ProductosDaoException {
        jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_PRODUCTO = ?, ID_PROVEEDOR = ?, CODIGO = ?, PRECIO = ?, FECHA_ALTA = ?, MARCA = ? WHERE ID_PRODUCTO = ?", dto.getIdProducto(), dto.getIdProveedor(), dto.getCodigo(), dto.getPrecio(), dto.getFechaAlta(), dto.getMarca(), pk.getIdProducto());
    }

    /** 
     * Deletes a single row in the PRODUCTOS table.
     */
    @Transactional
    public void delete(ProductosPk pk) throws ProductosDaoException {
        jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_PRODUCTO = ?", pk.getIdProducto());
    }

    /** 
     * Deletes a single row in the PRODUCTOS table.
     */
    @Transactional
    public boolean deleteIdProveedor(int idproveedor) throws ProductosDaoException {
        int i = jdbcTemplate.update("update " + getTableName() + " set estatus = 0 WHERE id_proveedor = ?", idproveedor);
        return i > 0 ? true : false;
    }

    /**
     * Method 'mapRow'
     * 
     * @param rs
     * @param row
     * @throws SQLException
     * @return Productos
     */
    public Productos mapRow(ResultSet rs, int row) throws SQLException {
        Productos dto = new Productos();
        dto.setIdProducto(new Integer(rs.getInt(1)));
        dto.setIdProveedor(new Integer(rs.getInt(2)));
        dto.setCodigo(rs.getString(3));
        dto.setPrecio(new Double(rs.getDouble(4)));
        if (rs.wasNull()) {
            dto.setPrecio(null);
        }

        dto.setFechaAlta(rs.getDate(5));
        dto.setMarca(rs.getString(6));
        if (rs.getString(7) != null) {
            dto.setDescripcion(rs.getString(7));
        }
        if (rs.getString(8) != null) {
            dto.setComisionfija(rs.getInt(8));
        }
        if (rs.getString(9) != null) {
            dto.setComision(rs.getDouble(9));
        }
        return dto;
    }

    /**
     * Method 'getTableName'
     * 
     * @return String
     */
    public String getTableName() {
        return "app.PRODUCTOS";
    }

    /** 
     * Returns all rows from the PRODUCTOS table that match the criteria 'ID_PRODUCTO = :idProducto'.
     */
    @Transactional
    public Productos findByPrimaryKey(Integer idProducto) throws ProductosDaoException {
        try {
            List<Productos> list = jdbcTemplate.query("SELECT ID_PRODUCTO, ID_PROVEEDOR, CODIGO, PRECIO, FECHA_ALTA, MARCA FROM " + getTableName() + " WHERE ID_PRODUCTO = ?", this, idProducto);
            return list.size() == 0 ? null : list.get(0);
        } catch (Exception e) {
            throw new ProductosDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PRODUCTOS table that match the criteria ''.
     */
    @Transactional
    public List<Productos> findAll() throws ProductosDaoException {
        try {
            return jdbcTemplate.query("SELECT ID_PRODUCTO, ID_PROVEEDOR, CODIGO, PRECIO, FECHA_ALTA, MARCA FROM " + getTableName() + " ORDER BY ID_PRODUCTO", this);
        } catch (Exception e) {
            throw new ProductosDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PRODUCTOS table that match the criteria ''.
     */
    @Transactional
    public List<PedidoProducto> findAllTemp() throws ProductosDaoException {
        try {
            return jdbcTemplate.query("SELECT CODIGO, PRECIO, MARCA, descripcion, utilidad, cantidad FROM app.PRODUCTOS_TEMP ORDER BY CODIGO", new ProductosTempMapper());
        } catch (Exception e) {
            throw new ProductosDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PRODUCTOS table that match the criteria ''.
     */
    @Transactional
    public List<PedidoProducto> findTemp(String codigo, int cantidad, double utilidad) throws ProductosDaoException {
        try {
            Object[] args = new Object[]{codigo, utilidad, cantidad};
            return jdbcTemplate.query("select  CODIGO, PRECIO, MARCA, descripcion, utilidad, cantidad from app.PRODUCTOS_TEMP temp where temp.CODIGO = ? and temp.UTILIDAD = ? and temp.CANTIDAD = ?", args, new ProductosTempMapper());
        } catch (Exception e) {
            throw new ProductosDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PRODUCTOS table that match the criteria 'ID_PRODUCTO = :idProducto'.
     */
    @Transactional
    public List<Productos> findWhereIdProductoEquals(Integer idProducto) throws ProductosDaoException {
        try {
            return jdbcTemplate.query("SELECT ID_PRODUCTO, ID_PROVEEDOR, CODIGO, PRECIO, FECHA_ALTA, MARCA FROM " + getTableName() + " WHERE ID_PRODUCTO = ? ORDER BY ID_PRODUCTO", this, idProducto);
        } catch (Exception e) {
            throw new ProductosDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PRODUCTOS table that match the criteria 'ID_PROVEEDOR = :idProveedor'.
     */
    @Transactional
    public List<Productos> findWhereIdProveedorEquals(Integer idProveedor) throws ProductosDaoException {
        try {
            return jdbcTemplate.query("SELECT ID_PRODUCTO, ID_PROVEEDOR, CODIGO, PRECIO, FECHA_ALTA, MARCA FROM " + getTableName() + " WHERE ID_PROVEEDOR = ? ORDER BY ID_PROVEEDOR", this, idProveedor);
        } catch (Exception e) {
            throw new ProductosDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PRODUCTOS table that match the criteria 'CODIGO = :codigo'.
     */
    @Transactional
    public List<Productos> findWhereCodigoEquals(String codigo) throws ProductosDaoException {
        try {
            return jdbcTemplate.query("SELECT ID_PRODUCTO, ID_PROVEEDOR, CODIGO, PRECIO, FECHA_ALTA, MARCA FROM " + getTableName() + " WHERE CODIGO = ? ORDER BY CODIGO", this, codigo);
        } catch (Exception e) {
            throw new ProductosDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PRODUCTOS table that match the criteria 'CODIGO = :codigo'.
     */
    @Transactional
    public List<Productos> findForSale(String codigo, String marca) throws ProductosDaoException {
        try {
            StringBuilder builder = new StringBuilder();
            builder.append("SELECT ID_PRODUCTO, ID_PROVEEDOR, CODIGO, PRECIO, FECHA_ALTA, MARCA, descripcion, COMISION_FIJA, porcentaje_comision FROM ");
            builder.append("app.PRODUCTOS pro, app.proveedor prv where pro.ID_PROVEEDOR = prv.id and prv.estatus = 1");
            if (codigo != null || (marca != null && !marca.equals("Todas las marcas"))) {
                builder.append(" AND ");
            }
            if (codigo != null) {
                builder.append("CODIGO = '");
                builder.append(codigo);
                builder.append("' ");
            }
            if (codigo != null && (marca != null && !marca.equals("Todas las marcas"))) {
                builder.append(" and ");
            }
            if (marca != null && !marca.equals("Todas las marcas")) {
                builder.append("MARCA = '");
                builder.append(marca);
                builder.append("' ");
            }
            return jdbcTemplate.query(builder.toString(), this);
        } catch (Exception e) {
            throw new ProductosDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PRODUCTOS table that match the criteria 'CODIGO = :codigo'.
     */
    @Transactional
    public List<Productos> findForSaleP(String codigo, String marca, String proveedor, String nombre) throws ProductosDaoException {
        try {
            StringBuilder builder = new StringBuilder();
            builder.append("SELECT ID_PRODUCTO, ID_PROVEEDOR, CODIGO, PRECIO, FECHA_ALTA, MARCA, descripcion, COMISION_FIJA, porcentaje_comision FROM ");
            builder.append("app.PRODUCTOS pro, app.proveedor prv where pro.ID_PROVEEDOR = prv.id and prv.estatus = 1 and pro.estatus = 1 ");
            /**if (codigo != null || (marca != null && !marca.equals("Todas las marcas"))) {
            builder.append(" AND ");
            }**/
            if (proveedor != null && !proveedor.trim().equals("Todos los proveedores")) {
                builder.append(" AND prv.empresa = '");
                builder.append(proveedor);
                builder.append("' ");
            }
            if (codigo != null) {
                builder.append(" AND pro.CODIGO = '");
                builder.append(codigo);
                builder.append("' ");
            }
            /**if (codigo != null && (marca != null && !marca.equals("Todas las marcas"))) {
            builder.append(" and ");
            }**/
            if (marca != null && !marca.equals("Todas las marcas")) {
                builder.append(" and pro.MARCA = '");
                builder.append(marca);
                builder.append("' ");
            }
            if (nombre != null && !nombre.equals("")) {
                builder.append(" and pro.descripcion like '%");
                builder.append(nombre);
                builder.append("%' ");
            }
            return jdbcTemplate.query(builder.toString(), this);
        } catch (Exception e) {
            throw new ProductosDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PRODUCTOS table that match the criteria 'CODIGO = :codigo'.
     */
    @Transactional
    public int findId(String codigo, String marca, Double precio) throws ProductosDaoException {
        try {
            StringBuilder builder = new StringBuilder();
            builder.append("SELECT ID_PRODUCTO descripcion FROM ");
            builder.append("app.PRODUCTOS pro, app.proveedor prv where pro.ID_PROVEEDOR = prv.id and prv.estatus = 1 and pro.estatus = 1 ");
            if (codigo != null || marca != null || precio != null) {
                builder.append(" AND ");
            }
            if (codigo != null) {
                builder.append("CODIGO = '");
                builder.append(codigo);
                builder.append("' ");
            }
            if (codigo != null) {
                builder.append(" and ");
            }
            if (!marca.equals("Todas las marcas")) {
                builder.append("MARCA = '");
                builder.append(marca);
                builder.append("' ");
            }
            if (precio != null) {
                builder.append(" and ");
            }
            if (precio != null) {
                builder.append("precio = ");
                builder.append(precio);
            }
            return jdbcTemplate.queryForInt(builder.toString());
        } catch (Exception e) {
            throw new ProductosDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PRODUCTOS table that match the criteria 'PRECIO = :precio'.
     */
    @Transactional
    public List<Productos> findWherePrecioEquals(Double precio) throws ProductosDaoException {
        try {
            return jdbcTemplate.query("SELECT ID_PRODUCTO, ID_PROVEEDOR, CODIGO, PRECIO, FECHA_ALTA, MARCA FROM " + getTableName() + " WHERE PRECIO = ? ORDER BY PRECIO", this, precio);
        } catch (Exception e) {
            throw new ProductosDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PRODUCTOS table that match the criteria 'FECHA_ALTA = :fechaAlta'.
     */
    @Transactional
    public List<Productos> findWhereFechaAltaEquals(Date fechaAlta) throws ProductosDaoException {
        try {
            return jdbcTemplate.query("SELECT ID_PRODUCTO, ID_PROVEEDOR, CODIGO, PRECIO, FECHA_ALTA, MARCA FROM " + getTableName() + " WHERE FECHA_ALTA = ? ORDER BY FECHA_ALTA", this, fechaAlta);
        } catch (Exception e) {
            throw new ProductosDaoException("Query failed", e);
        }

    }

    /** 
     * Returns all rows from the PRODUCTOS table that match the criteria 'MARCA = :marca'.
     */
    @Transactional
    public List<Productos> findWhereMarcaEquals(String marca) throws ProductosDaoException {
        try {
            return jdbcTemplate.query("SELECT ID_PRODUCTO, ID_PROVEEDOR, CODIGO, PRECIO, FECHA_ALTA, MARCA FROM " + getTableName() + " WHERE MARCA = ? ORDER BY MARCA", this, marca);
        } catch (Exception e) {
            throw new ProductosDaoException("Query failed", e);
        }

    }

    /** 
     * Returns the rows from the PRODUCTOS table that matches the specified primary-key value.
     */
    public Productos findByPrimaryKey(ProductosPk pk) throws ProductosDaoException {
        return findByPrimaryKey(pk.getIdProducto());
    }
}
