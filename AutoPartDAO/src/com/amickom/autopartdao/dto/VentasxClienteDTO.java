/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amickom.autopartdao.dto;

import java.util.List;

/**
 *
 * @author david
 */
public class VentasxClienteDTO {

    /**
     * Cliente al que se le realiza la venta
     */
    private Cliente cliente;
    /**
     * Datos de los productos vendidos al cliente
     */
    private List<PedidoProducto> productopedido;

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the productopedido
     */
    public List<PedidoProducto> getProductopedido() {
        return productopedido;
    }

    /**
     * @param productopedido the productopedido to set
     */
    public void setProductopedido(List<PedidoProducto> productopedido) {
        this.productopedido = productopedido;
    }
}
