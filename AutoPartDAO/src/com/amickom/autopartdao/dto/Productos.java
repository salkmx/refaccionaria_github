package com.amickom.autopartdao.dto;

import java.io.Serializable;
import java.util.Date;

public class Productos implements Serializable {

    /** 
     * This attribute maps to the column ID_PRODUCTO in the PRODUCTOS table.
     */
    protected Integer idProducto;
    /** 
     * This attribute maps to the column ID_PROVEEDOR in the PRODUCTOS table.
     */
    protected Integer idProveedor;
    /** 
     * This attribute maps to the column CODIGO in the PRODUCTOS table.
     */
    protected String codigo;
    /** 
     * This attribute maps to the column PRECIO in the PRODUCTOS table.
     */
    protected Double precio;
    /** 
     * This attribute maps to the column FECHA_ALTA in the PRODUCTOS table.
     */
    protected Date fechaAlta;
    /** 
     * This attribute maps to the column MARCA in the PRODUCTOS table.
     */
    protected String marca;
    /**
     * Descripción del producto de 
     */
    protected String descripcion;
    
    /**
     * Si el campo ha sido seleccionado para un pedido
     */
    private boolean isSeleccionado;
    
    /**
     * Indice de la lista
     */
    private int indiceLista;
    
    /**
     * Si la comision es fija
     */
    private int comisionfija;
    
    /**
     * 
     */
    private double comision;
    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Method 'Productos'
     * 
     */
    public Productos() {
    }

    /**
     * Method 'getIdProducto'
     * 
     * @return Integer
     */
    public Integer getIdProducto() {
        return idProducto;
    }

    /**
     * Method 'setIdProducto'
     * 
     * @param idProducto
     */
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * Method 'getIdProveedor'
     * 
     * @return Integer
     */
    public Integer getIdProveedor() {
        return idProveedor;
    }

    /**
     * Method 'setIdProveedor'
     * 
     * @param idProveedor
     */
    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    /**
     * Method 'getCodigo'
     * 
     * @return String
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Method 'setCodigo'
     * 
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
     * Method 'getMarca'
     * 
     * @return String
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Method 'setMarca'
     * 
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
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

        if (!(_other instanceof Productos)) {
            return false;
        }

        final Productos _cast = (Productos) _other;
        if (idProducto == null ? _cast.idProducto != idProducto : !idProducto.equals(_cast.idProducto)) {
            return false;
        }

        if (idProveedor == null ? _cast.idProveedor != idProveedor : !idProveedor.equals(_cast.idProveedor)) {
            return false;
        }

        if (codigo == null ? _cast.codigo != codigo : !codigo.equals(_cast.codigo)) {
            return false;
        }

        if (precio == null ? _cast.precio != precio : !precio.equals(_cast.precio)) {
            return false;
        }

        if (fechaAlta == null ? _cast.fechaAlta != fechaAlta : !fechaAlta.equals(_cast.fechaAlta)) {
            return false;
        }

        if (marca == null ? _cast.marca != marca : !marca.equals(_cast.marca)) {
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
        if (idProducto != null) {
            _hashCode = 29 * _hashCode + idProducto.hashCode();
        }

        if (idProveedor != null) {
            _hashCode = 29 * _hashCode + idProveedor.hashCode();
        }

        if (codigo != null) {
            _hashCode = 29 * _hashCode + codigo.hashCode();
        }

        if (precio != null) {
            _hashCode = 29 * _hashCode + precio.hashCode();
        }

        if (fechaAlta != null) {
            _hashCode = 29 * _hashCode + fechaAlta.hashCode();
        }

        if (marca != null) {
            _hashCode = 29 * _hashCode + marca.hashCode();
        }

        return _hashCode;
    }

    /**
     * Method 'createPk'
     * 
     * @return ProductosPk
     */
    public ProductosPk createPk() {
        return new ProductosPk(idProducto);
    }

    /**
     * Method 'toString'
     * 
     * @return String
     */
    public String toString() {
        StringBuffer ret = new StringBuffer();
        ret.append("com.amickom.autopartdao.dto.Productos: ");
        ret.append("idProducto=" + idProducto);
        ret.append(", idProveedor=" + idProveedor);
        ret.append(", codigo=" + codigo);
        ret.append(", precio=" + precio);
        ret.append(", fechaAlta=" + fechaAlta);
        ret.append(", marca=" + marca);
        return ret.toString();
    }

    /**
     * @return the isSeleccionado
     */
    public boolean isIsSeleccionado() {
        return isSeleccionado;
    }

    /**
     * @param isSeleccionado the isSeleccionado to set
     */
    public void setIsSeleccionado(boolean isSeleccionado) {
        this.isSeleccionado = isSeleccionado;
    }

    /**
     * @return the indiceLista
     */
    public int getIndiceLista() {
        return indiceLista;
    }

    /**
     * @param indiceLista the indiceLista to set
     */
    public void setIndiceLista(int indiceLista) {
        this.indiceLista = indiceLista;
    }

    /**
     * @return the comisionfija
     */
    public int getComisionfija() {
        return comisionfija;
    }

    /**
     * @param comisionfija the comisionfija to set
     */
    public void setComisionfija(int comisionfija) {
        this.comisionfija = comisionfija;
    }

    /**
     * @return the comision
     */
    public double getComision() {
        return comision;
    }

    /**
     * @param comision the comision to set
     */
    public void setComision(double comision) {
        this.comision = comision;
    }
}
