package com.amickom.autopartdao.dto;

import com.amickom.autopartdao.dao.*;
import com.amickom.autopartdao.factory.*;
import com.amickom.autopartdao.exceptions.*;
import java.io.Serializable;
import java.util.*;
import java.util.Date;

public class Archivos implements Serializable
{
	/** 
	 * This attribute maps to the column ID in the ARCHIVOS table.
	 */
	protected int id;

	/** 
	 * This attribute maps to the column NOMBRE in the ARCHIVOS table.
	 */
	protected String nombre;

	/** 
	 * This attribute maps to the column ARCHIVO in the ARCHIVOS table.
	 */
	protected String archivo;

	/** 
	 * This attribute maps to the column ID_PROVEEDOR in the ARCHIVOS table.
	 */
	protected int idProveedor;

	/** 
	 * This attribute maps to the column FECHA_CAPTURA in the ARCHIVOS table.
	 */
	protected Date fechaCaptura;

	/**
	 * Method 'Archivos'
	 * 
	 */
	public Archivos()
	{
	}

	/**
	 * Method 'getId'
	 * 
	 * @return int
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * Method 'setId'
	 * 
	 * @param id
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * Method 'getNombre'
	 * 
	 * @return String
	 */
	public String getNombre()
	{
		return nombre;
	}

	/**
	 * Method 'setNombre'
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	/**
	 * Method 'getArchivo'
	 * 
	 * @return String
	 */
	public String getArchivo()
	{
		return archivo;
	}

	/**
	 * Method 'setArchivo'
	 * 
	 * @param archivo
	 */
	public void setArchivo(String archivo)
	{
		this.archivo = archivo;
	}

	/**
	 * Method 'getIdProveedor'
	 * 
	 * @return int
	 */
	public int getIdProveedor()
	{
		return idProveedor;
	}

	/**
	 * Method 'setIdProveedor'
	 * 
	 * @param idProveedor
	 */
	public void setIdProveedor(int idProveedor)
	{
		this.idProveedor = idProveedor;
	}

	/**
	 * Method 'getFechaCaptura'
	 * 
	 * @return Date
	 */
	public Date getFechaCaptura()
	{
		return fechaCaptura;
	}

	/**
	 * Method 'setFechaCaptura'
	 * 
	 * @param fechaCaptura
	 */
	public void setFechaCaptura(Date fechaCaptura)
	{
		this.fechaCaptura = fechaCaptura;
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
		
		if (!(_other instanceof Archivos)) {
			return false;
		}
		
		final Archivos _cast = (Archivos) _other;
		if (id != _cast.id) {
			return false;
		}
		
		if (nombre == null ? _cast.nombre != nombre : !nombre.equals( _cast.nombre )) {
			return false;
		}
		
		if (archivo == null ? _cast.archivo != archivo : !archivo.equals( _cast.archivo )) {
			return false;
		}
		
		if (idProveedor != _cast.idProveedor) {
			return false;
		}
		
		if (fechaCaptura == null ? _cast.fechaCaptura != fechaCaptura : !fechaCaptura.equals( _cast.fechaCaptura )) {
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
		if (nombre != null) {
			_hashCode = 29 * _hashCode + nombre.hashCode();
		}
		
		if (archivo != null) {
			_hashCode = 29 * _hashCode + archivo.hashCode();
		}
		
		_hashCode = 29 * _hashCode + idProveedor;
		if (fechaCaptura != null) {
			_hashCode = 29 * _hashCode + fechaCaptura.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return ArchivosPk
	 */
	public ArchivosPk createPk()
	{
		return new ArchivosPk(id);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.amickom.autopartdao.dto.Archivos: " );
		ret.append( "id=" + id );
		ret.append( ", nombre=" + nombre );
		ret.append( ", archivo=" + archivo );
		ret.append( ", idProveedor=" + idProveedor );
		ret.append( ", fechaCaptura=" + fechaCaptura );
		return ret.toString();
	}

}
