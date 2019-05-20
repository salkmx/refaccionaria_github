package com.amickom.autopartdao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the PRODUCTOS table.
 */
public class ProductosPk implements Serializable
{
	protected Integer idProducto;

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
	 * Method 'ProductosPk'
	 * 
	 */
	public ProductosPk()
	{
	}

	/**
	 * Method 'ProductosPk'
	 * 
	 * @param idProducto
	 */
	public ProductosPk(final Integer idProducto)
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
		
		if (!(_other instanceof ProductosPk)) {
			return false;
		}
		
		final ProductosPk _cast = (ProductosPk) _other;
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
		ret.append( "com.amickom.autopartdao.dto.ProductosPk: " );
		ret.append( "idProducto=" + idProducto );
		return ret.toString();
	}

}
