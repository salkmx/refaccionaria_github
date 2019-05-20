package com.amickom.autopartdao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the PEDIDO_PRODUCTO table.
 */
public class PedidoProductoPk implements Serializable
{
	protected Integer idPedido;

	protected Integer idProducto;

	/** 
	 * Sets the value of idPedido
	 */
	public void setIdPedido(Integer idPedido)
	{
		this.idPedido = idPedido;
	}

	/** 
	 * Gets the value of idPedido
	 */
	public Integer getIdPedido()
	{
		return idPedido;
	}

	/** 
	 * Sets the value of idProducto
	 */
	public void setIdProducto(Integer idProducto)
	{
		this.idProducto = idProducto;
	}

	/** 
	 * Gets the value of idProducto
	 */
	public Integer getIdProducto()
	{
		return idProducto;
	}

	/**
	 * Method 'PedidoProductoPk'
	 * 
	 */
	public PedidoProductoPk()
	{
	}

	/**
	 * Method 'PedidoProductoPk'
	 * 
	 * @param idPedido
	 * @param idProducto
	 */
	public PedidoProductoPk(final Integer idPedido, final Integer idProducto)
	{
		this.idPedido = idPedido;
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
		
		if (!(_other instanceof PedidoProductoPk)) {
			return false;
		}
		
		final PedidoProductoPk _cast = (PedidoProductoPk) _other;
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
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.amickom.autopartdao.dto.PedidoProductoPk: " );
		ret.append( "idPedido=" + idPedido );
		ret.append( ", idProducto=" + idProducto );
		return ret.toString();
	}

}
