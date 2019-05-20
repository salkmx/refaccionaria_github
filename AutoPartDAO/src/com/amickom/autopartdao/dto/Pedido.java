package com.amickom.autopartdao.dto;

import com.amickom.autopartdao.dao.*;
import com.amickom.autopartdao.factory.*;
import com.amickom.autopartdao.exceptions.*;
import java.io.Serializable;
import java.util.*;
import java.util.Date;

public class Pedido implements Serializable {

    /** 
     * This attribute maps to the column ID in the PEDIDO table.
     */
    protected Integer id;
    /** 
     * This attribute maps to the column ID_CLIENTE in the PEDIDO table.
     */
    protected Integer idCliente;
    /** 
     * This attribute maps to the column FECHA_ALTA in the PEDIDO table.
     */
    protected Date fechaAlta;
    /** 
     * This attribute maps to the column PRECIO in the PEDIDO table.
     */
    protected Double precio;
    /** 
     * This attribute maps to the column IVA in the PEDIDO table.
     */
    protected Double iva;
    /** 
     * This attribute maps to the column ID_USUARIO in the PEDIDO table.
     */
    protected Integer idUsuario;
    /**
     * 
     */
    private PedidoProducto pedidos;
    private Double subtotal;

    /**
     * Method 'Pedido'
     * 
     */
    public Pedido() {
    }

    /**
     * Method 'getId'
     * 
     * @return Integer
     */
    public Integer getId() {
        return id;
    }

    /**
     * Method 'setId'
     * 
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Method 'getIdCliente'
     * 
     * @return Integer
     */
    public Integer getIdCliente() {
        return idCliente;
    }

    /**
     * Method 'setIdCliente'
     * 
     * @param idCliente
     */
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Method 'getFechaAlta'
     * 
     * @return Date
     */
    public Date getFechaAlta() {
        return fechaAlta;
    }

    /**
     * Method 'setFechaAlta'
     * 
     * @param fechaAlta
     */
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    /**
     * Method 'getPrecio'
     * 
     * @return Double
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * Method 'setPrecio'
     * 
     * @param precio
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * Method 'getIva'
     * 
     * @return Double
     */
    public Double getIva() {
        return iva;
    }

    /**
     * Method 'setIva'
     * 
     * @param iva
     */
    public void setIva(Double iva) {
        this.iva = iva;
    }

    /**
     * Method 'getIdUsuario'
     * 
     * @return Integer
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * Method 'setIdUsuario'
     * 
     * @param idUsuario
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Method 'equals'
     * 
     * @param _other
     * @return boolean
     */
    public boolean equals(Object _other) {
        if (_other == null) {
            return false;
        }

        if (_other == this) {
            return true;
        }

        if (!(_other instanceof Pedido)) {
            return false;
        }

        final Pedido _cast = (Pedido) _other;
        if (id == null ? _cast.id != id : !id.equals(_cast.id)) {
            return false;
        }

        if (idCliente == null ? _cast.idCliente != idCliente : !idCliente.equals(_cast.idCliente)) {
            return false;
        }

        if (fechaAlta == null ? _cast.fechaAlta != fechaAlta : !fechaAlta.equals(_cast.fechaAlta)) {
            return false;
        }

        if (precio == null ? _cast.precio != precio : !precio.equals(_cast.precio)) {
            return false;
        }

        if (iva == null ? _cast.iva != iva : !iva.equals(_cast.iva)) {
            return false;
        }

        if (idUsuario == null ? _cast.idUsuario != idUsuario : !idUsuario.equals(_cast.idUsuario)) {
            return false;
        }

        return true;
    }

    /**
     * Method 'hashCode'
     * 
     * @return int
     */
    public int hashCode() {
        int _hashCode = 0;
        if (id != null) {
            _hashCode = 29 * _hashCode + id.hashCode();
        }

        if (idCliente != null) {
            _hashCode = 29 * _hashCode + idCliente.hashCode();
        }

        if (fechaAlta != null) {
            _hashCode = 29 * _hashCode + fechaAlta.hashCode();
        }

        if (precio != null) {
            _hashCode = 29 * _hashCode + precio.hashCode();
        }

        if (iva != null) {
            _hashCode = 29 * _hashCode + iva.hashCode();
        }

        if (idUsuario != null) {
            _hashCode = 29 * _hashCode + idUsuario.hashCode();
        }

        return _hashCode;
    }

    /**
     * Method 'createPk'
     * 
     * @return PedidoPk
     */
    public PedidoPk createPk() {
        return new PedidoPk(id);
    }

    /**
     * Method 'toString'
     * 
     * @return String
     */
    public String toString() {
        StringBuffer ret = new StringBuffer();
        ret.append("com.amickom.autopartdao.dto.Pedido: ");
        ret.append("id=" + id);
        ret.append(", idCliente=" + idCliente);
        ret.append(", fechaAlta=" + fechaAlta);
        ret.append(", precio=" + precio);
        ret.append(", iva=" + iva);
        ret.append(", idUsuario=" + idUsuario);
        return ret.toString();
    }

    /**
     * @return the pedidos
     */
    public PedidoProducto getPedidos() {
        return pedidos;
    }

    /**
     * @param pedidos the pedidos to set
     */
    public void setPedidos(PedidoProducto pedidos) {
        this.pedidos = pedidos;
    }

    /**
     * @return the subtotal
     */
    public Double getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
}
