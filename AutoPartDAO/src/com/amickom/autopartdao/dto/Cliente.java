package com.amickom.autopartdao.dto;

import java.io.Serializable;
import java.util.Date;

public class Cliente implements Serializable
{
	/** 
	 * This attribute maps to the column ID in the CLIENTE table.
	 */
	protected Integer id;

	/** 
	 * This attribute maps to the column NOMBRE in the CLIENTE table.
	 */
	protected String nombre;

	/** 
	 * This attribute maps to the column RFC in the CLIENTE table.
	 */
	protected String rfc;

	/** 
	 * This attribute maps to the column DIRECCION in the CLIENTE table.
	 */
	protected String direccion;

	/** 
	 * This attribute maps to the column TELEFONO in the CLIENTE table.
	 */
	protected String telefono;

	/** 
	 * This attribute maps to the column EMAIL in the CLIENTE table.
	 */
	protected String email;

	/** 
	 * This attribute maps to the column FECHA_REGISTRO in the CLIENTE table.
	 */
	protected Date fechaRegistro;
        
        private String cp;
        
        private String ciudad;
        
        private String celular;

	/**
	 * Method 'Cliente'
	 * 
	 */
	public Cliente()
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
	 * Method 'getRfc'
	 * 
	 * @return String
	 */
	public String getRfc()
	{
		return rfc;
	}

	/**
	 * Method 'setRfc'
	 * 
	 * @param rfc
	 */
	public void setRfc(String rfc)
	{
		this.rfc = rfc;
	}

	/**
	 * Method 'getDireccion'
	 * 
	 * @return String
	 */
	public String getDireccion()
	{
		return direccion;
	}

	/**
	 * Method 'setDireccion'
	 * 
	 * @param direccion
	 */
	public void setDireccion(String direccion)
	{
		this.direccion = direccion;
	}

	/**
	 * Method 'getTelefono'
	 * 
	 * @return String
	 */
	public String getTelefono()
	{
		return telefono;
	}

	/**
	 * Method 'setTelefono'
	 * 
	 * @param telefono
	 */
	public void setTelefono(String telefono)
	{
		this.telefono = telefono;
	}

	/**
	 * Method 'getEmail'
	 * 
	 * @return String
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * Method 'setEmail'
	 * 
	 * @param email
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

	/**
	 * Method 'getFechaRegistro'
	 * 
	 * @return Date
	 */
	public Date getFechaRegistro()
	{
		return fechaRegistro;
	}

	/**
	 * Method 'setFechaRegistro'
	 * 
	 * @param fechaRegistro
	 */
	public void setFechaRegistro(Date fechaRegistro)
	{
		this.fechaRegistro = fechaRegistro;
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
		
		if (!(_other instanceof Cliente)) {
			return false;
		}
		
		final Cliente _cast = (Cliente) _other;
		if (id == null ? _cast.id != id : !id.equals( _cast.id )) {
			return false;
		}
		
		if (nombre == null ? _cast.nombre != nombre : !nombre.equals( _cast.nombre )) {
			return false;
		}
		
		if (rfc == null ? _cast.rfc != rfc : !rfc.equals( _cast.rfc )) {
			return false;
		}
		
		if (direccion == null ? _cast.direccion != direccion : !direccion.equals( _cast.direccion )) {
			return false;
		}
		
		if (telefono == null ? _cast.telefono != telefono : !telefono.equals( _cast.telefono )) {
			return false;
		}
		
		if (email == null ? _cast.email != email : !email.equals( _cast.email )) {
			return false;
		}
		
		if (fechaRegistro == null ? _cast.fechaRegistro != fechaRegistro : !fechaRegistro.equals( _cast.fechaRegistro )) {
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
		
		if (nombre != null) {
			_hashCode = 29 * _hashCode + nombre.hashCode();
		}
		
		if (rfc != null) {
			_hashCode = 29 * _hashCode + rfc.hashCode();
		}
		
		if (direccion != null) {
			_hashCode = 29 * _hashCode + direccion.hashCode();
		}
		
		if (telefono != null) {
			_hashCode = 29 * _hashCode + telefono.hashCode();
		}
		
		if (email != null) {
			_hashCode = 29 * _hashCode + email.hashCode();
		}
		
		if (fechaRegistro != null) {
			_hashCode = 29 * _hashCode + fechaRegistro.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return ClientePk
	 */
	public ClientePk createPk()
	{
		return new ClientePk(id);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.amickom.autopartdao.dto.Cliente: " );
		ret.append( "id=" + id );
		ret.append( ", nombre=" + nombre );
		ret.append( ", rfc=" + rfc );
		ret.append( ", direccion=" + direccion );
		ret.append( ", telefono=" + telefono );
		ret.append( ", email=" + email );
		ret.append( ", fechaRegistro=" + fechaRegistro );
		return ret.toString();
	}

    /**
     * @return the cp
     */
    public String getCp() {
        return cp;
    }

    /**
     * @param cp the cp to set
     */
    public void setCp(String cp) {
        this.cp = cp;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

}
