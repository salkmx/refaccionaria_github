/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amickom.service.util;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author david
 */
public class ProductoTableModel extends DefaultTableModel {
    
    /**
     * Nombres de columnas
     */
    protected String[] columnNames = new String[]{
        "Seleccionar", "Código", "Descripción", "Precio", "Marca", "Cantidad", "Utilidad"
    };
    
    private Object[][] data;
    
    
    
    
    public ProductoTableModel(Object[][] data) {
        super();
        this.data = data;
        setDataVector(this.data, columnNames);
        
    }
            
    /**
     * Tipos de datos de las columnas
     */
    protected Class[] columnClasses = new Class[]{
        Boolean.class, String.class, String.class,
        String.class, String.class, 
    };

    public ProductoTableModel() {
        super();
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return 0;
    }
    
    
    
}
