package com.amickom.autopartdao.factory;

import com.amickom.autopartdao.dao.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.beans.BeansException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

public class DaoFactory
{
	/**
	 * Method 'createClienteDao'
	 * 
	 * @return ClienteDao
	 */
	public static ClienteDao createClienteDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (ClienteDao) bf.getBean( "ClienteDao" );
	}

	/**
	 * Method 'createPedidoDao'
	 * 
	 * @return PedidoDao
	 */
	public static PedidoDao createPedidoDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (PedidoDao) bf.getBean( "PedidoDao" );
	}

	/**
	 * Method 'createPedidoProductoDao'
	 * 
	 * @return PedidoProductoDao
	 */
	public static PedidoProductoDao createPedidoProductoDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (PedidoProductoDao) bf.getBean( "PedidoProductoDao" );
	}

	/**
	 * Method 'createProductosDao'
	 * 
	 * @return ProductosDao
	 */
	public static ProductosDao createProductosDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (ProductosDao) bf.getBean( "ProductosDao" );
	}

	/**
	 * Method 'createProveedorDao'
	 * 
	 * @return ProveedorDao
	 */
	public static ProveedorDao createProveedorDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (ProveedorDao) bf.getBean( "ProveedorDao" );
	}

	/**
	 * Method 'createUsuarioDao'
	 * 
	 * @return UsuarioDao
	 */
	public static UsuarioDao createUsuarioDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (UsuarioDao) bf.getBean( "UsuarioDao" );
	}

}
