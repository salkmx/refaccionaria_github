package com.amickom.autopartdao.exceptions;

public class PedidoProductoDaoException extends DaoException
{
	/**
	 * Method 'PedidoProductoDaoException'
	 * 
	 * @param message
	 */
	public PedidoProductoDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'PedidoProductoDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public PedidoProductoDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
