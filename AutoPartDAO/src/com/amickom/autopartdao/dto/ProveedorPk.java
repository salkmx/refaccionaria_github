package com.amickom.autopartdao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the PROVEEDOR table.
 */
public class ProveedorPk implements Serializable
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
	 * Method 'ProveedorPk'
	 * 
	 */
	public ProveedorPk()
	{
	}

	/**
	 * Method 'ProveedorPk'
	 * 
	 * @param id
	 */
	public ProveedorPk(final Integer id)
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
		
		if (!(_other instanceof ProveedorPk)) {
			return false;
		}
		
		final ProveedorPk _cast = (ProveedorPk) _other;
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
		ret.append( "com.amickom.autopartdao.dto.ProveedorPk: " );
		ret.append( "id=" + id );
		return ret.toString();
	}

}
