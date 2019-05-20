/*
 * AutoPartsSwingApp.java
 */

package com.amickom.autopartsswing;

import com.amickom.autopartsswing.login.Login;
import com.amickom.service.IInitializeService;
import com.amickom.service.ILoginService;
import com.amickom.service.exception.RefaccionariaException;
import com.amickom.service.impl.InitializeService;
import com.amickom.service.impl.LoginService;
import java.io.File;
import org.apache.log4j.Logger;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The main class of the application.
 */
public class AutoPartsSwingApp extends SingleFrameApplication {
    
    
    /**
     * 
     */
    private static Logger log = Logger.getLogger(AutoPartsSwingApp.class);
    
    /**
     * Ctx spring de la aplicación
     */
    public static ClassPathXmlApplicationContext ctx; 
    
    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new Login(this));
    }

    @Override
    protected void initialize(String[] args) {
        try {
            log.debug("Iniciando el ");
            setDBSystemDir();
            IInitializeService initialize = new InitializeService();
            boolean existeBD = initialize.existeBD();
            ctx = new ClassPathXmlApplicationContext("applicationContext.xml", 
                    "resources/dao-beans.xml");
            if (!existeBD) {
                log.debug("Inicio de BD insertando usuario");
                ILoginService login = (LoginService)
                        ctx.getBean("loginservice");
                login.insertaUsuario();
            }
            log.debug("ctx iniciado");
            super.initialize(args);
        } 
        catch (RefaccionariaException ex) {
            log.error("Error Fatal no se pude inicializar el sistema " + 
                    ex.getMessage(), ex);
            super.exit();
        }
    }
    
    
    
    /**
     * Inicializa el directorio derby.
     */
    private void setDBSystemDir() {
        String systemDir = "/";
        log.debug("La bd esta en la ruta: " + systemDir);
        System.setProperty("derby.system.home", systemDir);
        File fileSystemDir = new File(systemDir);
        fileSystemDir.mkdir();
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of AutoPartsSwingApp
     */
    public static AutoPartsSwingApp getApplication() {
        return Application.getInstance(AutoPartsSwingApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(AutoPartsSwingApp.class, args);
    }
}
