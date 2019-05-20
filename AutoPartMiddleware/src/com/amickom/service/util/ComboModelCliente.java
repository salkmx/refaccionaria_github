package com.amickom.service.util;



import com.amickom.autopartdao.dto.Cliente;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class ComboModelCliente extends AbstractListModel implements ComboBoxModel {

    private String selectedItem;
    private List<Cliente> clientes;

    public ComboModelCliente(List orgs) {
        this.clientes = orgs;
    }

    @Override
    public String getSelectedItem() {

        return selectedItem;
    }

    @Override
    public void setSelectedItem(Object newValue) {
        for (Cliente cliente : clientes) {
            if (newValue.equals(cliente.getNombre())) {
                selectedItem = cliente.getNombre();
                break;
            }
        }
    }

    @Override
    public int getSize() {
        return clientes.size();
    }

    @Override
    public String getElementAt(int i) {
        return clientes.get(i).getNombre();
    }
}
