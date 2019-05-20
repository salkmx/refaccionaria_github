package com.amickom.service.util;



import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class ComboModelMarca extends AbstractListModel implements ComboBoxModel {

    private String selectedItem;
    private List<String> marcas;

    public ComboModelMarca(List marcas) {
        this.marcas = marcas;
    }

    @Override
    public String getSelectedItem() {

        return selectedItem;
    }

    @Override
    public void setSelectedItem(Object newValue) {
        for (String marca : marcas) {
            if (newValue.equals(marca)) {
                selectedItem = marca;
                break;
            }
        }
    }

    @Override
    public int getSize() {
        return marcas.size();
    }

    @Override
    public String getElementAt(int i) {
        return marcas.get(i);
    }
}
