/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amickom.service;

import com.amickom.autopartdao.dto.NotaRemisionDTO;
import com.amickom.autopartdao.dto.VentasUtilidadDTO;
import com.amickom.autopartdao.dto.VentasxClienteDTO;
import com.amickom.autopartdao.dto.VentasxProveedorDTO;
import com.amickom.service.exception.RefaccionariaException;
import java.util.List;

/**
 *
 * @author david
 */
public interface IReportService {
    
    /**
     * Método que genera la nota de remision para su posterior presentación en la vista
     * @param remisionDTO objeto con los datos de la nota de remisión
     * @return String con la ruta de generación de la nota de remisión
     * @throws RefaccionariaException en caso de cualquier excepción 
     */
    public String generaNotaRemision(NotaRemisionDTO remisionDTO) throws RefaccionariaException;
    
    /**
     * Método que genera el reporte de ventas por cliente, es un resumén de todas las 
     * ventas que se han hecho a un cliente especifico
     * @param ventas datos de la venta realizada para el cliente
     * @return String ruta donde se genero el reporte
     * @throws RefaccionariaException en caso de cualquier excepción 
     */
    public String ventasxCliente(VentasxClienteDTO ventas)  throws RefaccionariaException;
    
        /**
     * Método que genera el reporte de ventas por cliente, es un resumén de todas las 
     * ventas que se han hecho a un cliente especifico
     * @param ventas datos de la venta realizada para el cliente
     * @return String ruta donde se genero el reporte
     * @throws RefaccionariaException en caso de cualquier excepción 
     */
    public String ventasxProveedor(VentasxProveedorDTO ventas)  throws RefaccionariaException;
    
    /**
     * Método que genera el reporte de ventas/utilidad por cliente
     * @param ventas ventas encontradas en el periodo de fechas
     * @param fechaInicial fecha Inicial de la venta
     * @param fechaFinal fecha final de la venta
     * @return ruta donde se genero el reporte
     * @throws RefaccionariaException en caso de cualquier excepción 
     */
    public String ventasUtilidadxCliente(List<VentasUtilidadDTO> ventas, 
            String fechaInicial, String fechaFinal)  throws RefaccionariaException;
    
}
