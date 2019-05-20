/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amickom.autopartsswing.listener;

import com.amickom.autopartdao.dto.PedidoProducto;
import com.amickom.autopartdao.dto.Productos;
import com.amickom.autopartsswing.UtilsSwing;
import com.amickom.autopartsswing.operacion.OperacionPanel;
import com.amickom.service.exception.RefaccionariaException;
import com.amickom.service.util.TableModelProductos;
import javax.swing.JFrame;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import org.apache.log4j.Logger;

/**
 *
 * @author david
 */
/**
 * Clase que verifica cuando una celda es 
 * seleccionada por un usuario
 */
public class SeleccionModelListener implements TableModelListener {

    private static Logger logger = Logger.getLogger(SeleccionModelListener.class);
    private TableModelProductos model;
    private OperacionPanel panel;

    /**
     * Constructor por default
     */
    public SeleccionModelListener(
            TableModelProductos model, OperacionPanel panel) {
        this.model = model;
        this.panel = panel;
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        StringBuilder sb = new StringBuilder();
        switch (e.getType()) {
            case TableModelEvent.UPDATE:
                Integer indice = e.getFirstRow();
                logger.debug("Actualizando el valor de " + e.getSource().toString() + " " + indice + " " + e.getLastRow());
                Boolean estado = (Boolean) model.getValueAt(indice, 0);
                PedidoProducto pedido = new PedidoProducto();
                Productos prod = new Productos();
                prod.setCodigo((String) model.getValueAt(indice, 1));
                prod.setDescripcion((String) model.getValueAt(indice, 2));
                prod.setPrecio(((Double) model.getValueAt(indice, 3)));
                prod.setMarca((String) model.getValueAt(indice, 4));
                pedido.setProductos(prod);
                if (e.getColumn() == 0) {
                    /**if (model.getValueAt(indice, 5) == null) {
                    sb.append("Debe seleccionar la utilidad \n");
                    } else if ((Double) model.getValueAt(indice, 5) <= 0) {
                    sb.append("La utilidad debe ser mayor que cero \n");
                    } else if ((Double) model.getValueAt(indice, 5) > 100) {
                    sb.append("La utilidad no debe ser mayor que cien \n");
                    } else {
                    pedido.setUtilidad((Double) model.getValueAt(indice, 5));
                    }
                    if (model.getValueAt(indice, 6) == null) {
                    sb.append("Debe seleccionar la cantidad \n");
                    } else if ((Integer) model.getValueAt(indice, 6) <= 0) {
                    sb.append("La cantidad debe ser mayor que cero \n");
                    } else {
                    pedido.setCantidad((Integer) model.getValueAt(indice, 6));
                    double precio = (Double) model.getValueAt(indice, 3);
                    Double precioVenta = (((Double) model.getValueAt(indice, 5) / 100)
                     * precio + precio) * (Integer) model.getValueAt(indice, 6);
                    model.setValueAt(precioVenta, indice, 7);
                    }**/
                    //try {
                    //if (panel.productosService.findTemp((String) model.getValueAt(indice, 1),
                    //      (Integer) model.getValueAt(indice, 6), (Double) model.getValueAt(indice, 5))) {
                    pedido.setUtilidad((Double) model.getValueAt(indice, 5));
                    pedido.setCantidad((Integer) model.getValueAt(indice, 6));
                    double precio = (Double) model.getValueAt(indice, 3);
                    Double precioVenta = (((Double) model.getValueAt(indice, 5) / 100)
                            * precio + precio) * (Integer) model.getValueAt(indice, 6);
                    model.setValueAt(precioVenta, indice, 7);
                    if (estado.booleanValue() == true) {
                        try {
                            logger.debug("Insertando producto " + prod.toString());
                            if (sb.toString().trim().equals("")) {
                                if (!panel.productosService.findTemp((String) model.getValueAt(indice, 1),
                                        (Integer) model.getValueAt(indice, 6), (Double) model.getValueAt(indice, 5))) {
                                    if (panel.productosService.insertaTemp(pedido)) {
                                        UtilsSwing.mensajeExito("Producto agregado al pedido", (JFrame) panel.getParent().
                                                getParent().getParent().
                                                getParent().getParent());
                                        model.getDatosCompletos().remove(indice);
                                    } else {
                                        UtilsSwing.mensajeError("Error al agregar el  producto al pedido", (JFrame) panel.getParent().
                                                getParent().getParent().
                                                getParent().getParent());
                                    }
                                } else {
                                    UtilsSwing.mensajeWarning("El Producto ya había sido agregado al pedido", (JFrame) panel.getParent().
                                            getParent().getParent().
                                            getParent().getParent());
                                }
                            } else {
                                UtilsSwing.mensajeError(sb.toString(), (JFrame) panel.getParent().
                                        getParent().getParent().
                                        getParent().getParent());
                            }

                        } catch (RefaccionariaException ex) {
                            logger.error("El producto no se inserto " + prod.toString() +ex.getMessage(), ex);
                        }
                    } /**else {
                        try {
                            logger.debug("Eliminando producto " + prod.toString());
                            int i = UtilsSwing.confirmaOperacion((JFrame) panel.getParent().
                                    getParent().getParent().
                                    getParent().getParent(),
                                    "Desea eliminar el producto del pedido");
                            if (i == 0) {
                                if (panel.productosService.findTemp((String) model.getValueAt(indice, 1),
                                        (Integer) model.getValueAt(indice, 6), (Double) model.getValueAt(indice, 5))) {
                                    if (panel.productosService.deleteTemp(pedido)) {
                                        model.setValueAt(new Double(0), indice, 5);
                                        model.setValueAt(0, indice, 6);
                                        model.getDatosCompletos().remove(i);
                                        UtilsSwing.mensajeExito("Producto eliminado del pedido", (JFrame) panel.getParent().
                                                getParent().getParent().
                                                getParent().getParent());
                                    } else {
                                        UtilsSwing.mensajeError("Error al eliminar el producto", (JFrame) panel.getParent().
                                                getParent().getParent().
                                                getParent().getParent());
                                    }
                                } else {
                                    UtilsSwing.mensajeWarning("Producto inexistente en el pedido", (JFrame) panel.getParent().
                                            getParent().getParent().
                                            getParent().getParent());
                                }
                            }
                        } catch (RefaccionariaException ex) {
                            logger.error("El producto no se Elimino " + prod.toString());
                        }

                    }**/
                    // }
                    // } catch (RefaccionariaException ex) {
                    //   logger.error("Error al consultar estatus del producto " + ex.getMessage());
                    // }
                } else if ((e.getColumn() == 5 || e.getColumn() == 6)) {
                    logger.debug("Seleccionando cantidad o utilidad");
                    if (model.getValueAt(indice, 5) == null) {
                        sb.append("Debe seleccionar la utilidad \n");
                    } /*else if ((Double) model.getValueAt(indice, 5) <= 0) {
                        sb.append("La utilidad debe ser mayor que cero \n");
                    } */else if ((Double) model.getValueAt(indice, 5) > 100) {
                        sb.append("La utilidad no debe ser mayor que cien \n");
                    }
                    if (model.getValueAt(indice, 6) == null) {
                        sb.append("Debe seleccionar la cantidad \n");
                    } else if ((Integer) model.getValueAt(indice, 6) <= 0) {
                        sb.append("La cantidad debe ser mayor que cero \n");
                    }
                    if (!sb.toString().trim().equals("")) {
                        UtilsSwing.mensajeWarning(sb.toString(), (JFrame) panel.getParent().
                                getParent().getParent().
                                getParent().getParent());
                    } else {
                        double precio = (Double) model.getValueAt(indice, 3);
                        Double precioVenta = (((Double) model.getValueAt(indice, 5) / 100)
                                * precio + precio) * (Integer) model.getValueAt(indice, 6);
                        model.setValueAt(precioVenta, indice, 7);
                        model.getDatosCompletos().add(indice);
                    }
                }
                break;
            default:
                break;
        }
    }
}
