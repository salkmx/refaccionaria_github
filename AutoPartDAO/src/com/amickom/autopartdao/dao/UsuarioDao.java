package com.amickom.autopartdao.dao;

import com.amickom.autopartdao.dto.Usuario;
import com.amickom.autopartdao.dto.UsuarioPk;
import com.amickom.autopartdao.exceptions.UsuarioDaoException;
import java.util.Date;
import java.util.List;

public interface UsuarioDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return UsuarioPk
	 */
	public UsuarioPk insert(Usuario dto);

	/** 
	 * Updates a single row in the USUARIO table.
	 */
	public void update(UsuarioPk pk, Usuario dto) throws UsuarioDaoException;

	/** 
	 * Deletes a single row in the USUARIO table.
	 */
	public void delete(UsuarioPk pk) throws UsuarioDaoException;

	/** 
	 * Returns all rows from the USUARIO table that match the criteria 'ID = :id'.
	 */
	public Usuario findByPrimaryKey(Integer id) throws UsuarioDaoException;

	/** 
	 * Returns all rows from the USUARIO table that match the criteria ''.
	 */
	public List<Usuario> findAll() throws UsuarioDaoException;

	/** 
	 * Returns all rows from the USUARIO table that match the criteria 'ID = :id'.
	 */
	public List<Usuario> findWhereIdEquals(Integer id) throws UsuarioDaoException;

	/** 
	 * Returns all rows from the USUARIO table that match the criteria 'CLAVE = :clave'.
	 */
	public List<Usuario> findWhereClaveEquals(String clave) throws UsuarioDaoException;

	/** 
	 * Returns all rows from the USUARIO table that match the criteria 'PASSWORD = :password'.
	 */
	public List<Usuario> findWherePasswordEquals(String password) throws UsuarioDaoException;

	/** 
	 * Returns all rows from the USUARIO table that match the criteria 'FECHA_ALTA = :fechaAlta'.
	 */
	public List<Usuario> findWhereFechaAltaEquals(Date fechaAlta) throws UsuarioDaoException;

	/** 
	 * Returns all rows from the USUARIO table that match the criteria 'ROL = :rol'.
	 */
	public List<Usuario> findWhereRolEquals(String rol) throws UsuarioDaoException;

	/** 
	 * Returns the rows from the USUARIO table that matches the specified primary-key value.
	 */
	public Usuario findByPrimaryKey(UsuarioPk pk) throws UsuarioDaoException;
        
        /**
         * Verifica las credenciales de seguridad del usuario
         * @param clave usuario con el que se realiza el login en el sistema
         * @param password password del usuario a realizar el login
         * @return boolean true si la scredenciales son verificadas false en 
         * caso contrario
         * @throws UsuarioDaoException en caso de cualquier excepción
         */
        public boolean login(String clave, String password) throws UsuarioDaoException;

}
