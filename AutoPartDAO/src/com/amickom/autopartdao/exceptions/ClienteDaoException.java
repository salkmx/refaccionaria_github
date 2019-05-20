package com.amickom.autopartdao.exceptions;

public class ClienteDaoException extends DaoException
{
	/**
	 * Method 'ClienteDaoException'
	 * 
	 * @param message
	 */
	public ClienteDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'ClienteDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public ClienteDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
