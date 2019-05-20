/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amickom.autopartdao.dao;

import com.amickom.autopartdao.dto.Productos;
import com.amickom.autopartdao.exceptions.ExcelDAOException;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author GRUPO HERA HP2
 */
public interface ExcelDAO {

    public static final DecimalFormat DECIMAL = new DecimalFormat("###,###,###,###.00");

    /**
     * Método que procesa un archivo excel y 
     * obtiene los prodcutos que van asociados al mismo
     * @param ruta ruta fisica del archivo dentro de la pc
     * @param proveedor identificador del proveedor
     * @return List<ProductosDao> lista con los productos obtenidos
     * @throws ExcelDAOException en caso de cualquier excepción 
     */
    public List<Productos> procesaProductos(String ruta) throws ExcelDAOException;
}
