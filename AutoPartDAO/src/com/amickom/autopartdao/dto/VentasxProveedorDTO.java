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
public class VentasxProveedorDTO {

    /**
     * Cliente al que se le realiza la venta
     */
    private Proveedor proveedor;
    /**
     * Datos de los productos vendidos al cliente
     */
    private List<PedidoProducto> productopedido;

    /**
     * @return the proveedor
     */
    public Proveedor getProveedor() {
        return proveedor;
    }

    /**
     * @param proveedor the proveedor to set
     */
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
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
