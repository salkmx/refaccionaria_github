package com.amickom.autopartdao.example;

import java.math.*;
import java.util.Date;
import java.util.List;
import com.amickom.autopartdao.dao.ProveedorDao;
import com.amickom.autopartdao.dto.Proveedor;
import com.amickom.autopartdao.exceptions.ProveedorDaoException;
import com.amickom.autopartdao.factory.DaoFactory;

public class ProveedorDaoExample
{
	/**
	 * Method 'main'
	 * 
	 * @param arg
	 * @throws Exception
	 */
	public static void main(String[] arg) throws Exception
	{
		// Uncomment one of the lines below to test the generated code
		
		// findAll();
		// findWhereIdEquals(null);
		// findWhereEmpresaEquals("");
		// findWhereRfcEquals("");
		// findWhereDireccionEquals("");
		// findWhereCpEquals("");
		// findWhereCiudadEquals("");
		// findWhereTelefonoEquals("");
		// findWhereCelularEquals("");
		// findWhereEmailEquals("");
		// findWhereFechaRegistroEquals(null);
	}

	/**
	 * Method 'findAll'
	 * 
	 * @throws Exception
	 */
	public static void findAll() throws Exception
	{
		ProveedorDao dao = DaoFactory.createProveedorDao();
		List<Proveedor> _result = dao.findAll();
		for (Proveedor dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'findWhereIdEquals'
	 * 
	 * @param id
	 * @throws Exception
	 */
	public static void findWhereIdEquals(Integer id) throws Exception
	{
		ProveedorDao dao = DaoFactory.createProveedorDao();
		List<Proveedor> _result = dao.findWhereIdEquals(id);
		for (Proveedor dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'findWhereEmpresaEquals'
	 * 
	 * @param empresa
	 * @throws Exception
	 */
	public static void findWhereEmpresaEquals(String empresa) throws Exception
	{
		ProveedorDao dao = DaoFactory.createProveedorDao();
		List<Proveedor> _result = dao.findWhereEmpresaEquals(empresa);
		for (Proveedor dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'findWhereRfcEquals'
	 * 
	 * @param rfc
	 * @throws Exception
	 */
	public static void findWhereRfcEquals(String rfc) throws Exception
	{
		ProveedorDao dao = DaoFactory.createProveedorDao();
		List<Proveedor> _result = dao.findWhereRfcEquals(rfc);
		for (Proveedor dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'findWhereDireccionEquals'
	 * 
	 * @param direccion
	 * @throws Exception
	 */
	public static void findWhereDireccionEquals(String direccion) throws Exception
	{
		ProveedorDao dao = DaoFactory.createProveedorDao();
		List<Proveedor> _result = dao.findWhereDireccionEquals(direccion);
		for (Proveedor dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'findWhereCpEquals'
	 * 
	 * @param cp
	 * @throws Exception
	 */
	public static void findWhereCpEquals(String cp) throws Exception
	{
		ProveedorDao dao = DaoFactory.createProveedorDao();
		List<Proveedor> _result = dao.findWhereCpEquals(cp);
		for (Proveedor dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'findWhereCiudadEquals'
	 * 
	 * @param ciudad
	 * @throws Exception
	 */
	public static void findWhereCiudadEquals(String ciudad) throws Exception
	{
		ProveedorDao dao = DaoFactory.createProveedorDao();
		List<Proveedor> _result = dao.findWhereCiudadEquals(ciudad);
		for (Proveedor dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'findWhereTelefonoEquals'
	 * 
	 * @param telefono
	 * @throws Exception
	 */
	public static void findWhereTelefonoEquals(String telefono) throws Exception
	{
		ProveedorDao dao = DaoFactory.createProveedorDao();
		List<Proveedor> _result = dao.findWhereTelefonoEquals(telefono);
		for (Proveedor dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'findWhereCelularEquals'
	 * 
	 * @param celular
	 * @throws Exception
	 */
	public static void findWhereCelularEquals(String celular) throws Exception
	{
		ProveedorDao dao = DaoFactory.createProveedorDao();
		List<Proveedor> _result = dao.findWhereCelularEquals(celular);
		for (Proveedor dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'findWhereEmailEquals'
	 * 
	 * @param email
	 * @throws Exception
	 */
	public static void findWhereEmailEquals(String email) throws Exception
	{
		ProveedorDao dao = DaoFactory.createProveedorDao();
		List<Proveedor> _result = dao.findWhereEmailEquals(email);
		for (Proveedor dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'findWhereFechaRegistroEquals'
	 * 
	 * @param fechaRegistro
	 * @throws Exception
	 */
	public static void findWhereFechaRegistroEquals(Date fechaRegistro) throws Exception
	{
		ProveedorDao dao = DaoFactory.createProveedorDao();
		List<Proveedor> _result = dao.findWhereFechaRegistroEquals(fechaRegistro);
		for (Proveedor dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'display'
	 * 
	 * @param dto
	 */
	public static void display(Proveedor dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getId() );
		buf.append( ", " );
		buf.append( dto.getEmpresa() );
		buf.append( ", " );
		buf.append( dto.getRfc() );
		buf.append( ", " );
		buf.append( dto.getDireccion() );
		buf.append( ", " );
		buf.append( dto.getCp() );
		buf.append( ", " );
		buf.append( dto.getCiudad() );
		buf.append( ", " );
		buf.append( dto.getTelefono() );
		buf.append( ", " );
		buf.append( dto.getCelular() );
		buf.append( ", " );
		buf.append( dto.getEmail() );
		buf.append( ", " );
		buf.append( dto.getFechaRegistro() );
		System.out.println( buf.toString() );
	}

}
