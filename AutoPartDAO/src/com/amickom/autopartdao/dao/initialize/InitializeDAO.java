/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amickom.autopartdao.dao.initialize;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 *
 * @author GRUPO HERA HP2
 */
@Repository("initializeDAO")
public class InitializeDAO {

    /**
     * 
     */
    private static Logger log = Logger.getLogger(InitializeDAO.class);
    /**
     * propiedades de la conexión de la base de datos
     */
    public Properties dbProperties;
    /**
     * Propiedad donde se almacena el nombre de la base de datos
     */
    public String dbName;

    /**
     * Método que revisa si existe la base de datos y en caso de que no 
     * se crea y todos los elementos de la misma
     * @return boolean true en caso de existir, false en caso 
     * contrario
     */
    public boolean existeBD() {
        boolean existeBD = false;
        dbProperties = loadDBProperties();
        dbName = dbProperties.getProperty("db.name");
        String driverName = dbProperties.getProperty("derby.driver");
        loadDatabaseDriver(driverName);
        if (!dbExists()) {
            log.debug("No existe la base de datos ");
            existeBD = createDatabase();
        } else {
            log.debug("La base de datos ya existe");
        }
        return existeBD;
    }

    /**
     * Carga las propiedades de la BD
     * @return Properties propiedades de la conexión de BD
     */
    private Properties loadDBProperties() {
        InputStream dbPropInputStream = null;
        dbPropInputStream = InitializeDAO.class.getResourceAsStream("/com/amickom/autopartdao/"
                + "dao/initialize/properties/Configuration.properties");
        Properties dbProperties = new Properties();
        try {
            dbProperties.load(dbPropInputStream);
        } catch (IOException ex) {
            log.error("Error al cargar las propiedades de la bd.",
                    ex);
        }
        return dbProperties;
    }

    /**
     * 
     * @return 
     */
    public String getDatabaseUrl() {
        String dbUrl = dbProperties.getProperty("derby.url") + dbName;
        return dbUrl;
    }

