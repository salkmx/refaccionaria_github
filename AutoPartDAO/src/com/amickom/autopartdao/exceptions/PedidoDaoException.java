package com.amickom.autopartdao.exceptions;

public class PedidoDaoException extends DaoException
{
	/**
	 * Method 'PedidoDaoException'
	 * 
	 * @param message
	 */
	public PedidoDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'PedidoDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public PedidoDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
