package com.amickom.autopartdao.exceptions;

public class ProductosDaoException extends DaoException
{
	/**
	 * Method 'ProductosDaoException'
	 * 
	 * @param message
	 */
	public ProductosDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'ProductosDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public ProductosDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
