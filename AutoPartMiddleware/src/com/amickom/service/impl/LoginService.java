/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amickom.service.impl;

import com.amickom.autopartdao.dao.UsuarioDao;
import com.amickom.autopartdao.dto.Usuario;
import com.amickom.autopartdao.dto.UsuarioPk;
import com.amickom.autopartdao.exceptions.UsuarioDaoException;
import com.amickom.service.ILoginService;
import java.util.Calendar;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


/**
 *
 * @author GRUPO HERA HP2
 */
@Service("loginservice")
public class LoginService implements ILoginService {
    
    private static Logger logger = Logger.getLogger(LoginService.class);
    
    @Autowired
    @Qualifier("UsuarioDao")
    private UsuarioDao usuarioDAO; 
    
    /**
     * Obtiene los datos del usuario 
     * @param usuario usuario a realizar el login   
     * @param password password de usuario que realiza el login
     * @return Usuario datos del usuario
     */
    @Override
    public boolean obtieneDatosUsuario(String usr, String password) { 
        boolean existe = false;
        try {
            logger.debug("Iniciando servicio de login...");
            existe = usuarioDAO.login(usr, password);
        } 
        catch (UsuarioDaoException ex) {
            logger.error("Error en el  servicio de login..." + ex.getMessage(), ex);            
        }
        return existe;
    }

    @Override
    public boolean insertaUsuario() {
        boolean secreo = false;
        UsuarioPk usuarioPk = null;
        Usuario usuario = new Usuario();
        try {
            usuario.setClave("Armando");
            usuario.setFechaAlta(Calendar.getInstance().getTime());
            usuario.setPassword("Macedo");
            usuario.setRol("A");
            logger.debug("Iniciando servicio de login...");
            usuarioPk = usuarioDAO.insert(usuario);
            if (usuarioPk != null) {
                logger.debug("Se creo al usuario " + usuarioPk.getId());
                secreo = true;
            }
        } 
        catch (Exception ex) {
            logger.error("Insertando al usuario..." + ex.getMessage(), ex);            
        }
        return secreo;
    }
    
    
    
}
