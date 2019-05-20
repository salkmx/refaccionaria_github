package com.amickom.autopartdao.exceptions;

public class ArchivosDaoException extends DaoException
{
	/**
	 * Method 'ArchivosDaoException'
	 * 
	 * @param message
	 */
	public ArchivosDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'ArchivosDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public ArchivosDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
