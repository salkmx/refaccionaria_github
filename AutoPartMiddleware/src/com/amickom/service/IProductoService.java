/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amickom.service;

import com.amickom.autopartdao.dto.PedidoProducto;
import com.amickom.service.exception.RefaccionariaException;
import com.amickom.service.util.ComboModelMarca;
import com.amickom.service.util.TableModelConfirmacion;
import com.amickom.service.util.TableModelProductos;
import java.util.List;

/**
 *
 * @author david
 */
public interface IProductoService {

    /**
     * Obtiene ComboModelMarca para el combo de marcas
     * @return ComboModelMarca modelo con las marcas que existen en el 
     * la tabla de productos
     */
    public ComboModelMarca obtieneMarcas() throws RefaccionariaException;

    /**
     * Obtiene el modelo para que se seleccione el valor de los
     * productos que se van a presentar en la pantalla de pedido
     * @param marca marca de la cual se van a obtener los productos en 
     * caso de ir null todas
     * @param codigo codigo del producto a buscar en caso de ir null
     * todos
     * @return ProductoTableModel modelo de datos a mostrar
     * @throws RefaccionariaException en caso de cualquier excepción 
     */
    //public DefaultTableModel obtieneProductos(String marca, String codigo) throws RefaccionariaException;

    /**
     * Obtiene el modelo para que se seleccione el valor de los
     * productos que se van a presentar en la pantalla de pedido
     * @param marca marca de la cual se van a obtener los productos en 
     * caso de ir null todas
     * @param codigo codigo del producto a buscar en caso de ir null
     * todos
     * @param proveedor nombre del proveedor al que se quiere hacer referencia 
     * @param nombre nombre del producto
     * @return ProductoTableModel modelo de datos a mostrar
     * @throws RefaccionariaException en caso de cualquier excepción 
     */
    public TableModelProductos obtieneProductosP(String marca, String codigo, 
            String proveedor, String nombre) throws RefaccionariaException;

    /**
     * Obtiene el modelo para que se seleccione el valor de los
     * productos que se van a presentar en la pantalla de pedido
     * @param productos lista con los productos seleccionados
     * @return ProductoTableModel modelo de datos a mostrar
     * @throws RefaccionariaException en caso de cualquier excepción 
     */
    public TableModelConfirmacion obtieneProductosTemp() throws RefaccionariaException;

    /**
     * Inserta un producto en la tabla temporal de productos pedidos
     * @param producto producto que va a hacer agregado a la lista
     * @return true si se inserto correctamente false en caso contrario
     * @throws RefaccionariaException en caso de cualquier excepción 
     */
    public boolean insertaTemp(PedidoProducto producto) throws RefaccionariaException;

    /**
     * Elimina un registro de la tabla temporal de productos pedidos
     * @param producto producto que va a hacer agregado a la lista
     * @return true si se elimino correctamente false en caso contrario
     * @throws RefaccionariaException en caso de cualquier excepción 
     */
    public boolean deleteTemp(PedidoProducto producto) throws RefaccionariaException;

    /**
     * Borra la tabla temporal de 
     * @return true si se inserto correctamente false en caso contrario
     * @throws RefaccionariaException en caso de cualquier excepción 
     */
    public boolean deleteAllTemp() throws RefaccionariaException;

    /**
     * Obtiene la lista de pedidos productos por cliente
     * @param nombre nombre del cliente
     * @return List<PedidoProducto> lista con los productos obtenidos para el cliente
     * @throws RefaccionariaException en caso de cualquier excepción 
     */
    public List<PedidoProducto> obtieneListaProductosPedidoCliente(String nombre) throws RefaccionariaException;
    
    /**
     * Método que busca si un producto ya está agregado en el pedido
     * @param codigo código del producto 
     * @param cantidad cantidad de productos agregados al pedido
     * @param utilidad utilidad de los productos agregados al pedido
     * @return boolean true si ya existe el producto en el pedido, false en caso contrario
     * @throws RefaccionariaException en caso de cualquier excepción 
     */
    public boolean findTemp(String codigo, int cantidad, double utilidad) throws RefaccionariaException;
}
