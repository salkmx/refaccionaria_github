/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amickom.service.util;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Inginf
 */
public class TableModelProductos extends DefaultTableModel {

    private ArrayList<Integer> datosCompletos;

    public TableModelProductos(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
        
    }
    Class[] types = new Class[]{
        Boolean.class, String.class, String.class,
        Double.class, String.class, Double.class, Integer.class, Double.class
    };
    boolean[] canEdit = new boolean[]{
        false, false, false, false, false, true, true, false
    };

    @Override
    public Class getColumnClass(int columnIndex) {
        return types[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        boolean editable = canEdit[columnIndex];
        if (columnIndex == 0) {
            if (getDatosCompletos().contains(rowIndex)) {
                editable = true;
            }
        }
        return editable;
    }

    public ArrayList<Integer> getDatosCompletos() {
        if (this.datosCompletos == null) {
            this.datosCompletos = new ArrayList<Integer>();
        }
        return this.datosCompletos;
    }
}
