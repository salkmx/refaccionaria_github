/**
 * EmailMessageImpl.java
 * com.ixe.pcb.mail
 */
package com.amickom.service.mail;

import com.amickom.service.exception.RefaccionariaException;
import com.amickom.service.util.Utils;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

import java.util.logging.Level;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * @author NA-AT Consulting
 *	Proyecto: Perfil de Cliente en Banco
 *  ID: 066
 * 
 */
public class EmailMessageImpl implements EmailMessage {

    /**
     * archivo de propiedades usado
     * por esta clase
     */
    public static final String MAIL_PROPERTIES = "mail.properties";
    /**
     * attachments del mail
     */
    private ArrayList attachments = new ArrayList();
    /**
     * cuerpo del mail
     */
    private StringWriter bodyWriter;
    /**
     * variable para el log
     */
    private static Logger log = Logger.getLogger(EmailMessageImpl.class);
    /**
     * Mensage
     */
    private Message msg;
    /**
     * SMTPHOST
     */
    public static final String SMTPHOST = "mail.smtp.host";
    /**
     * SMTPHOST
     */
    public static final String SMTPAUTH = "mail.smtp.auth";

    /**
     * @throws MessagingException MessagingException
     * @throws SipareMailException SipareMailException
     */
    public EmailMessageImpl() throws MessagingException, RefaccionariaException {
        Properties props = Utils.cargaPropiedadesClass(MAIL_PROPERTIES);
        Properties transportProperties = new Properties();
        transportProperties.put(SMTPHOST, props.getProperty(SMTPHOST));
        transportProperties.put(SMTPAUTH, props.getProperty(SMTPAUTH));
        transportProperties.put("mail.smtp.starttls.enable", props.getProperty("mail.smtp.starttls.enable"));
        transportProperties.put("mail.smtp.port", props.getProperty("mail.smtp.port"));
        Autentificacion auth = new Autentificacion();
        Session session = Session.getInstance(transportProperties, auth);
        session.setDebug(log.isDebugEnabled());
        msg = new MimeMessage(session);
    }

    /**
     * @throws MessagingException MessagingException
     * @throws SipareMailException SipareMailException
     */
    public EmailMessageImpl(String smtp, String auth1)
            throws MessagingException, RefaccionariaException {
//        Properties 
//		 props = CargarPropiedades.getInstance().getProperties(MAIL_PROPERTIES);
//         
        Properties transportProperties = new Properties();
        transportProperties.put(SMTPHOST, smtp);
        transportProperties.put(SMTPAUTH, auth1);

        Authenticator auth = new Autentificacion("alertas",
                "alertas");
        Session session = Session.getInstance(transportProperties, auth);
        session.setDebug(log.isDebugEnabled());
        msg = new MimeMessage(session);
        msg.setSentDate(new Date());
        //props = CargarPropiedades.getInstance().getProperties(Constantes.PROPERTIES_MAIL);

    }

    /**
     * @author David Omar S�nchez Rodr�guez
     * Na-at Consulting S.C.
     * 23/07/2009
     * EmailMessageImpl.java
     */
    static class Autentificacion extends Authenticator {

        /**
         * password
         */
        private String password;
        /**
         * user
         */
        private String userName;

