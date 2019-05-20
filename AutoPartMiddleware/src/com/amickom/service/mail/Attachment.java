/**
 * Attachment.java
 * com.ixe.pcb.mail
 */
package com.amickom.service.mail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author NA-AT Consulting
 *	Proyecto: Perfil de Cliente en Banco
 *  ID: 066
 * 
 */
public class Attachment {
	/**
	 * Flujo de bytes para
	 * el archivo adjunto
	 */
	private byte[] fileBytes;
	
	/**
	 * Nombre del archivo adjunto
	 */
	private String fileName;

	/**	 
	 * @param file - Archivo adjunto
	 * @return Returns el flujo de bytes
	 * del archivo adjunto 
	 */
	private static byte[] getBytesFromFile(File file) {
		InputStream is;
		try {
			is = new FileInputStream(file);
			long length = file.length();

			byte[] bytes = new byte[(int) length];
			int offset = 0;
			int numRead = 0;
			do {
				offset += numRead;
				if (offset >= bytes.length) {	
					break;
				}
			} while ((numRead = is.read(bytes, offset, bytes.length - offset)) >= 0);

			if (offset < bytes.length) {
				throw new IOException("Could not completely read fileBytes " +
						file.getName());
			}

			is.close();

			return bytes;
		}
		catch (IOException ioe) {
			ioe.printStackTrace(System.out);
			return null;
		}
	}

	/**
	 * 
	 * Constructor de la clase: Attachment.java
	 * @param fileName - Nombre del Archivo
	 * @param file - Flujo de bytes del archivo
	 */
	public Attachment(String fileName, byte[] file) {
		this.fileBytes = null;
		this.fileName = "";
		this.fileName = fileName;
		this.fileBytes = file;
	}

	/**
	 * 
	 * Constructor de la clase: Attachment.java
	 * @param fileName - Nombre de archivo adjunto
	 * @param file - Archivo adjunto
	 */
	public Attachment(String fileName, File file) {
		this.fileBytes = null;
		this.fileName = "";
		this.fileName = fileName;
		this.fileBytes = getBytesFromFile(file);
	}

	/**
	 * @return the fileBytes
	 */
	public byte[] getFileBytes() {
		return fileBytes;
	}

	/**
	 * @param fileBytes the fileBytes to set
	 */
	public void setFileBytes(byte[] fileBytes) {
		this.fileBytes = fileBytes;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
