/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amickom.autopartdao.dto;

/**
 *
 * @author david
 */
public class VentasUtilidadDTO {
    
    private double utilidad;
    
    private double precioTotal;
    
    private String cliente;

    /**
     * @return the utilidad
     */
    public double getUtilidad() {
        return utilidad;
    }

    /**
     * @param utilidad the utilidad to set
     */
    public void setUtilidad(double utilidad) {
        this.utilidad = utilidad;
    }

    /**
     * @return the precioTotal
     */
    public double getPrecioTotal() {
        return precioTotal;
    }

    /**
     * @param precioTotal the precioTotal to set
     */
    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
}
