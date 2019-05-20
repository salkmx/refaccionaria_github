/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amickom.service.util;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Inginf
 */
public class TableModelConfirmacion extends DefaultTableModel {

    public TableModelConfirmacion(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }

    Class[] types = new Class[]{
        String.class, String.class,
        Double.class, String.class, Double.class, Integer.class, Double.class
    };
    boolean[] canEdit = new boolean[]{
        false, false, false, false, false, false, false
    };

    @Override
    public Class getColumnClass(int columnIndex) {
        return types[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
    }
}
