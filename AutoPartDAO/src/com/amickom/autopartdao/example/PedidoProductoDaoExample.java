package com.amickom.autopartdao.example;

import java.math.*;
import java.util.Date;
import java.util.List;
import com.amickom.autopartdao.dao.PedidoProductoDao;
import com.amickom.autopartdao.dto.PedidoProducto;
import com.amickom.autopartdao.exceptions.PedidoProductoDaoException;
import com.amickom.autopartdao.factory.DaoFactory;

public class PedidoProductoDaoExample
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
		// findByPedido(null);
		// findByProductos(null);
		// findWhereIdPedidoEquals(null);
		// findWhereIdProductoEquals(null);
	}

	/**
	 * Method 'findAll'
	 * 
	 * @throws Exception
	 */
	public static void findAll() throws Exception
	{
		PedidoProductoDao dao = DaoFactory.createPedidoProductoDao();
		List<PedidoProducto> _result = dao.findAll();
		for (PedidoProducto dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'findByPedido'
	 * 
	 * @param idPedido
	 * @throws Exception
	 */
	public static void findByPedido(Integer idPedido) throws Exception
	{
		PedidoProductoDao dao = DaoFactory.createPedidoProductoDao();
		List<PedidoProducto> _result = dao.findByPedido(idPedido);
		for (PedidoProducto dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'findByProductos'
	 * 
	 * @param idProducto
	 * @throws Exception
	 */
	public static void findByProductos(Integer idProducto) throws Exception
	{
		PedidoProductoDao dao = DaoFactory.createPedidoProductoDao();
		List<PedidoProducto> _result = dao.findByProductos(idProducto);
		for (PedidoProducto dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'findWhereIdPedidoEquals'
	 * 
	 * @param idPedido
	 * @throws Exception
	 */
	public static void findWhereIdPedidoEquals(Integer idPedido) throws Exception
	{
		PedidoProductoDao dao = DaoFactory.createPedidoProductoDao();
		List<PedidoProducto> _result = dao.findWhereIdPedidoEquals(idPedido);
		for (PedidoProducto dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'findWhereIdProductoEquals'
	 * 
	 * @param idProducto
	 * @throws Exception
	 */
	public static void findWhereIdProductoEquals(Integer idProducto) throws Exception
	{
		PedidoProductoDao dao = DaoFactory.createPedidoProductoDao();
		List<PedidoProducto> _result = dao.findWhereIdProductoEquals(idProducto);
		for (PedidoProducto dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'display'
	 * 
	 * @param dto
	 */
	public static void display(PedidoProducto dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getIdPedido() );
		buf.append( ", " );
		buf.append( dto.getIdProducto() );
		System.out.println( buf.toString() );
	}

}
