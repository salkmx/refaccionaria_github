package com.amickom.autopartdao.example;

import java.math.*;
import java.util.Date;
import java.util.List;
import com.amickom.autopartdao.dao.ClienteDao;
import com.amickom.autopartdao.dto.Cliente;
import com.amickom.autopartdao.exceptions.ClienteDaoException;
import com.amickom.autopartdao.factory.DaoFactory;

public class ClienteDaoExample
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
		// findWhereNombreEquals("");
		// findWhereRfcEquals("");
		// findWhereDireccionEquals("");
		// findWhereTelefonoEquals("");
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
		ClienteDao dao = DaoFactory.createClienteDao();
		List<Cliente> _result = dao.findAll();
		for (Cliente dto : _result) {
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
		ClienteDao dao = DaoFactory.createClienteDao();
		List<Cliente> _result = dao.findWhereIdEquals(id);
		for (Cliente dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'findWhereNombreEquals'
	 * 
	 * @param nombre
	 * @throws Exception
	 */
	public static void findWhereNombreEquals(String nombre) throws Exception
	{
		ClienteDao dao = DaoFactory.createClienteDao();
		List<Cliente> _result = dao.findWhereNombreEquals(nombre);
		for (Cliente dto : _result) {
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
		ClienteDao dao = DaoFactory.createClienteDao();
		List<Cliente> _result = dao.findWhereRfcEquals(rfc);
		for (Cliente dto : _result) {
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
		ClienteDao dao = DaoFactory.createClienteDao();
		List<Cliente> _result = dao.findWhereDireccionEquals(direccion);
		for (Cliente dto : _result) {
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
		ClienteDao dao = DaoFactory.createClienteDao();
		List<Cliente> _result = dao.findWhereTelefonoEquals(telefono);
		for (Cliente dto : _result) {
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
		ClienteDao dao = DaoFactory.createClienteDao();
		List<Cliente> _result = dao.findWhereEmailEquals(email);
		for (Cliente dto : _result) {
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
		ClienteDao dao = DaoFactory.createClienteDao();
		List<Cliente> _result = dao.findWhereFechaRegistroEquals(fechaRegistro);
		for (Cliente dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'display'
	 * 
	 * @param dto
	 */
	public static void display(Cliente dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getId() );
		buf.append( ", " );
		buf.append( dto.getNombre() );
		buf.append( ", " );
		buf.append( dto.getRfc() );
		buf.append( ", " );
		buf.append( dto.getDireccion() );
		buf.append( ", " );
		buf.append( dto.getTelefono() );
		buf.append( ", " );
		buf.append( dto.getEmail() );
		buf.append( ", " );
		buf.append( dto.getFechaRegistro() );
		System.out.println( buf.toString() );
	}

}
