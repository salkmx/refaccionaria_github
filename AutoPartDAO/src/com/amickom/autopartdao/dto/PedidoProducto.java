package com.amickom.autopartdao.dto;

import java.io.Serializable;
import java.util.Date;

public class PedidoProducto implements Serializable
{
	/** 
	 * This attribute maps to the column ID_PEDIDO in the PEDIDO_PRODUCTO table.
	 */
	protected Integer idPedido;

	/** 
	 * This attribute maps to the column ID_PRODUCTO in the PEDIDO_PRODUCTO table.
	 */
	protected Integer idProducto;
        
        private int cantidad;
        
        private double utilidad;
        
        private double precioVenta;
        
        private Productos productos;
        
        /**
         * Private fecha
         */
        private Date fecha;
        
        /**
         * 
         */
        private String empresa;

	/**
	 * Method 'PedidoProducto'
	 * 
	 */
	public PedidoProducto()
	{
	}

	/**
	 * Method 'getIdPedido'
	 * 
	 * @return Integer
	 */
	public Integer getIdPedido()
	{
		return idPedido;
	}

	/**
	 * Method 'setIdPedido'
	 * 
	 * @param idPedido
	 */
	public void setIdPedido(Integer idPedido)
	{
		this.idPedido = idPedido;
	}

	/**
	 * Method 'getIdProducto'
	 * 
	 * @return Integer
	 */
	public Integer getIdProducto()
	{
		return idProducto;
	}

	/**
	 * Method 'setIdProducto'
	 * 
	 * @param idProducto
	 */
	public void setIdProducto(Integer idProducto)
	{
		this.idProducto = idProducto;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof PedidoProducto)) {
			return false;
		}
		
		final PedidoProducto _cast = (PedidoProducto) _other;
		if (idPedido == null ? _cast.idPedido != idPedido : !idPedido.equals( _cast.idPedido )) {
			return false;
		}
		
		if (idProducto == null ? _cast.idProducto != idProducto : !idProducto.equals( _cast.idProducto )) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode()
	{
		int _hashCode = 0;
		if (idPedido != null) {
			_hashCode = 29 * _hashCode + idPedido.hashCode();
		}
		
		if (idProducto != null) {
			_hashCode = 29 * _hashCode + idProducto.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return PedidoProductoPk
	 */
	public PedidoProductoPk createPk()
	{
		return new PedidoProductoPk(idPedido, idProducto);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.amickom.autopartdao.dto.PedidoProducto: " );
		ret.append( "idPedido=" + idPedido );
		ret.append( ", idProducto=" + idProducto );
		return ret.toString();
	}

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

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
     * @return the productos
     */
    public Productos getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * @return the precioVenta
     */
    public double getPrecioVenta() {
        return precioVenta;
    }

    /**
     * @param precioVenta the precioVenta to set
     */
    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

}
