package com.amickom.autopartdao.exceptions;

public class ExcelDAOException extends DaoException
{
	/**
	 * Method 'ClienteDaoException'
	 * 
	 * @param message
	 */
	public ExcelDAOException(String message)
	{
		super(message);
	}

	/**
	 * Method 'ClienteDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public ExcelDAOException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
