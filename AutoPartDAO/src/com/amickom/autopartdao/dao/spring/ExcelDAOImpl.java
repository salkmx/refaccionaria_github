/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amickom.autopartdao.dao.spring;

import com.amickom.autopartdao.dao.ExcelDAO;
import com.amickom.autopartdao.dto.Productos;
import com.amickom.autopartdao.exceptions.ExcelDAOException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.log4j.Logger;

/**
 *
 * @author GRUPO HERA HP2
 */
public class ExcelDAOImpl implements ExcelDAO {
    
    private static Logger l = Logger.getLogger(ExcelDAOImpl.class);

    @Override
    public List<Productos> procesaProductos(String ruta) throws ExcelDAOException {
        InputStream is = null;
        List<Productos> productos = new ArrayList<Productos>();
        try {
            l.debug("Obteniendo productos del archivo " + ruta);
            is = new FileInputStream(ruta);
            Workbook libro = Workbook.getWorkbook(is);
            Sheet[] hojas = libro.getSheets();
            l.debug("El libro tiene hojas " + hojas.length);
            for (int i = 0; i < hojas.length; i++) {
                Sheet hoja = hojas[i];                
                int columnas = hoja.getColumns();
                int renglones = hoja.getRows();
                l.debug("La hoja tiene columnas y renglones " + columnas + " " +
                        renglones);                
                for (int j = 0; j < renglones; j++) {
                    Cell codigo = null;
                    Cell precio = null;
                    Cell marca = null;
                    Cell descripcion = null;
                    for (int k = 0; k < columnas; k++) {
                        switch (k) {
                            case 0: codigo = hoja.getCell(0, j); break;
                            case 2: precio = hoja.getCell(2, j); break;
                            case 3: marca = hoja.getCell(3, j); break;
                            case 1: descripcion = hoja.getCell(1, j); break;
                            default: break;
                        }                                                    
                    }                   
                    Productos producto = new Productos();
                    try {
                        producto.setCodigo(codigo == null ? "" : codigo.getContents());
                        producto.setMarca(marca == null ? "" : marca.getContents());                 
                        producto.setPrecio(precio == null ? 0 : DECIMAL.parse(precio.getContents()).doubleValue());
                        producto.setDescripcion(descripcion == null ? "" : descripcion.getContents());
                        if (!producto.getCodigo().trim().equals("") && 
                                producto.getPrecio() != 0) {
                            productos.add(producto);
                        }
                        
                    }
                    catch (Exception ex) {
                        l.error("Error al obtener productos del archivo " + ruta + " " + j + " " +
                        ex.getMessage(), ex);
                    }
                }                               
            }
        } catch (IOException ex) {
            l.error("Error al obtener productos del archivo " + ruta + " " + 
                    ex.getMessage(), ex);
        } catch (BiffException ex) {
            l.error("Error al obtener productos del archivo " + ruta + " " + 
                    ex.getMessage(), ex);
        } finally {
            try {
                is.close();
            } catch (IOException ex) {
                l.error("Error al obtener productos del archivo " + ruta + " " + 
                    ex.getMessage(), ex);
            }
        }
        return productos;
    }
    
    
    
}
