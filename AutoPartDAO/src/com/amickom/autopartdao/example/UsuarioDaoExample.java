package com.amickom.autopartdao.example;

import java.math.*;
import java.util.Date;
import java.util.List;
import com.amickom.autopartdao.dao.UsuarioDao;
import com.amickom.autopartdao.dto.Usuario;
import com.amickom.autopartdao.exceptions.UsuarioDaoException;
import com.amickom.autopartdao.factory.DaoFactory;

public class UsuarioDaoExample
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
		// findWhereClaveEquals("");
		// findWherePasswordEquals("");
		// findWhereFechaAltaEquals(null);
		// findWhereRolEquals("");
	}

	/**
	 * Method 'findAll'
	 * 
	 * @throws Exception
	 */
	public static void findAll() throws Exception
	{
		UsuarioDao dao = DaoFactory.createUsuarioDao();
		List<Usuario> _result = dao.findAll();
		for (Usuario dto : _result) {
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
		UsuarioDao dao = DaoFactory.createUsuarioDao();
		List<Usuario> _result = dao.findWhereIdEquals(id);
		for (Usuario dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'findWhereClaveEquals'
	 * 
	 * @param clave
	 * @throws Exception
	 */
	public static void findWhereClaveEquals(String clave) throws Exception
	{
		UsuarioDao dao = DaoFactory.createUsuarioDao();
		List<Usuario> _result = dao.findWhereClaveEquals(clave);
		for (Usuario dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'findWherePasswordEquals'
	 * 
	 * @param password
	 * @throws Exception
	 */
	public static void findWherePasswordEquals(String password) throws Exception
	{
		UsuarioDao dao = DaoFactory.createUsuarioDao();
		List<Usuario> _result = dao.findWherePasswordEquals(password);
		for (Usuario dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'findWhereFechaAltaEquals'
	 * 
	 * @param fechaAlta
	 * @throws Exception
	 */
	public static void findWhereFechaAltaEquals(Date fechaAlta) throws Exception
	{
		UsuarioDao dao = DaoFactory.createUsuarioDao();
		List<Usuario> _result = dao.findWhereFechaAltaEquals(fechaAlta);
		for (Usuario dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'findWhereRolEquals'
	 * 
	 * @param rol
	 * @throws Exception
	 */
	public static void findWhereRolEquals(String rol) throws Exception
	{
		UsuarioDao dao = DaoFactory.createUsuarioDao();
		List<Usuario> _result = dao.findWhereRolEquals(rol);
		for (Usuario dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'display'
	 * 
	 * @param dto
	 */
	public static void display(Usuario dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getId() );
		buf.append( ", " );
		buf.append( dto.getClave() );
		buf.append( ", " );
		buf.append( dto.getPassword() );
		buf.append( ", " );
		buf.append( dto.getFechaAlta() );
		buf.append( ", " );
		buf.append( dto.getRol() );
		System.out.println( buf.toString() );
	}

}
