/**
 * Mailer.java
 * com.ixe.pcb.mail
 */
package com.amickom.service.mail;

import com.amickom.service.exception.MailerException;
import com.amickom.service.exception.RefaccionariaException;
import com.amickom.service.util.Utils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.MissingResourceException;
import java.util.Properties;

import javax.mail.MessagingException;

import org.apache.log4j.Logger;

/**
 * @author NA-AT Consulting
 *	Proyecto: Perfil de Cliente en Banco
 *  ID: 066
 * 
 */
public class Mailer {

    public static final String PROPERTIES_MAIL = "mail.properties";
    /**
     * variable para el log
     */
    private static Logger log = Logger.getLogger(Mailer.class);
    /**
     * -
     */
    private ArrayList atts2delete;
    /**
     * -
     */
    private String sysId;
    /**
     * -
     */
    private Properties rb;
    /**
     * DEFAULT
     */
    public static final String DEFAULT = "DEFAULT";
    /**
     * MAILFROM
     */
    public static final String MAILFROM = "mail.from";
    /**
     * COMA
     */
    public static final String COMA = ",";

    /**
     * @throws RefaccionariaException RefaccionariaException
     */
    public Mailer() throws RefaccionariaException {
        try {
            this.sysId = DEFAULT;
            this.atts2delete = new ArrayList(0);
            this.rb =
                    Utils.cargaPropiedadesClass(PROPERTIES_MAIL);


        } catch (MissingResourceException missExc) {
            log.error("No se encuentra el archivo "
                    + "de recursos: mail.properties...", missExc);
            throw missExc;
        }
    }

    /**
     * @throws RefaccionariaException RefaccionariaException
     */
    public Mailer(int batch) throws RefaccionariaException {
        try {
            this.sysId = DEFAULT;
            this.atts2delete = new ArrayList(0);
            log.debug("Iniciando env�o de mail proceso batch");
//            this.rb = 
//                CargarPropiedades.getInstance().getProperties(Constantes.PROPERTIES_MAIL);


        } catch (MissingResourceException missExc) {
            log.error("No se encuentra el archivo "
                    + "de recursos: mail.properties...", missExc);
            throw missExc;
        }
    }

    /**
     * @param sysId sysId
     * @throws RefaccionariaException RefaccionariaException
     */
    public Mailer(String sysId) throws RefaccionariaException {

        try {
            this.sysId = DEFAULT;
            this.atts2delete = new ArrayList(0);
            this.rb =
                    Utils.cargaPropiedadesClass(PROPERTIES_MAIL);
            this.sysId = sysId;
        } catch (MissingResourceException missExc) {
            log.error("No se encuentra el archivo de recursos: mail.properties...", missExc);
            throw missExc;
        }
    }

    /**
     * 
     * M�todo : enviaMensaje -
     * @param mgb mgb
     * @param recTO recTO
     * @param recCC recCC
     * @param recBCC recBCC
     * @param attachments attachments
     * @return boolean boolean
     * @throws MailerException MailerException
     */
    public boolean enviaMensaje(MailerBean mgb, ArrayList recTO,
            ArrayList recCC, ArrayList recBCC, ArrayList attachments)
            throws MailerException {
        Attachment att = null;
        File attFile = null;
        try {
            if (recTO == null) {
                recTO = new ArrayList(0);
            }
            if (recCC == null) {
                recCC = new ArrayList(0);
            }
            if (recBCC == null) {
                recBCC = new ArrayList(0);
            }
            if (attachments == null) {
                attachments = new ArrayList(0);
            }
            EmailMessage email = new EmailMessageImpl();
            email.setFrom(this.rb.getProperty(MAILFROM).trim());

            email.setSubject(mgb.getAsunto());

            String recipients = "";
            Iterator iter = recTO.iterator();
            int i = 1;
            while (iter.hasNext()) {
                recipients += (String) iter.next();
                if (i < recTO.size()) {
                    recipients += COMA;
                }
                i++;
            }
            email.setToRecipients(recipients);
            recipients = "";
            iter = recCC.iterator();
            i = 1;
            while (iter.hasNext()) {
                recipients += (String) iter.next();
                if (i < recCC.size()) {
                    recipients += COMA;
                }
                i++;
            }
            email.setCcRecipients(recipients);
            recipients = "";
            iter = recBCC.iterator();
            i = 1;
            while (iter.hasNext()) {
                recipients += (String) iter.next();
                if (i < recBCC.size()) {
                    recipients += COMA;
                }
                i++;
            }
            email.setBccRecipients(recipients);

            String body = this.replaceTags(this.getTemplateContent(mgb), mgb);
            log.info(body);
            email.setBody(body);

            iter = attachments.iterator();


            while (iter.hasNext()) {

                att = (Attachment) iter.next();
                if (att.getFileName() == null) {
                    throw new RefaccionariaException("El an"
                            + "exo " + i + " tiene el nombre nulo");
                }
                if (att.getFileBytes() == null) {
                    throw new RefaccionariaException("El anexo " + i + " tiene el "
                            + "archivo nulo");
                }

                byte[] byteArray = att.getFileBytes();


                String tempdir = System.getProperty("java.io.tmpdir");
                if (!(tempdir.endsWith(File.separator))) {
                    tempdir = tempdir + File.separator;
                }
                String tempdir2 = tempdir + this.sysId + new Date().getTime();
                File tempFile = new File(tempdir2);
                tempFile.mkdir();
                tempFile = new File(tempFile.getAbsolutePath()
                        + File.separator + att.getFileName());
                ByteArrayInputStream ba = new ByteArrayInputStream(byteArray);
                FileOutputStream fos = new FileOutputStream(tempFile);
                fos.write(byteArray, 0, byteArray.length);
                fos.close();
                ba.close();
                email.addAttachment(tempFile.getName(), tempFile);
                this.atts2delete.add(tempFile);
            }

            email.send();

            Iterator atts = this.atts2delete.iterator();
            while (atts.hasNext()) {
                attFile = (File) atts.next();
                attFile.delete();
            }



            return true;
        } catch (IOException e) {
            log.error("Excepcion al "
                    + "enviar correo: ", e);
            throw new MailerException(e);

        } catch (MessagingException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            log.error("Excepcion al e"
                    + "nviar correo: ", e);
            throw new MailerException(e);

        } catch (RefaccionariaException e) {
            log.error("Excepcion al enviar correo: ", e);
            throw new MailerException(e);

        }

    }

