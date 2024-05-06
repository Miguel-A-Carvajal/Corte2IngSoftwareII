package co.unicauca.user.presentation.rest;

import java.util.List;

import co.unicauca.user.domain.entity.Usuario;
import co.unicauca.user.presentation.rest.exceptions.UsuarioDomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import co.unicauca.user.domain.service.IUsuarioService;
import co.unicauca.user.presentation.rest.exceptions.ResourceNotFoundException;

/**
 * Servicios web de productos
 * 
 * @author wpantoja, ahurtado
 *
 */
@RestController
@RequestMapping("usuarios")
public class UsuarioController {
	@Autowired
	private IUsuarioService UsuarioService;

	/**
	 * Listar todos
	 * 
	 * @return listado de productos en json
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Usuario> findAll() {
		return (List<Usuario>) UsuarioService.findAll();
	}

	/**
	 * Listar un producto por id
	 * 
	 * @param usuario_id identificador
	 * @return Producto en formato json
	 * @throws Exception
	 */
	@RequestMapping(value = "{usuario_id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Usuario findById(@PathVariable Long usuario_id) throws ResourceNotFoundException {

		Usuario usuario = UsuarioService.findById(usuario_id);
		return usuario;
	}

	/**
	 * Crear un producto
	 * 
	 * @param usuario producto
	 * @return producto creado
	 */

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Usuario create(@RequestBody Usuario usuario) throws UsuarioDomainException {
		return UsuarioService.create(usuario);
	}

	/**
	 * Editar Este método actualiza los datos de un usuario específico en el servicio.
	 * 
	 * @param usuario usuario a editar
	 * @param usuario_id      identificador del producto
	 * @return usuario editado
	 * @throws ResourceNotFoundException recurso no encontrado
	 * @throws Exception                 Id no encontrado
	 */
	@RequestMapping(value = "{usuario_id}", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Long usuario_id)
			throws UsuarioDomainException, ResourceNotFoundException {
		return UsuarioService.update(usuario_id, usuario);
	}

	/**
	 * Eliminar
	 * 
	 * @param usuario_id id del usuario
	 * @throws ResourceNotFoundException id no encontrado
	 */

	@RequestMapping(value = "{usuario_id}", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long usuario_id) throws ResourceNotFoundException {
		UsuarioService.deleteById(usuario_id);
	}
}