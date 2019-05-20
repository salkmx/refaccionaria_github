package com.amickom.service.util;



import com.amickom.autopartdao.dto.Proveedor;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class ComboModelProveedor extends AbstractListModel implements ComboBoxModel {

    private String selectedItem;
    private List<Proveedor> proveedores;

    public ComboModelProveedor(List provs) {
        this.proveedores = provs;
    }

    @Override
    public String getSelectedItem() {

        return selectedItem;
    }

    @Override
    public void setSelectedItem(Object newValue) {
        for (Proveedor proveedor : proveedores) {
            if (newValue.equals(proveedor.getEmpresa())) {
                selectedItem = proveedor.getEmpresa();
                break;
            }
        }
    }

    @Override
    public int getSize() {
        return proveedores.size();
    }

    @Override
    public String getElementAt(int i) {
        return proveedores.get(i).getEmpresa();
    }
}
