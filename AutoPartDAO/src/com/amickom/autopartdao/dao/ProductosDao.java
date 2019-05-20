package com.amickom.autopartdao.dao;

import com.amickom.autopartdao.dto.PedidoProducto;
import com.amickom.autopartdao.dto.Productos;
import com.amickom.autopartdao.dto.ProductosPk;
import com.amickom.autopartdao.exceptions.ProductosDaoException;
import java.util.Date;
import java.util.List;

public interface ProductosDao {

    /**
     * Inserta los productos en lote
     * @param productos lista de productos a insertar
     * @param idProveedor identificador del proveedor
     * @return boolean true en caso correcto, false en caso contrario
     */
    public boolean insertaBatch(List<Productos> productos,
            int idProveedor);

    /**
     * Method 'insert'
     * 
     * @param dto
     * @return ProductosPk
     */
    public ProductosPk insert(Productos dto);

    /**
     * Method 'insert'
     * 
     * @param dto
     * @return ProductosPk
     */
    public boolean insertTemp(PedidoProducto dto);

    /** 
     * Updates a single row in the PRODUCTOS table.
     */
    public void update(ProductosPk pk, Productos dto) throws ProductosDaoException;

    /** 
     * Deletes a single row in the PRODUCTOS table.
     */
    public void delete(ProductosPk pk) throws ProductosDaoException;

    /** 
     * Deletes a single row in the PRODUCTOS table.
     */
    public boolean deleteAllTemp() throws ProductosDaoException;

    /** 
     * Deletes a single row in the PRODUCTOS table.
     */
    public boolean deleteTemp(PedidoProducto dto) throws ProductosDaoException;

    /** 
     * Deletes a single row in the PRODUCTOS table.
     */
    public boolean deleteIdProveedor(int idproveedor) throws ProductosDaoException;

    /** 
     * Returns all rows from the PRODUCTOS table that match the criteria 'ID_PRODUCTO = :idProducto'.
     */
    public Productos findByPrimaryKey(Integer idProducto) throws ProductosDaoException;

    /** 
     * Returns all rows from the PRODUCTOS table that match the criteria ''.
     */
    public List<Productos> findAll() throws ProductosDaoException;

    /** 
     * Returns all rows from the PRODUCTOS table that match the criteria ''.
     */
    public List<PedidoProducto> findAllTemp() throws ProductosDaoException;
    
    /** 
     * Returns all rows from the PRODUCTOS table that match the criteria ''.
     */
    public List<PedidoProducto> findTemp(String codigo, int cantidad, double utilidad) throws ProductosDaoException;

    /**
     * Obtiene todas las marcas asociadas a la tabla productos
     * @return List<String> con todas las marcas asociadas a la tabla productos
     * @throws ProductosDaoException  en caso de cualquier excepción 
     */
    public List<String> findAllMarcas() throws ProductosDaoException;

    /** 
     * Returns all rows from the PRODUCTOS table that match the criteria 'ID_PRODUCTO = :idProducto'.
     */
    public List<Productos> findWhereIdProductoEquals(Integer idProducto) throws ProductosDaoException;

    /** 
     * Returns all rows from the PRODUCTOS table that match the criteria 'ID_PROVEEDOR = :idProveedor'.
     */
    public List<Productos> findWhereIdProveedorEquals(Integer idProveedor) throws ProductosDaoException;

    /** 
     * Returns all rows from the PRODUCTOS table that match the criteria 'CODIGO = :codigo'.
     */
    public List<Productos> findWhereCodigoEquals(String codigo) throws ProductosDaoException;

    /** 
     * Returns all rows from the PRODUCTOS table that match the criteria 'CODIGO = :codigo'.
     */
    public List<Productos> findForSale(String codigo, String marca) throws ProductosDaoException;

    /** 
     * Returns all rows from the PRODUCTOS table that match the criteria 'CODIGO = :codigo'.
     */
    public List<Productos> findForSaleP(String codigo, String marca, String proveedor, String nombre) throws ProductosDaoException;

    /** 
     * Returns all rows from the PRODUCTOS table that match the criteria 'CODIGO = :codigo'.
     */
    public int findId(String codigo, String marca, Double precio) throws ProductosDaoException;

    /** 
     * Returns all rows from the PRODUCTOS table that match the criteria 'PRECIO = :precio'.
     */
    public List<Productos> findWherePrecioEquals(Double precio) throws ProductosDaoException;

    /** 
     * Returns all rows from the PRODUCTOS table that match the criteria 'FECHA_ALTA = :fechaAlta'.
     */
    public List<Productos> findWhereFechaAltaEquals(Date fechaAlta) throws ProductosDaoException;

    /** 
     * Returns all rows from the PRODUCTOS table that match the criteria 'MARCA = :marca'.
     */
    public List<Productos> findWhereMarcaEquals(String marca) throws ProductosDaoException;

    /** 
     * Returns the rows from the PRODUCTOS table that matches the specified primary-key value.
     */
    public Productos findByPrimaryKey(ProductosPk pk) throws ProductosDaoException;
}
