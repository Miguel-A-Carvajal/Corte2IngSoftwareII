package co.unicauca.user.domain.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import co.unicauca.user.presentation.rest.exceptions.UsuarioDomainException;
import co.unicauca.user.presentation.rest.exceptions.UsuarioError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.unicauca.user.access.dao.IUsuarioDao;
import co.unicauca.user.domain.entity.Usuario;
import co.unicauca.user.presentation.rest.exceptions.ResourceNotFoundException;

/**
 * Implementación de la Interfaz IUsuarioService
 * 
 * @author wpantoja, ahurtado
 *
 */

@Service
public class UsuarioImplService implements IUsuarioService {
	/**
	 * Inyección de producto Dao
	 */
	@Autowired
	private IUsuarioDao UsuarioDao;


	/**
	 * Servicio para buscar todos los productos
	 * 
	 * @return Listado de productos
	 */
	@Override
	@Transactional(readOnly = true) // Para que esté sincronizada con la bd
	public List<Usuario> findAll() {
		return (List<Usuario>) UsuarioDao.findAll();
	}

	/**
	 * Busca un producto por su Id
	 * 
	 * @param usuario_id identificador del producto
	 * @return objeto de tipo producto
	 */
	@Override // Para que esté sincronizada con la bd
	public Usuario findById(Long usuario_id) throws ResourceNotFoundException {
		Usuario prod = UsuarioDao.findById(usuario_id).orElse(null);
		if (prod == null) {
			throw new ResourceNotFoundException();

		}
		return prod;

	}

	/**
	 * Crea un nuevo producto
	 * 
	 * @param usuario producto a crear en la bd
	 * @return Producto creado
	 */
	@Override
	@Transactional
	public Usuario create(Usuario usuario) throws UsuarioDomainException {

        List<UsuarioError> errors = validateDomain(usuario);
		if (!errors.isEmpty()) {
		throw new UsuarioDomainException(errors);
	}

		if (usuario.getCreateAt() == null) {
		usuario.setCreateAt(new Date());
	}

		return UsuarioDao.save(usuario);
}

	/**
	 * Modifica o edita un producto
	 * 
	 * @param usuario_id,     identificador del producto a modificar
	 * @param usuario producto con los datos a editar
	 * @return Producto modificado
	 */
	@Override
	@Transactional
	public Usuario update(Long usuario_id, Usuario usuario) throws UsuarioDomainException, ResourceNotFoundException {
		Usuario prod = this.findById(usuario_id);
		if (prod == null) {
			throw new ResourceNotFoundException();
		}

		List<UsuarioError> errors = validateDomain(usuario);

		if (!errors.isEmpty()) {
			throw new UsuarioDomainException(errors);
		}

		prod.setName(usuario.getName());

		return UsuarioDao.save(prod);
	}

	/**
	 * Aplica validaciones o reglas del dominio para un producto. Antes de ser
	 * agregado o modificado.
	 * 
	 * @param usuario producto a validad
	 * @return lista de errores de validación
	 */

	private List<UsuarioError> validateDomain(Usuario usuario) {
		List<UsuarioError> errors = new ArrayList<>();

		if (usuario.getName() == null || usuario.getName().isBlank()) {
			errors.add(new UsuarioError(EnumErrorCodes.EMPTY_FIELD, "name", "El nombre del producto es obligatorio"));
		}

		return errors;
	}

	/**
	 * Eliminar producto por su id
	 * 
	 * @param product_id identificador del producto a eliminar
	 */
	@Override
	@Transactional
	public void deleteById(Long product_id) throws ResourceNotFoundException {
		Usuario prod = this.findById(product_id);
		if (prod == null) {
			throw new ResourceNotFoundException();
		}
		UsuarioDao.deleteById(product_id);
	}

}
