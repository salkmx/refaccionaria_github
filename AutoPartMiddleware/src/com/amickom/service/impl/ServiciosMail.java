/**
 *
 */
package com.amickom.service.impl;

import com.amickom.autopartdao.dto.PedidoProducto;
import com.amickom.autopartdao.dto.Proveedor;
import com.amickom.service.exception.RefaccionariaException;
import com.amickom.service.IServiciosMail;

import com.amickom.service.exception.MailerException;
import com.amickom.service.mail.MailerBean;
import com.amickom.service.mail.Mailer;
import com.amickom.service.mail.Attachment;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @author David Omar S�nchez Rodr�guez
 * Na-at Consulting S.C.
 * 15/07/2009
 * ServiciosMail.java
 */
@Service("mailService")
public class ServiciosMail implements IServiciosMail {

    private static Logger log = Logger.getLogger(ProveedorService.class);

    /**
     * 
     */
    public ServiciosMail() {
    }

    /**
     * #field
     *
     * @param mail DOCUMENT ME!
     * @param direccion DOCUMENT ME!
     * @param archivoAdjunto DOCUMENT ME!
     * @param nombreArchivoAdjunto DOCUMENT ME!
     * @return boolean
     * @throws SipareMailException DOCUMENT ME!
     */
    @Override
    public boolean enviaMail(MailerBean mail, String direccion,
            byte[] archivoAdjunto, String nombreArchivoAdjunto)
            throws RefaccionariaException {
        boolean enviaMail = false;
        Mailer mailer = new Mailer();

        try {
            ArrayList recTO = mail.getRecTO().isEmpty() ? null : mail.getRecTO();
            ArrayList recCC = mail.getRecCC().isEmpty() ? null : mail.getRecCC();
            ArrayList recBCC = mail.getRecBCC().isEmpty() ? null : mail.getRecBCC();

            ArrayList attachments = null;
            if (nombreArchivoAdjunto != null) {
                attachments = new ArrayList();
                Attachment attachment = new Attachment(nombreArchivoAdjunto,
                        archivoAdjunto);
                attachments.add(attachment);
            }

            mailer.enviaMensaje(mail, recTO, recCC, recBCC, attachments);
        } catch (MailerException mailExc) {
            log.error("Error al enviar el correo " + mailExc.getMessage(), mailExc);
            throw new RefaccionariaException(mailExc);
        }
        return enviaMail;
    }

    /**
     * @param mail mail
     * @param direccion direccion
     * @param archivoAdjunto archivoAdjunto
     * @param nombreArchivoAdjunto nombreArchivoAdjunto
     * @return boolean
     * @throws SipareMailException SipareMailException
     */
    public boolean enviaMailProcesos(MailerBean mail, String direccion,
            byte[] archivoAdjunto, String nombreArchivoAdjunto)
            throws RefaccionariaException {
        boolean enviaMail = false;
        Mailer mailer = new Mailer(1);

        try {
            ArrayList recTO = mail.getRecTO().isEmpty() ? null : mail.getRecTO();
            //ArrayList recCC = mail.getRecCC().isEmpty() ? null : mail.getRecCC();
            //ArrayList recBCC = mail.getRecBCC().isEmpty() ? null : mail.getRecBCC();

            ArrayList attachments = null;
            if (nombreArchivoAdjunto != null) {
                attachments = new ArrayList();
                Attachment attachment = new Attachment(nombreArchivoAdjunto,
                        archivoAdjunto);
                attachments.add(attachment);
            }
            mailer.enviaMensajeProcesos(mail, recTO, null, null, attachments);
        } catch (MailerException mailExc) {
            mailExc.printStackTrace();
            throw new RefaccionariaException(mailExc);
        }
        return enviaMail;
    }

    @Override
    public boolean enviaMail(Proveedor proveedor, List<PedidoProducto> productospedido)
            throws RefaccionariaException {
        boolean correoEnviado = false;
        log.debug("Iniciando envío de correo ");
        StringBuilder builder = new StringBuilder();
        builder.append("Estimado proveedor: ");
        builder.append(proveedor.getEmpresa());
        builder.append("<br/><br/>");
        builder.append("Se solicita surtir los siguientes productos: <br/><br/>");
        builder.append("<ul>");
        for (PedidoProducto pedidoProducto : productospedido) {
            builder.append("<li><bold>Marca</bold>&nbsp;");
            builder.append(pedidoProducto.getProductos().getMarca());
            builder.append(", <bold>Descripción</bold>&nbsp;");
            builder.append(pedidoProducto.getProductos().getDescripcion());
            builder.append(", <bold>Cantidad</bold>&nbsp;");
            builder.append(pedidoProducto.getCantidad());
            builder.append(", <bold>Código</bold>&nbsp;");
            builder.append(pedidoProducto.getProductos().getCodigo());
            builder.append("</li>");
        }
        builder.append("</ul>");
        ServiciosMail mail = new ServiciosMail();
        MailerBean mailerBean = new MailerBean();
        ArrayList destinatario = new ArrayList();
        destinatario.add(proveedor.getEmail());
        mailerBean.setRecTO(destinatario);
        mailerBean.setRecCC(new ArrayList());
        mailerBean.setRecBCC(new ArrayList());
        mailerBean.setAsunto("Información de productos de ARMANDO MACEDO ROBLES");
        mailerBean.setBody(builder);
        mailerBean.setHeader(new StringBuffer(""));
        //mailerBean.setFrom("");
        mailerBean.setFooter(new StringBuffer(""));
        mail.enviaMail(mailerBean, "", null, null);
        return correoEnviado;
    }

    /**public static void main(String[] args) {
        try {
            while(true) {
            MailerBean mailerBean = new MailerBean();
            ServiciosMail mail = new ServiciosMail();
            ArrayList lista = new ArrayList();
            lista.add("artemio25v@gmail.com");
            lista.add("davidomarsanches@gmail.com");
            mailerBean.setRecTO(lista);
            mailerBean.setRecCC(new ArrayList());
            mailerBean.setRecBCC(new ArrayList());
            mailerBean.setAsunto("Hola mi chavo");
            mailerBean.setBody(new StringBuilder("puto"));
            mailerBean.setFooter(new StringBuffer("reputo"));
            mailerBean.setHeader(new StringBuffer("to"));
            mail.enviaMail(mailerBean, "", null, null);
            }
        } catch (RefaccionariaException ex) {
            //
        }
    }**/
}
