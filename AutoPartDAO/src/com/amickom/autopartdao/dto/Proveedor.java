package com.amickom.autopartdao.dto;

import java.io.Serializable;
import java.util.Date;

public class Proveedor implements Serializable
{
	/** 
	 * This attribute maps to the column ID in the PROVEEDOR table.
	 */
	protected Integer id;

	/** 
	 * This attribute maps to the column EMPRESA in the PROVEEDOR table.
	 */
	protected String empresa;

	/** 
	 * This attribute maps to the column RFC in the PROVEEDOR table.
	 */
	protected String rfc;

	/** 
	 * This attribute maps to the column DIRECCION in the PROVEEDOR table.
	 */
	protected String direccion;

	/** 
	 * This attribute maps to the column CP in the PROVEEDOR table.
	 */
	protected String cp;

	/** 
	 * This attribute maps to the column CIUDAD in the PROVEEDOR table.
	 */
	protected String ciudad;

	/** 
	 * This attribute maps to the column TELEFONO in the PROVEEDOR table.
	 */
	protected String telefono;

	/** 
	 * This attribute maps to the column CELULAR in the PROVEEDOR table.
	 */
	protected String celular;

	/** 
	 * This attribute maps to the column EMAIL in the PROVEEDOR table.
	 */
	protected String email;

	/** 
	 * This attribute maps to the column FECHA_REGISTRO in the PROVEEDOR table.
	 */
	protected Date fechaRegistro;
        
        private int comision_fija;
        
        private double porcentaje_comision;

	/**
	 * Method 'Proveedor'
	 * 
	 */
	public Proveedor()
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
	 * Method 'getEmpresa'
	 * 
	 * @return String
	 */
	public String getEmpresa()
	{
		return empresa;
	}

	/**
	 * Method 'setEmpresa'
	 * 
	 * @param empresa
	 */
	public void setEmpresa(String empresa)
	{
		this.empresa = empresa;
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
	 * Method 'getCp'
	 * 
	 * @return String
	 */
	public String getCp()
	{
		return cp;
	}

	/**
	 * Method 'setCp'
	 * 
	 * @param cp
	 */
	public void setCp(String cp)
	{
		this.cp = cp;
	}

	/**
	 * Method 'getCiudad'
	 * 
	 * @return String
	 */
	public String getCiudad()
	{
		return ciudad;
	}

	/**
	 * Method 'setCiudad'
	 * 
	 * @param ciudad
	 */
	public void setCiudad(String ciudad)
	{
		this.ciudad = ciudad;
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
	 * Method 'getCelular'
	 * 
	 * @return String
	 */
	public String getCelular()
	{
		return celular;
	}

	/**
	 * Method 'setCelular'
	 * 
	 * @param celular
	 */
	public void setCelular(String celular)
	{
		this.celular = celular;
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
		
		if (!(_other instanceof Proveedor)) {
			return false;
		}
		
		final Proveedor _cast = (Proveedor) _other;
		if (id == null ? _cast.id != id : !id.equals( _cast.id )) {
			return false;
		}
		
		if (empresa == null ? _cast.empresa != empresa : !empresa.equals( _cast.empresa )) {
			return false;
		}
		
		if (rfc == null ? _cast.rfc != rfc : !rfc.equals( _cast.rfc )) {
			return false;
		}
		
		if (direccion == null ? _cast.direccion != direccion : !direccion.equals( _cast.direccion )) {
			return false;
		}
		
		if (cp == null ? _cast.cp != cp : !cp.equals( _cast.cp )) {
			return false;
		}
		
		if (ciudad == null ? _cast.ciudad != ciudad : !ciudad.equals( _cast.ciudad )) {
			return false;
		}
		
		if (telefono == null ? _cast.telefono != telefono : !telefono.equals( _cast.telefono )) {
			return false;
		}
		
		if (celular == null ? _cast.celular != celular : !celular.equals( _cast.celular )) {
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
		
		if (empresa != null) {
			_hashCode = 29 * _hashCode + empresa.hashCode();
		}
		
		if (rfc != null) {
			_hashCode = 29 * _hashCode + rfc.hashCode();
		}
		
		if (direccion != null) {
			_hashCode = 29 * _hashCode + direccion.hashCode();
		}
		
		if (cp != null) {
			_hashCode = 29 * _hashCode + cp.hashCode();
		}
		
		if (ciudad != null) {
			_hashCode = 29 * _hashCode + ciudad.hashCode();
		}
		
		if (telefono != null) {
			_hashCode = 29 * _hashCode + telefono.hashCode();
		}
		
		if (celular != null) {
			_hashCode = 29 * _hashCode + celular.hashCode();
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
	 * @return ProveedorPk
	 */
	public ProveedorPk createPk()
	{
		return new ProveedorPk(id);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.amickom.autopartdao.dto.Proveedor: " );
		ret.append( "id=" + id );
		ret.append( ", empresa=" + empresa );
		ret.append( ", rfc=" + rfc );
		ret.append( ", direccion=" + direccion );
		ret.append( ", cp=" + cp );
		ret.append( ", ciudad=" + ciudad );
		ret.append( ", telefono=" + telefono );
		ret.append( ", celular=" + celular );
		ret.append( ", email=" + email );
		ret.append( ", fechaRegistro=" + fechaRegistro );
		return ret.toString();
	}

    /**
     * @return the comision_fija
     */
    public int getComision_fija() {
        return comision_fija;
    }

    /**
     * @param comision_fija the comision_fija to set
     */
    public void setComision_fija(int comision_fija) {
        this.comision_fija = comision_fija;
    }

    /**
     * @return the porcentaje_comision
     */
    public double getPorcentaje_comision() {
        return porcentaje_comision;
    }

    /**
     * @param porcentaje_comision the porcentaje_comision to set
     */
    public void setPorcentaje_comision(double porcentaje_comision) {
        this.porcentaje_comision = porcentaje_comision;
    }

}
