/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amickom.service;

/**
 *
 * @author GRUPO HERA HP2
 */
public interface ILoginService {
    
    /**
     * Obtiene los datos del usuario 
     * @param usuario usuario a realizar el login   
     * @param password password de usuario que realiza el login
     * @return boolean datos del usuario
     */
    public boolean obtieneDatosUsuario(String usr, String password);
    
    /**
     * Método que inserta un usuario en la base de datos
     * @param usuario datos del usuario 
     * @return true si se realizó correctamente la inserción 
     * false en caso contrario
     */
    public boolean insertaUsuario();
    
}
