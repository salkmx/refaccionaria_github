/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amickom.service;

import com.amickom.autopartdao.dto.Proveedor;
import com.amickom.autopartdao.dto.VentasxProveedorDTO;
import com.amickom.service.exception.RefaccionariaException;
import com.amickom.service.util.ComboModelProveedor;

/**
 *
 * @author GRUPO HERA HP2
 */
public interface IProveedorService {

    /**
     * Realiza el alta de un proveedor
     * @param proveedor proveedor que va a ser dado de alta
     * @param ruta ruta del catalogo de productos
     * @return true en caso de ser  correcto, false en caso contrario
     * @throws RefaccionariaException en caso de cualquier excepción 
     */
    public boolean insertaProveedor(Proveedor proveedor, String ruta) throws RefaccionariaException;

    /**
     * Obtiene el modelo de proveedores para el combobox
     * @return ComboModelProveedor modelo de datos para el combobox de proveedores
     * @throws RefaccionariaException  en caso de cualquier excepción
     */
    public ComboModelProveedor obtieneModelProveedor() throws RefaccionariaException;

    /**
     * Obtiene el modelo de proveedores para el combobox
     * @return ComboModelProveedor modelo de datos para el combobox de proveedores
     * @throws RefaccionariaException  en caso de cualquier excepción
     */
    public ComboModelProveedor obtieneModelProveedorConsulta() throws RefaccionariaException;

    /**
     * Actualiza el catalogo de productos de acuerdo al proveedor
     * @param proveedor proveedor del que se actualizaran los catalogos
     * @param ruta ruta del nuevo catalogo
     * @return true si se actualizó bien false en caso contrario
     * @throws RefaccionariaException en caso de cualquier excepción 
     */
    public boolean actualizaCatalogo(String proveedor, String ruta) throws RefaccionariaException;

    /**
     * Elimina un proveedor dado el nombre 
     * @param nombre proveedor dado el nombre  nombre del cliente que se debe dar de baja
     * @return true si se realizo la baja, false en caso contrario
     * @throws RefaccionariaException en caso de cualquier excepción
     */
    public boolean eliminaProveedor(String nombre) throws RefaccionariaException;

    /**
     * Actualiza el nombre del proveedor
     * @param datos del proveedor a actualizar
     * @return true si se realizo la baja, false en caso contrario
     * @throws RefaccionariaException en caso de cualquier excepción
     */
    public boolean updateProveedor(Proveedor cliente) throws RefaccionariaException;

    /**
     * Obtiene los datos de un proveedor
     * @param nombre nombre del proveedor del cual se quieren obtener los datos
     * @return Cliente datos del proveedor
     * @throws RefaccionariaException en caso de cualquier excepción 
     */
    public Proveedor obtieneDatosProveedor(String nombre) throws RefaccionariaException;
    
        /**
     * Obtiene las ventas por cliente en un periodo determinado de fechas
     * @param nombre del cliente 
     * @param fechaInicial fecha inicial del periodo de ventas dd/MM/yyyy
     * @param fechaFinal fecha final del periodo de ventas dd/MM/yyyy
     * @return VentasxClienteDTO objeto con los datos del cliente 
     * y las ventas realizadas al mismo
     * @throws RefaccionariaException en caso de cualquier excepción
     */
    public VentasxProveedorDTO obtieneVentasxClienteFecha(String nombre, 
            String fechaInicial, String fechaFinal) throws RefaccionariaException;
}
