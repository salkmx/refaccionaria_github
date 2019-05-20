package com.amickom.autopartdao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the PEDIDO table.
 */
public class PedidoPk implements Serializable
{
	protected Integer id;

	/** 
	 * Sets the value of id
	 */
	public void setId(Integer id)
	{
		this.id = id;
	}

	/** 
	 * Gets the value of id
	 */
	public Integer getId()
	{
		return id;
	}

	/**
	 * Method 'PedidoPk'
	 * 
	 */
	public PedidoPk()
	{
	}

	/**
	 * Method 'PedidoPk'
	 * 
	 * @param id
	 */
	public PedidoPk(final Integer id)
	{
		this.id = id;
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
		
		if (!(_other instanceof PedidoPk)) {
			return false;
		}
		
		final PedidoPk _cast = (PedidoPk) _other;
		if (id == null ? _cast.id != id : !id.equals( _cast.id )) {
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
		if (id != null) {
			_hashCode = 29 * _hashCode + id.hashCode();
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
		ret.append( "com.amickom.autopartdao.dto.PedidoPk: " );
		ret.append( "id=" + id );
		return ret.toString();
	}

}
