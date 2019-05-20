package com.amickom.autopartdao.example;

import java.math.*;
import java.util.Date;
import java.util.List;
import com.amickom.autopartdao.dao.PedidoDao;
import com.amickom.autopartdao.dto.Pedido;
import com.amickom.autopartdao.exceptions.PedidoDaoException;
import com.amickom.autopartdao.factory.DaoFactory;

public class PedidoDaoExample
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
		// findByCliente(null);
		// findWhereIdEquals(null);
		// findWhereIdClienteEquals(null);
		// findWhereFechaAltaEquals(null);
		// findWherePrecioEquals(null);
		// findWhereIvaEquals(null);
		// findWhereIdUsuarioEquals(null);
	}

	/**
	 * Method 'findAll'
	 * 
	 * @throws Exception
	 */
	public static void findAll() throws Exception
	{
		PedidoDao dao = DaoFactory.createPedidoDao();
		List<Pedido> _result = dao.findAll();
		for (Pedido dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'findByCliente'
	 * 
	 * @param id
	 * @throws Exception
	 */
	public static void findByCliente(Integer id) throws Exception
	{
		PedidoDao dao = DaoFactory.createPedidoDao();
		List<Pedido> _result = dao.findByCliente(id);
		for (Pedido dto : _result) {
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
		PedidoDao dao = DaoFactory.createPedidoDao();
		List<Pedido> _result = dao.findWhereIdEquals(id);
		for (Pedido dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'findWhereIdClienteEquals'
	 * 
	 * @param idCliente
	 * @throws Exception
	 */
	public static void findWhereIdClienteEquals(Integer idCliente) throws Exception
	{
		PedidoDao dao = DaoFactory.createPedidoDao();
		List<Pedido> _result = dao.findWhereIdClienteEquals(idCliente);
		for (Pedido dto : _result) {
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
		PedidoDao dao = DaoFactory.createPedidoDao();
		List<Pedido> _result = dao.findWhereFechaAltaEquals(fechaAlta);
		for (Pedido dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'findWherePrecioEquals'
	 * 
	 * @param precio
	 * @throws Exception
	 */
	public static void findWherePrecioEquals(Double precio) throws Exception
	{
		PedidoDao dao = DaoFactory.createPedidoDao();
		List<Pedido> _result = dao.findWherePrecioEquals(precio);
		for (Pedido dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'findWhereIvaEquals'
	 * 
	 * @param iva
	 * @throws Exception
	 */
	public static void findWhereIvaEquals(Double iva) throws Exception
	{
		PedidoDao dao = DaoFactory.createPedidoDao();
		List<Pedido> _result = dao.findWhereIvaEquals(iva);
		for (Pedido dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'findWhereIdUsuarioEquals'
	 * 
	 * @param idUsuario
	 * @throws Exception
	 */
	public static void findWhereIdUsuarioEquals(Integer idUsuario) throws Exception
	{
		PedidoDao dao = DaoFactory.createPedidoDao();
		List<Pedido> _result = dao.findWhereIdUsuarioEquals(idUsuario);
		for (Pedido dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'display'
	 * 
	 * @param dto
	 */
	public static void display(Pedido dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getId() );
		buf.append( ", " );
		buf.append( dto.getIdCliente() );
		buf.append( ", " );
		buf.append( dto.getFechaAlta() );
		buf.append( ", " );
		buf.append( dto.getPrecio() );
		buf.append( ", " );
		buf.append( dto.getIva() );
		buf.append( ", " );
		buf.append( dto.getIdUsuario() );
		System.out.println( buf.toString() );
	}

}
