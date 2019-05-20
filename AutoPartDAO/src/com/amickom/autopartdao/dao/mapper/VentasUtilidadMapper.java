/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amickom.autopartdao.dao.mapper;

import com.amickom.autopartdao.dto.PedidoProducto;
import com.amickom.autopartdao.dto.Productos;
import com.amickom.autopartdao.dto.VentasUtilidadDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author david
 */
public class VentasUtilidadMapper implements RowMapper<VentasUtilidadDTO> {

    public VentasUtilidadMapper() {
    }

    @Override
    public VentasUtilidadDTO mapRow(ResultSet rs, int i) throws SQLException {
        VentasUtilidadDTO ventas = new VentasUtilidadDTO();
        ventas.setCliente(rs.getString(3));
        ventas.setPrecioTotal(rs.getDouble(1));
        ventas.setUtilidad(rs.getDouble(2));
        return ventas;
    }
}
