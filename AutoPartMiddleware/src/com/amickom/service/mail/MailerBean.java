/**
 * MailerBean.java
 * com.ixe.pcb.mail
 */
package com.amickom.service.mail;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author NA-AT Consulting Proyecto: Perfil de Cliente en Banco ID: 066
 * 
 */
public class MailerBean implements Serializable {
	
	 /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private String auth;

	/**
	 * recTO
	 */
	private ArrayList recTO;
	 
	 /**
	 * recCC
	 */
	private ArrayList recCC;
	 
	 /**
	 * recBCC
	 */
	private ArrayList recBCC;
	
	/**
	 * 
	 */
	private String smtp;
	
	/**
	 * 
	 */
	private String puerto;
	
	/**
	 * 
	 */
	private String from;
	 

    /**
         * -
         */
    public static final Integer ENVIO_PROCESO_MONITOREO_PCB =
	    new Integer(1);

    /**
         * -
         */
    public static final String[] TITULO_MAIL =
	    { "Solicitud de información a proveedor ", "" };

    /**
         * Es el tipo de mail
         */
    private Integer tipoMail;

    /**
         * Contiene el asunto del correo
         */
    private String asunto =
	    "";

    /**
         * StringWriter para el encabezado del mail
         */
    private StringBuffer header;

    /**
         * Esta variable contendra el codigo html que se desea mostrar en el
         * cuerpo del mensaje. Ejemplo. str.write("<TABLE width=\"760\"
         * align=\"center\" cellspacing=\"1\" cellpadding=\"3\" border=\"0\">");
         * str.write("
         * <TR>"); str.write("
         * <TD align=\"center\">"+ mContenido+"</TD>
         * "); str.write("</TR>
         * "); str.write("</TABLE>");
         */
    private StringBuilder body;

    /**
         * Contiene el codigo html que se colocara al pie de pagina del mensaje
         */
    private StringBuffer footer;

    /**
         * Contiene el estilo css que se aplicara al html del mail
         */
    private StringBuffer cssStyle;
    
    /**
     * Constructor
     */
    public MailerBean() {
	
    }
    /**
         * @return the asunto- El asunto del correo enviado
         */
    public String getAsunto() {
	return asunto;
    }

    /**
         * @param asunto
         * the asunto to set               
         */
    public void setAsunto(String asunto) {
	this.asunto =
		asunto;
    }

    /**
         * @return the tipoMail
         */
    public Integer getTipoMail() {
	return tipoMail;
    }

    /**
         * @param tipoMail
         *                the tipoMail to set
         */
    public void setTipoMail(Integer tipoMail) {
	this.tipoMail =
		tipoMail;
    }

    /**
         * @return the rutaHeader
         */
    public StringBuffer getHeader() {
	return header;
    }

    /**
         * @param rutaHeader
         *                the rutaHeader to set
         */
    public void setHeader(StringBuffer rutaHeader) {
	this.header =
		rutaHeader;
    }

    /**
         * @return the body
         */
    public StringBuilder getBody() {
	return body;
    }

    /**
         * @param body
         *                the body to set
         */
    public void setBody(StringBuilder body) {
	this.body =
		body;
    }

    /**
         * 
         * @return the footer
         */
    public StringBuffer getFooter() {
	return footer;
    }

    /**
         * 
         * @param footer
         *                the footer to set
         */
    public void setFooter(StringBuffer footer) {
	this.footer =
		footer;
    }

    /**
         * 
         * @return cssStyle - Estilo css que se aplicara al mail
         */
    public StringBuffer getCssStyle() {
	return cssStyle;
    }

    /**
     * 
     * @param cssStyle - stilo css que
     * se aplicara al mail
     */
    public void setCssStyle(StringBuffer cssStyle) {
	this.cssStyle =
		cssStyle;
    }
	/**
	 * @return the recBCC
	 */
	public ArrayList getRecBCC() {
		return recBCC;
	}
	/**
	 * @param recBCC the recBCC to set
	 */
	public void setRecBCC(ArrayList recBCC) {
		this.recBCC = recBCC;
	}
	/**
	 * @return the recCC
	 */
	public ArrayList getRecCC() {
		return recCC;
	}
	/**
	 * @param recCC the recCC to set
	 */
	public void setRecCC(ArrayList recCC) {
		this.recCC = recCC;
	}
	/**
	 * @return the recTO
	 */
	public ArrayList getRecTO() {
		return recTO;
	}
	/**
	 * @param recTO the recTO to set
	 */
	public void setRecTO(ArrayList recTO) {
		this.recTO = recTO;
	}
	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}
	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	/**
	 * @return the puerto
	 */
	public String getPuerto() {
		return puerto;
	}
	/**
	 * @param puerto the puerto to set
	 */
	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}
	/**
	 * @return the smtp
	 */
	public String getSmtp() {
		return smtp;
	}
	/**
	 * @param smtp the smtp to set
	 */
	public void setSmtp(String smtp) {
		this.smtp = smtp;
	}
	/**
	 * @return the auth
	 */
	public String getAuth() {
		return auth;
	}
	/**
	 * @param auth the auth to set
	 */
	public void setAuth(String auth) {
		this.auth = auth;
	}

}
