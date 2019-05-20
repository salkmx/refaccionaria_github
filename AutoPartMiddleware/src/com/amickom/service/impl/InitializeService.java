/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amickom.service.impl;

import com.amickom.autopartdao.dao.initialize.InitializeDAO;
import com.amickom.service.IInitializeService;
import com.amickom.service.exception.RefaccionariaException;
import org.apache.log4j.Logger;

/**
 *
 * @author GRUPO HERA HP2
 */
public class InitializeService implements IInitializeService {
    
    /**
     * 
     */
    private static Logger log = Logger.getLogger(InitializeService.class);
    
     /**
     * Método que verifica que la  base de datos exista
     * si la base no existe la crea con todas sus tablas
     * @return true si existe la bd, false en caso contrario
     * @throws RefaccionariaException en caso de cualquier excepción 
     */
    @Override
    public boolean existeBD() throws RefaccionariaException {
        boolean existeBD = true;
        try {
            InitializeDAO initializeDAO = new InitializeDAO();
            if (!initializeDAO.existeBD()) {
                log.debug("La base de datos ya existe");
            }
            else {
                log.debug("La base de datos no existe");
                existeBD = false;
            }
        }
        catch(Exception e) {
            log.error("Error al inicializar la base de datos " + 
                    e.getMessage());
            throw new RefaccionariaException("Error al crear "
                        + "la base de datos");
            
        } 
        return existeBD;
    }
    
}
