/**
 *
 */
package com.amickom.service;

import com.amickom.autopartdao.dto.PedidoProducto;
import com.amickom.autopartdao.dto.Proveedor;
import com.amickom.service.exception.RefaccionariaException;
import com.amickom.service.mail.MailerBean;
import java.util.List;

/**
 * @author David Omar S�nchez Rodr�guez
 * Na-at Consulting S.C.
 * 15/07/2009
 * IServiciosMail.java
 */
public interface IServiciosMail {

    /**
     * @param mail mail
     * @param direccion direccion
     * @param archivoAdjunto archivoAdjunto
     * @param nombreArchivoAdjunto nombreArchivoAdjunto
     * @return boolean
     * @throws SipareMailException SipareMailException
     */
    public boolean enviaMail(MailerBean mail, String direccion,
            byte[] archivoAdjunto, String nombreArchivoAdjunto)
            throws RefaccionariaException;

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
            throws RefaccionariaException;
    /**
     * Proceso que envía un email a un determinado proveedor solicitando 
     * información sobre los productos que se vendieron en un pedido
     * @param proveedor el proveedor al que hay que enviar el pedido
     * @param productospedido lista de productos por los que hay que solicitar información 
     * @return true si se envío correctamente false en caso contrario
     * @throws RefaccionariaException en caso de cualquier excepción 
     */
    public boolean enviaMail(Proveedor proveedor, List<PedidoProducto> productospedido) 
            throws RefaccionariaException;
}
