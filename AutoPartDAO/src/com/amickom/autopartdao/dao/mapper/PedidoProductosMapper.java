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
public class PedidoProductosMapper implements RowMapper<PedidoProducto> {

    public PedidoProductosMapper() {
    }

    @Override
    public PedidoProducto mapRow(ResultSet rs, int i) throws SQLException {
        
        PedidoProducto pedido = new PedidoProducto();
        Productos dto = new Productos();   
        dto.setIdProducto(rs.getInt(1));
        dto.setIdProveedor(rs.getInt(2));
        dto.setCodigo(rs.getString(3));
        dto.setPrecio(rs.getDouble(4));        
        pedido.setFecha(rs.getDate(5));
        dto.setMarca(rs.getString(6));        
        dto.setDescripcion(rs.getString(7));        
        pedido.setProductos(dto);
        pedido.setUtilidad(rs.getDouble(9));
        pedido.setCantidad(rs.getInt(8));
        pedido.setEmpresa(rs.getString(10));
        pedido.setIdPedido(rs.getInt(11));
        return pedido;
    }
}
