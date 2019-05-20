/*
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amickom.service;

import com.amickom.service.exception.RefaccionariaException;

/**
 *
 * @author GRUPO HERA HP2
 */
public interface IInitializeService {
    
    /**
     * Método que verifica que la  base de datos exista
     * si la base no existe la crea con todas sus tablas
     * @return true si existe la bd, false en caso contrario
     * @throws ReflectiveOperationException en caso de cualquier excepción 
     */
    public boolean existeBD() throws RefaccionariaException;
    
}