    /**
     * 
     * M�todo : enviaMensaje -
     * @param mgb mgb
     * @param recTO recTO
     * @param recCC recCC
     * @param recBCC recBCC
     * @param attachments attachments
     * @return boolean boolean
     * @throws MailerException MailerException
     */
    public boolean enviaMensajeProcesos(MailerBean mgb, ArrayList recTO,
            ArrayList recCC, ArrayList recBCC, ArrayList attachments)
            throws MailerException {
        Attachment att = null;
        File attFile = null;
        try {
            if (recTO == null) {
                recTO = new ArrayList(0);
            }
            if (recCC == null) {
                recCC = new ArrayList(0);
            }
            if (recBCC == null) {
                recBCC = new ArrayList(0);
            }
            if (attachments == null) {
                attachments = new ArrayList(0);
            }
            EmailMessage email = new EmailMessageImpl(mgb.getSmtp(),
                    mgb.getAuth());
            email.setFrom(mgb.getFrom());

            email.setSubject(mgb.getAsunto());

            String recipients = "";
            Iterator iter = recTO.iterator();
            int i = 1;
            while (iter.hasNext()) {
                recipients += (String) iter.next();
                if (i < recTO.size()) {
                    recipients += COMA;
                }
                i++;
            }
            email.setToRecipients(recipients);
            recipients = "";
            iter = recCC.iterator();
            i = 1;
            while (iter.hasNext()) {
                recipients += (String) iter.next();
                if (i < recCC.size()) {
                    recipients += COMA;
                }
                i++;
            }
            email.setCcRecipients(recipients);
            recipients = "";
            iter = recBCC.iterator();
            i = 1;
            while (iter.hasNext()) {
                recipients += (String) iter.next();
                if (i < recBCC.size()) {
                    recipients += COMA;
                }
                i++;
            }
            email.setBccRecipients(recipients);

            String body = mgb.getBody().toString();
            //log.info(body);
            email.setBody(body);

            iter = attachments.iterator();


            while (iter.hasNext()) {

                att = (Attachment) iter.next();
                if (att.getFileName() == null) {
                    throw new RefaccionariaException("El an"
                            + "exo " + i + " tiene el nombre nulo");
                }
                if (att.getFileBytes() == null) {
                    throw new RefaccionariaException("El anexo " + i + " tiene el "
                            + "archivo nulo");
                }

                byte[] byteArray = att.getFileBytes();


                String tempdir = System.getProperty("java.io.tmpdir");
                if (!(tempdir.endsWith(File.separator))) {
                    tempdir = tempdir + File.separator;
                }
                String tempdir2 = tempdir + this.sysId + new Date().getTime();
                File tempFile = new File(tempdir2);
                tempFile.mkdir();
                tempFile = new File(tempFile.getAbsolutePath()
                        + File.separator + att.getFileName());
                ByteArrayInputStream ba = new ByteArrayInputStream(byteArray);
                FileOutputStream fos = new FileOutputStream(tempFile);
                fos.write(byteArray, 0, byteArray.length);
                fos.close();
                ba.close();
                email.addAttachment(tempFile.getName(), tempFile);
                this.atts2delete.add(tempFile);
            }

            email.send();

            Iterator atts = this.atts2delete.iterator();
            while (atts.hasNext()) {
                attFile = (File) atts.next();
                attFile.delete();
            }



            return true;
        } catch (IOException e) {
            log.error("Excepcion al "
                    + "enviar correo: ", e);
            throw new MailerException(e);

        } catch (MessagingException e) {
            log.error("Excepcion al e"
                    + "nviar correo: ", e);
            throw new MailerException(e);

        } catch (RefaccionariaException e) {
            log.error("Excepcion al enviar correo: ", e);
            throw new MailerException(e);

        }

    }

    /**
     * @param mgb mgb
     * @return String
     * @throws RefaccionariaException RefaccionariaException
     */
    private String getTemplateContent(MailerBean mgb) throws RefaccionariaException {
        //if (mgb.getTipoMail().intValue()
          //      == MailerBean.ENVIO_PROCESO_MONITOREO_PCB.intValue()) {
            return new MiscUtil().getSourceFromClassPath("1");
        //}
        //return "";
    }

    /**
     * @param content content
     * @param mgb mgb
     * @return String
     */
    private String replaceTags(String content, MailerBean mgb) {

        Date fecha = new Date();
        String fechaProceso = MiscUtil.convertDate2HumanReadable(fecha);

        content = content.replaceAll("\\{tituloCorreo\\}",
                MailerBean.TITULO_MAIL[0]);
        content = content.replaceAll("\\{Header\\}", mgb.getHeader().toString());
        content = content.replaceAll("\\{fecha\\}",
                fechaProceso);
        content = content.replaceAll("\\{bodyMessage\\}",
                mgb.getBody().toString());
        content = content.replaceAll("\\{footerMessage\\}",
                mgb.getFooter().toString());

        /*if ( mgb.getCssStyle() != null ){
        content = content.replaceAll("\\{cssStyle\\}", mgb.getFooter().toString());
        }*/

        return content;
    }
}
