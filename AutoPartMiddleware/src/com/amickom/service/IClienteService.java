/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amickom.service;

import com.amickom.autopartdao.dto.Cliente;
import com.amickom.autopartdao.dto.VentasUtilidadDTO;
import com.amickom.autopartdao.dto.VentasxClienteDTO;
import com.amickom.service.exception.RefaccionariaException;
import com.amickom.service.util.ComboModelCliente;
import java.util.List;

/**
 *
 * @author GRUPO HERA HP2
 */
public interface IClienteService {

    /**
     * Realiza el alta de un cliente
     * @param cliente cliente que va a ser dado de alta
     * @return true en caso de ser  correcto, false en caso contrario
     * @throws RefaccionariaException en caso de cualquier excepción 
     */
    public boolean insertaCliente(Cliente cliente) throws RefaccionariaException;

    /**
     * Obtiene el modelo de clientes para el combobox
     * @return ComboModelCliente modelo de datos para el combobox de clientes
     * @throws RefaccionariaException  en caso de cualquier excepción
     */
    public ComboModelCliente obtieneModelCliente() throws RefaccionariaException;

    /**
     * Obtiene los datos de un cliente
     * @param nombre nombre del cliente del cual se quieren obtener los datos
     * @return Cliente datos del cliente
     * @throws RefaccionariaException en caso de cualquier excepción 
     */
    public Cliente obtieneDatosCliente(String nombre) throws RefaccionariaException;

    /**
     * Elimina un cliente dado el nombre 
     * @param nombre nombre del cliente que se debe dar de baja
     * @return true si se realizo la baja, false en caso contrario
     * @throws RefaccionariaException en caso de cualquier excepción
     */
    public boolean eliminaCliente(String nombre) throws RefaccionariaException;

    /**
     * Actualiza el nombre del cliente
     * @param datos del cliente a actualizar
     * @return true si se realizo la baja, false en caso contrario
     * @throws RefaccionariaException en caso de cualquier excepción
     */
    public boolean updateCliente(Cliente cliente) throws RefaccionariaException;

    /**
     * Obtiene las ventas por cliente
     * @param nombre del cliente 
     * @return VentasxClienteDTO objeto con los datos del cliente 
     * y las ventas realizadas al mismo
     * @throws RefaccionariaException en caso de cualquier excepción
     */
    public VentasxClienteDTO obtieneVentasxCliente(String nombre) throws RefaccionariaException;

    /**
     * Obtiene las ventas por cliente en un periodo determinado de fechas
     * @param nombre del cliente 
     * @param fechaInicial fecha inicial del periodo de ventas dd/MM/yyyy
     * @param fechaFinal fecha final del periodo de ventas dd/MM/yyyy
     * @return VentasxClienteDTO objeto con los datos del cliente 
     * y las ventas realizadas al mismo
     * @throws RefaccionariaException en caso de cualquier excepción
     */
    public VentasxClienteDTO obtieneVentasxClienteFecha(String nombre, 
            String fechaInicial, String fechaFinal) throws RefaccionariaException;

    /**
     * Se obtienen las ventas/utilidad totales por cliente
     * @param fechaInicial fecha inicial de la consulta MM/dd/yyyy
     * @param fechaFinal fecha final de la consultad MM/dd/yyyy
     * @return VentasxClienteDTO objeto con las ventas por cliente
     * @throws RefaccionariaException en caso de cualquier excepción 
     */
    public List<VentasUtilidadDTO> obtieneUtilidadVentasxCliente(String fechaInicial,
            String fechaFinal) throws RefaccionariaException;
}
