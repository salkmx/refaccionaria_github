/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amickom.service;

import com.amickom.autopartdao.dto.NotaRemisionDTO;
import com.amickom.autopartdao.dto.PedidoProducto;
import java.util.List;

/**
 *
 * @author david
 */
public interface IPedidoService {
    
    /**
     * Método que realiza el alta de un pedido para su envío a proveedor
     * @param nombre nombre del cliente del pedido
     * @param productos productos que incluye el pedido
     * @param iva iva del pedido
     * @param total total del pedido realizado
     * @return boolean true en caso de alta exitosa, false en caso contrario
     */
    public NotaRemisionDTO altaPedido(String nombre, List<PedidoProducto> productos, 
            double iva, double total);
    
}
