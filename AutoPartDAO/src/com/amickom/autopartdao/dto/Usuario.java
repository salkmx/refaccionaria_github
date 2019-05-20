package com.amickom.autopartdao.dto;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable
{
	/** 
	 * This attribute maps to the column ID in the USUARIO table.
	 */
	protected Integer id;

	/** 
	 * This attribute maps to the column CLAVE in the USUARIO table.
	 */
	protected String clave;

	/** 
	 * This attribute maps to the column PASSWORD in the USUARIO table.
	 */
	protected String password;

	/** 
	 * This attribute maps to the column FECHA_ALTA in the USUARIO table.
	 */
	protected Date fechaAlta;

	/** 
	 * This attribute maps to the column ROL in the USUARIO table.
	 */
	protected String rol;

	/**
	 * Method 'Usuario'
	 * 
	 */
	public Usuario()
	{
	}

	/**
	 * Method 'getId'
	 * 
	 * @return Integer
	 */
	public Integer getId()
	{
		return id;
	}

	/**
	 * Method 'setId'
	 * 
	 * @param id
	 */
	public void setId(Integer id)
	{
		this.id = id;
	}

	/**
	 * Method 'getClave'
	 * 
	 * @return String
	 */
	public String getClave()
	{
		return clave;
	}

	/**
	 * Method 'setClave'
	 * 
	 * @param clave
	 */
	public void setClave(String clave)
	{
		this.clave = clave;
	}

	/**
	 * Method 'getPassword'
	 * 
	 * @return String
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * Method 'setPassword'
	 * 
	 * @param password
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * Method 'getFechaAlta'
	 * 
	 * @return Date
	 */
	public Date getFechaAlta()
	{
		return fechaAlta;
	}

	/**
	 * Method 'setFechaAlta'
	 * 
	 * @param fechaAlta
	 */
	public void setFechaAlta(Date fechaAlta)
	{
		this.fechaAlta = fechaAlta;
	}

	/**
	 * Method 'getRol'
	 * 
	 * @return String
	 */
	public String getRol()
	{
		return rol;
	}

	/**
	 * Method 'setRol'
	 * 
	 * @param rol
	 */
	public void setRol(String rol)
	{
		this.rol = rol;
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
		
		if (!(_other instanceof Usuario)) {
			return false;
		}
		
		final Usuario _cast = (Usuario) _other;
		if (id == null ? _cast.id != id : !id.equals( _cast.id )) {
			return false;
		}
		
		if (clave == null ? _cast.clave != clave : !clave.equals( _cast.clave )) {
			return false;
		}
		
		if (password == null ? _cast.password != password : !password.equals( _cast.password )) {
			return false;
		}
		
		if (fechaAlta == null ? _cast.fechaAlta != fechaAlta : !fechaAlta.equals( _cast.fechaAlta )) {
			return false;
		}
		
		if (rol == null ? _cast.rol != rol : !rol.equals( _cast.rol )) {
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
		
		if (clave != null) {
			_hashCode = 29 * _hashCode + clave.hashCode();
		}
		
		if (password != null) {
			_hashCode = 29 * _hashCode + password.hashCode();
		}
		
		if (fechaAlta != null) {
			_hashCode = 29 * _hashCode + fechaAlta.hashCode();
		}
		
		if (rol != null) {
			_hashCode = 29 * _hashCode + rol.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return UsuarioPk
	 */
	public UsuarioPk createPk()
	{
		return new UsuarioPk(id);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.amickom.autopartdao.dto.Usuario: " );
		ret.append( "id=" + id );
		ret.append( ", clave=" + clave );
		ret.append( ", password=" + password );
		ret.append( ", fechaAlta=" + fechaAlta );
		ret.append( ", rol=" + rol );
		return ret.toString();
	}

}
