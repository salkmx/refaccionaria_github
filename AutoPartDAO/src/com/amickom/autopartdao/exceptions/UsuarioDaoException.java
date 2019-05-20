package com.amickom.autopartdao.exceptions;

public class UsuarioDaoException extends DaoException
{
	/**
	 * Method 'UsuarioDaoException'
	 * 
	 * @param message
	 */
	public UsuarioDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'UsuarioDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public UsuarioDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
