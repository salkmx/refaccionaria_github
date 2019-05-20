/**
 * MailerException.java
 * com.ixe.pcb.mail
 */
package com.amickom.service.exception;
import com.amickom.service.mail.*;


/**
 * @author NA-AT Consulting
 *	Proyecto: Perfil de Cliente en Banco
 *  ID: 066
 * 
 */
public class MailerException extends Exception {

	/**
	 * variable para implementar 
	 * la interfaz Serializable
	 */
	 private static final long serialVersionUID = 101710703L;
	 /**
	  * Mensaje de la excepcion
	  */
	 private String message;
	 
	 /**
	  *Constructor 
	  *@param ex - objteto tipo
	  *Exception
	  */
	  public MailerException(Exception ex) {
	    setStackTrace(ex.getStackTrace());
	    this.message = ex.getMessage();
	  }
	  /**
	   * @return String - el mensaje
	   * de la excepcion
	   */
	  public String getMessage() {
	    return this.message;
	  }
	
}
