/**
 * EmailMessage.java
 * com.ixe.pcb.mail
 */
package com.amickom.service.mail;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;

import javax.mail.MessagingException;

/**
 * @author NA-AT Consulting
 *	Proyecto: Perfil de Cliente en Banco
 *  ID: 066
 * 
 */
public interface EmailMessage {
	
	/**
	 * 
	 * M�todo : addAttachment 
	 * @param filename -
	 * @throws MessagingException -
	 */
	public void addAttachment(String filename) throws MessagingException;
	
	/**
	 * 
	 * M�todo : addAttachment 
	 * @param filename filename
	 * @param file file
	 * @throws MessagingException MessagingException
	 */
	public void addAttachment(String filename, File file) throws MessagingException;
	
	
	/**
	 * 
	 * M�todo : getBodyWriter 
	 * @return PrintWriter
	 */
	public PrintWriter getBodyWriter();
	
	/**
	 * 
	 * M�todo : send 
	 * @throws MessagingException MessagingException
	 */
	public void send() throws MessagingException;
	
	/**
	 * 
	 * M�todo : send 
	 * @throws MessagingException MessagingException
	 */
	public void sendProcesos() throws MessagingException;
	
	
	/**
	 * 
	 * M�todo : setBccRecipients 
	 * @param recipients recipients
	 * @throws MessagingException MessagingException
	 */
	public void setBccRecipients(String recipients) throws MessagingException;
	
	
	/**
	 * 
	 * M�todo : setBody 
	 * @param body body
	 * @throws MessagingException MessagingException
	 */
	public void setBody(String body) throws MessagingException;
	
	
	/**
	 * 
	 * M�todo : setCcRecipients 
	 * @param recipients recipients
	 * @throws MessagingException MessagingException
	 */
	public void setCcRecipients(String recipients) throws MessagingException;
	
	
	/**
	 * 
	 * M�todo : setFrom 
	 * @param from from
	 * @throws MessagingException MessagingException
	 */
	public void setFrom(String from) throws MessagingException;
	
	
	/**
	 * 
	 * M�todo : setRecipients 
	 * @param recipients recipients
	 * @throws MessagingException MessagingException
	 */
	public void setRecipients(String[] recipients) throws MessagingException;
	
	
	/**
	 * 
	 * M�todo : setSentDate 
	 * @param sentDate sentDate
	 * @throws MessagingException MessagingException
	 */
	public void setSentDate(Date sentDate) throws MessagingException;
	

	/**
	 * 
	 * M�todo : setSubject
	 * 
	 * @param subject subject
	 * @throws MessagingException MessagingException
	 */
	public void setSubject(String subject) throws MessagingException;
	
	/**
	 * 
	 * M�todo : setToRecipients 
	 * @param recipients crecipients
	 * @throws MessagingException MessagingException
	 */
	public void setToRecipients(String recipients) throws MessagingException;

}
