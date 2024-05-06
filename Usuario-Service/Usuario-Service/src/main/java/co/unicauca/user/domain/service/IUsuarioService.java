package co.unicauca.user.domain.service;

import java.util.List;

import co.unicauca.user.domain.entity.Usuario;
import co.unicauca.user.presentation.rest.exceptions.ResourceNotFoundException;
import co.unicauca.user.presentation.rest.exceptions.UsuarioDomainException;

/**
 * Interfaz de operaciones de la bd de productos
 * 
 * @author wpantoja, ahurtado
 *
 */

public interface IUsuarioService {
	public List<Usuario> findAll();

	public Usuario findById(Long id) throws ResourceNotFoundException;

	public Usuario create(Usuario usuario) throws UsuarioDomainException;

	public Usuario update(Long id, Usuario usuario) throws UsuarioDomainException, ResourceNotFoundException;

	public void deleteById(Long id) throws ResourceNotFoundException;


}