        {
            try {
                Properties props =
                        Utils.cargaPropiedadesClass(MAIL_PROPERTIES);
                this.password = props.getProperty("pass");
                this.userName = props.getProperty("usuario");
            } catch (RefaccionariaException ex) {
                java.util.logging.Logger.getLogger(EmailMessageImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public Autentificacion() throws RefaccionariaException {
            super();
        }

        public Autentificacion(String user, String pass) throws RefaccionariaException {
            super();
            this.userName = user;
            this.password = pass;
        }
        /**
         * passwordAuthentication
         */
        private PasswordAuthentication passwordAuthentication = new PasswordAuthentication(
                userName, password);

        /**
         * 
         * M�todo : getPasswordAuthentication 
         * @return PasswordAuthentication
         */
        protected PasswordAuthentication getPasswordAuthentication() {
            return passwordAuthentication;
        }
    }

    /**
     * @param filename filename
     * @throws MessagingException MessagingException
     */
    public void addAttachment(String filename) throws MessagingException {
        File file = new File(filename);
        addAttachment(file.getName(), file);
    }

    /**
     * @param filename filename
     * @param file file
     * @throws MessagingException MessagingException
     */
    public void addAttachment(String filename, File file)
            throws MessagingException {
        MimeBodyPart part = new MimeBodyPart();
        FileDataSource fds = new FileDataSource(file);
        part.setDataHandler(new DataHandler(fds));
        part.setFileName(filename);
        attachments.add(part);

    }

    /**
     * @return PrintWriter
     */
    public PrintWriter getBodyWriter() {
        bodyWriter = new StringWriter();
        return new PrintWriter(bodyWriter);
    }

    /**
     * @throws MessagingException MessagingException
     */
    public void send() throws MessagingException {

        Multipart parts = new MimeMultipart("related");
        if (bodyWriter == null) {
            setBody("");
        }
        BodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(bodyWriter.toString(), "text/html; charset=utf-8");


        parts.addBodyPart(bodyPart);



        Iterator iter = attachments.iterator();
        while (iter.hasNext()) {
            parts.addBodyPart((MimeBodyPart) iter.next());
        }
        msg.setContent(parts);
        try {
            Transport.send(msg);
        } catch (SendFailedException sfe) {
            sfe.printStackTrace();
            log.error("Error en el envio del mail." + sfe.getMessage());
        }

    }

    /**
     * @throws MessagingException MessagingException
     */
    public void sendProcesos() throws MessagingException {

        Multipart parts = new MimeMultipart("related");
        if (bodyWriter == null) {
            setBody("");
        }
        BodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(bodyWriter.toString(), "text/html; charset=utf-8");


        parts.addBodyPart(bodyPart);



        Iterator iter = attachments.iterator();
        while (iter.hasNext()) {
            parts.addBodyPart((MimeBodyPart) iter.next());
        }
        msg.setContent(parts);
        try {
            Transport.send(msg);
        } catch (SendFailedException sfe) {
            log.error("Error en el envio del mail." + sfe.getMessage());
        }

    }

    /**
     * @param recipients recipients
     * @throws MessagingException MessagingException
     */
    public void setBccRecipients(String recipients) throws MessagingException {
        if (StringUtils.isNotEmpty(recipients)) {
            setRecipients(Message.RecipientType.BCC, recipients);
        }
    }

    /**
     * @param body body 
     * @throws MessagingException MessagingException
     */
    public void setBody(String body) throws MessagingException {
        bodyWriter = new StringWriter();
        bodyWriter.write(body);

    }

    /**
     * @param recipients recipients
     * @throws MessagingException MessagingException
     */
    public void setCcRecipients(String recipients) throws MessagingException {
        if (StringUtils.isNotEmpty(recipients)) {
            setRecipients(Message.RecipientType.CC, recipients);
        }

    }

    /**
     * @param from from
     * @throws MessagingException MessagingException
     */
    public void setFrom(String from) throws MessagingException {
        msg.setFrom(new InternetAddress(from));

    }

    /**
     * @param recipientType recipientType
     * @param recipients recipients
     * @throws MessagingException MessagingException
     */
    private void setRecipients(Message.RecipientType recipientType,
            String recipients) throws MessagingException {
        if (recipients.length() > 0) {
            InternetAddress[] addresses = new InternetAddress[0];
            addresses = InternetAddress.parse(recipients, true);
            // for ( int i = 0; i < recipients.length; i++ ){
            // addresses[ i ] = new InternetAddress( recipients[ i ]);
            // }
            msg.setRecipients(recipientType, addresses);
        }
    }

    /**
     * @param recipients recipients
     * @throws MessagingException MessagingException
     */
    public void setRecipients(String[] recipients) throws MessagingException {
        InternetAddress[] addresses = new InternetAddress[recipients.length];
        for (int i = 0; i < recipients.length; i++) {
            addresses[i] = new InternetAddress(recipients[i]);
        }
        msg.setRecipients(Message.RecipientType.TO, addresses);

    }

    /**
     * @param sentDate sentDate
     * @throws MessagingException MessagingException
     */
    public void setSentDate(Date sentDate) throws MessagingException {
        msg.setSentDate(sentDate);

    }

    /**
     * @param subject subject
     * @throws MessagingException MessagingException
     */
    public void setSubject(String subject) throws MessagingException {
        msg.setSubject(subject);

    }

    /**
     * @param recipients recipients
     * @throws MessagingException MessagingException
     */
    public void setToRecipients(String recipients) throws MessagingException {
        if (StringUtils.isNotEmpty(recipients)) {
            setRecipients(Message.RecipientType.TO, recipients);
        }

    }
}
