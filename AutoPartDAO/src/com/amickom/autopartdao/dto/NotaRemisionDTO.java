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
public class NotaRemisionDTO {
        
    /**
     * Datos del pedido
     */
    private Pedido pedido;
    
    /**
     * Datos del cliente
     */
    private Cliente cliente;
    
    /**
     * Datos del producto en el pedido
     */
    private List<PedidoProducto> pedidoproducto;
    
    /**
     * Subtotal del pedido
     */
    private double subtotal;
    
    /**
     * Total del pedido
     */
    private double total;

    /**
     * @return the pedido
     */
    public Pedido getPedido() {
        return pedido;
    }

    /**
     * @param pedido the pedido to set
     */
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

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
     * @return the subtotal
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the pedidoproducto
     */
    public List<PedidoProducto> getPedidoproducto() {
        return pedidoproducto;
    }

    /**
     * @param pedidoproducto the pedidoproducto to set
     */
    public void setPedidoproducto(List<PedidoProducto> pedidoproducto) {
        this.pedidoproducto = pedidoproducto;
    }
    
}
