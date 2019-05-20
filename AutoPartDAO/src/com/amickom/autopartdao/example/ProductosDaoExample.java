package com.amickom.autopartdao.example;

import java.math.*;
import java.util.Date;
import java.util.List;
import com.amickom.autopartdao.dao.ProductosDao;
import com.amickom.autopartdao.dto.Productos;
import com.amickom.autopartdao.exceptions.ProductosDaoException;
import com.amickom.autopartdao.factory.DaoFactory;

public class ProductosDaoExample
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
		// findWhereIdProductoEquals(null);
		// findWhereIdProveedorEquals(null);
		// findWhereCodigoEquals("");
		// findWherePrecioEquals(null);
		// findWhereFechaAltaEquals(null);
		// findWhereMarcaEquals("");
	}

	/**
	 * Method 'findAll'
	 * 
	 * @throws Exception
	 */
	public static void findAll() throws Exception
	{
		ProductosDao dao = DaoFactory.createProductosDao();
		List<Productos> _result = dao.findAll();
		for (Productos dto : _result) {
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
		ProductosDao dao = DaoFactory.createProductosDao();
		List<Productos> _result = dao.findWhereIdProductoEquals(idProducto);
		for (Productos dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'findWhereIdProveedorEquals'
	 * 
	 * @param idProveedor
	 * @throws Exception
	 */
	public static void findWhereIdProveedorEquals(Integer idProveedor) throws Exception
	{
		ProductosDao dao = DaoFactory.createProductosDao();
		List<Productos> _result = dao.findWhereIdProveedorEquals(idProveedor);
		for (Productos dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'findWhereCodigoEquals'
	 * 
	 * @param codigo
	 * @throws Exception
	 */
	public static void findWhereCodigoEquals(String codigo) throws Exception
	{
		ProductosDao dao = DaoFactory.createProductosDao();
		List<Productos> _result = dao.findWhereCodigoEquals(codigo);
		for (Productos dto : _result) {
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
		ProductosDao dao = DaoFactory.createProductosDao();
		List<Productos> _result = dao.findWherePrecioEquals(precio);
		for (Productos dto : _result) {
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
		ProductosDao dao = DaoFactory.createProductosDao();
		List<Productos> _result = dao.findWhereFechaAltaEquals(fechaAlta);
		for (Productos dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'findWhereMarcaEquals'
	 * 
	 * @param marca
	 * @throws Exception
	 */
	public static void findWhereMarcaEquals(String marca) throws Exception
	{
		ProductosDao dao = DaoFactory.createProductosDao();
		List<Productos> _result = dao.findWhereMarcaEquals(marca);
		for (Productos dto : _result) {
			display(dto);
		}
		
	}

	/**
	 * Method 'display'
	 * 
	 * @param dto
	 */
	public static void display(Productos dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getIdProducto() );
		buf.append( ", " );
		buf.append( dto.getIdProveedor() );
		buf.append( ", " );
		buf.append( dto.getCodigo() );
		buf.append( ", " );
		buf.append( dto.getPrecio() );
		buf.append( ", " );
		buf.append( dto.getFechaAlta() );
		buf.append( ", " );
		buf.append( dto.getMarca() );
		System.out.println( buf.toString() );
	}

}
