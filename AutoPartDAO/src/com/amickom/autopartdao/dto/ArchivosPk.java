package com.amickom.autopartdao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the ARCHIVOS table.
 */
public class ArchivosPk implements Serializable
{
	protected int id;

	/** 
	 * This attribute represents whether the primitive attribute id is null.
	 */
	protected boolean idNull;

	/** 
	 * Sets the value of id
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/** 
	 * Gets the value of id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * Method 'ArchivosPk'
	 * 
	 */
	public ArchivosPk()
	{
	}

	/**
	 * Method 'ArchivosPk'
	 * 
	 * @param id
	 */
	public ArchivosPk(final int id)
	{
		this.id = id;
	}

	/** 
	 * Sets the value of idNull
	 */
	public void setIdNull(boolean idNull)
	{
		this.idNull = idNull;
	}

	/** 
	 * Gets the value of idNull
	 */
	public boolean isIdNull()
	{
		return idNull;
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
		
		if (!(_other instanceof ArchivosPk)) {
			return false;
		}
		
		final ArchivosPk _cast = (ArchivosPk) _other;
		if (id != _cast.id) {
			return false;
		}
		
		if (idNull != _cast.idNull) {
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
		_hashCode = 29 * _hashCode + id;
		_hashCode = 29 * _hashCode + (idNull ? 1 : 0);
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
		ret.append( "com.amickom.autopartdao.dto.ArchivosPk: " );
		ret.append( "id=" + id );
		return ret.toString();
	}

}