    /**
     * Crea base de datos para refaccionaria
     * @return true en caso de haber sido creada con exito
     * false en caso contrario.
     */
    private boolean createDatabase() {
        boolean bCreated = false;
        Connection dbConnection = null;
        String dbUrl = getDatabaseUrl();
        dbProperties.put("create", "true");

        try {
            log.debug("Creando la base de datos");
            dbConnection = DriverManager.getConnection(dbUrl, dbProperties);
            bCreated = createTables(dbConnection);
        } catch (Exception ex) {
            log.error("Error al crear la base de datos: ",
                    ex);
        } finally {
            dbProperties.remove("create");
            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ex) {
                    log.error("Error al cerrar la conexion ", ex);
                }
            }
        }
        return bCreated;
    }

    /**
     * 
     * @return 
     */
    public String getDatabaseLocation() {
        String dbLocation = System.getProperty("derby.system.home") + dbName;
        log.debug("Verificando existencia de BD en ruta " + dbLocation);
        return dbLocation;
    }

    /**
     * Revisa si la base de datos existe
     * @return true en caso de existir, false en caso contrario
     */
    private boolean dbExists() {
        boolean bExists = false;
        String dbLocation = getDatabaseLocation();
        File dbFileDir = new File(dbLocation);
        if (dbFileDir.exists()) {
            bExists = true;
        }
        return bExists;
    }

    /**
     * Carga el driver de la base de datos
     * @param driverName NOMBRE DEL DRIVER DE 
     */
    private void loadDatabaseDriver(String driverName) {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException ex) {
            log.debug("Error al cargar el driver ", ex);
        }
    }

    /**
     * Método que crea la base de datos en caso de no existir.
     * @param dbConnection 
     * @return 
     */
    private boolean createTables(Connection dbConnection) {
        boolean bCreatedTables = false;
        Statement statement = null;
        try {
            log.debug("Creando las tablas de la base de datos");
            statement = dbConnection.createStatement();
            statement.execute(TABLA_CLIENTE);
            statement.execute(TABLA_PEDIDIO);
            statement.execute(TABLA_PRODUCTO_PRODUCTO);
            statement.execute(PRIMARY_KEY_PP);
            statement.execute(TABLA_PRODUCTOS);
            statement.execute(TABLA_PROVEEDOR);
            statement.execute(TABLA_USUARIO);
            statement.execute(TABLA_ARCHIVOS);
            statement.execute(TABLA_PRODUCTOS_TEMP);
            statement.execute(FK_PEDIDO);
            statement.execute(FK_PEDIDO_PRODUCTO_PEDIDO);
            statement.execute(FK_PEDIDO_PRODUCTO_PRODUCTO);
            statement.execute(FK_PROVEEDOR_ARCHIVO);
            bCreatedTables = true;
            log.debug("Se crearon las tablas correctamente");
        } catch (Exception ex) {
            log.error("Error al crear las tablas ", ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    log.error("Error al cerrar el stmt ", ex);
                }
            }
        }

        return bCreatedTables;
    }
    /**
     * Crea tabla de clientes
     */
    public static final String TABLA_CLIENTE = "CREATE TABLE app.CLIENTE( "
            + "ID INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
            + "NOMBRE VARCHAR(50) NOT NULL, "
            + "RFC VARCHAR(15) NOT NULL, "
            + "DIRECCION VARCHAR(100) , "
            + "TELEFONO VARCHAR(15) , "
            + "celular VARCHAR(15) , "
            + "cp VARCHAR(5) , "
            + "ciudad VARCHAR(50) , "
            + "EMAIL VARCHAR(70) , "
            + "FECHA_REGISTRO DATE NOT NULL, "
            + "Estatus int not null "
            + ") ";
    /**
     * Crea tabla de pedidos
     */
    public static final String TABLA_PEDIDIO = "CREATE TABLE app.PEDIDO( "
            + "ID INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
            + "ID_CLIENTE INTEGER NOT NULL, "
            + "FECHA_ALTA DATE , "
            + "PRECIO DOUBLE NOT NULL, "
            + "IVA DOUBLE NOT NULL, "
            + "ID_USUARIO INTEGER NOT NULL,"
            + "subtotal double NOT NULL "
            + ")  ";
    /**
     * Tabla de pedido producto 
     */
    public static final String TABLA_PRODUCTO_PRODUCTO = "CREATE TABLE app.PEDIDO_PRODUCTO( "
            + "ID_PEDIDO INTEGER NOT NULL, "
            + "ID_PRODUCTO INTEGER NOT NULL, "
            + "cantidad INTEGER NOT NULL, "
            + "utlidad DOUBLE NOT NULL "
            + ") ";
    /**
     * PRIMARY KEY TABLADE PEDIDO PRODUCTO
     */
    public static final String PRIMARY_KEY_PP = "ALTER TABLE app.PEDIDO_PRODUCTO "
            + "ADD PRIMARY KEY (ID_PEDIDO, ID_PRODUCTO)";
    /**
     * TABLA DE PRODCUTOS
     */
    public static final String TABLA_PRODUCTOS = "CREATE TABLE app.PRODUCTOS( "
            + "ID_PRODUCTO INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
            + "ID_PROVEEDOR INTEGER NOT NULL, "
            + "CODIGO VARCHAR(20) , "
            + "PRECIO DOUBLE , "
            + "FECHA_ALTA DATE , "
            + "MARCA VARCHAR(30),"
            + "DESCRIPCION VARCHAR(300),"
            + "estatus int not null "
            + ")";
    /**
     * TABLA DE PRODCUTOS
     */
    public static final String TABLA_PRODUCTOS_TEMP = "CREATE TABLE app.PRODUCTOS_TEMP( "
            + "ID_PRODUCTO INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
            + "CODIGO VARCHAR(20) , "
            + "PRECIO DOUBLE , "
            + "MARCA VARCHAR(30),"
            + "DESCRIPCION VARCHAR(300), "
            + "utilidad double, "
            + "cantidad double, "
            + "precioventa double )";
    /**
     * Tabla de  proveedores 
     */
    public static final String TABLA_PROVEEDOR = "CREATE TABLE app.PROVEEDOR( "
            + "ID INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
            + "EMPRESA VARCHAR(50) NOT NULL, "
            + "RFC VARCHAR(15) NOT NULL, "
            + "DIRECCION VARCHAR(100) , "
            + "CP VARCHAR(5) , "
            + "CIUDAD VARCHAR(30) , "
            + "TELEFONO VARCHAR(15) , "
            + "CELULAR VARCHAR(15) , "
            + "EMAIL VARCHAR(70) , "
            + "FECHA_REGISTRO DATE,  "
            + "Estatus int not null, " //Estaus 1 activo 0 inactivo
            + "COMISION_FIJA int not null," //Comisión fija 1 si 0 no 
            + "porcentaje_comision double )";
    
    /**
     * 
     */
    public static final String TABLA_ARCHIVOS = "CREATE TABLE app.ARCHIVOS( "
            + "ID INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
            + "nombre VARCHAR(50) NOT NULL, "
            + "archivo clob(10 M) NOT NULL, "
            + "id_proveedor INTEGER not null, "
            + "fecha_captura DATE not null,"
            + "estatus int not null "
            + ")";
    /**
     * TABLA DE ARCHIVOS 
     */
    public static final String TABLA_USUARIO = "CREATE TABLE app.USUARIO( "
            + "ID INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
            + "CLAVE VARCHAR(15) NOT NULL, "
            + "PASSWORD VARCHAR(30) NOT NULL, "
            + "FECHA_ALTA DATE NOT NULL, "
            + "ROL VARCHAR(1) NOT NULL "
            + ")";
    /**
     * Foreign key Pedido haciam cliente
     */
    public static final String FK_PEDIDO = "ALTER TABLE app.PEDIDO "
            + "ADD FOREIGN KEY (ID_CLIENTE) REFERENCES app.CLIENTE (ID)";
    /**
     * Foreign key Pedido producto pedido 
     */
    public static final String FK_PEDIDO_PRODUCTO_PEDIDO = "ALTER TABLE app.PEDIDO_PRODUCTO "
            + "ADD FOREIGN KEY (ID_PEDIDO) REFERENCES app.PEDIDO (ID)";
    /**
     * Forign key pedido producto producto 
     */
    public static final String FK_PEDIDO_PRODUCTO_PRODUCTO = "ALTER TABLE app.PEDIDO_PRODUCTO ADD "
            + "FOREIGN KEY (ID_PRODUCTO) REFERENCES app.PRODUCTOS (ID_PRODUCTO)";
    /**
     * Forign key pedido producto producto 
     */
    public static final String FK_PROVEEDOR_ARCHIVO = "ALTER TABLE app.ARCHIVOS ADD "
            + "FOREIGN KEY (id_proveedor) REFERENCES app.PROVEEDOR (id)";
}
