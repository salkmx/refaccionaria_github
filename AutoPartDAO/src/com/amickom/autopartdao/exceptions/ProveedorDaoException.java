package com.amickom.autopartdao.exceptions;

public class ProveedorDaoException extends DaoException
{
	/**
	 * Method 'ProveedorDaoException'
	 * 
	 * @param message
	 */
	public ProveedorDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'ProveedorDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public ProveedorDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
