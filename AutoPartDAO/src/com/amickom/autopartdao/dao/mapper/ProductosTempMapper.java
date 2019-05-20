/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amickom.autopartdao.dao.mapper;

import com.amickom.autopartdao.dto.PedidoProducto;
import com.amickom.autopartdao.dto.Productos;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author david
 */
public class ProductosTempMapper implements RowMapper<PedidoProducto> {

    public ProductosTempMapper() {
    }

    @Override
    public PedidoProducto mapRow(ResultSet rs, int i) throws SQLException {
        PedidoProducto pedido = new PedidoProducto();
        Productos dto = new Productos();               
        dto.setCodigo(rs.getString(1));
        dto.setPrecio(new Double(rs.getDouble(2)));
        if (rs.wasNull()) {
            dto.setPrecio(null);
        }        
        dto.setMarca(rs.getString(3));
        if (rs.getString(4) != null) {
            dto.setDescripcion(rs.getString(4));
        }
        pedido.setProductos(dto);
        pedido.setUtilidad(rs.getDouble(5));
        pedido.setCantidad(rs.getInt(6));
        return pedido;
    }
}
