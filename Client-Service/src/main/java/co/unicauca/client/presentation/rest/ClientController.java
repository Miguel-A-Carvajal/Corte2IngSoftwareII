package co.unicauca.client.presentation.rest;

import java.util.List;

import co.unicauca.client.domain.entity.Client;
import co.unicauca.client.domain.service.IClientService;
import co.unicauca.client.presentation.rest.exceptions.ClientDomainException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import co.unicauca.client.presentation.rest.exceptions.ResourceNotFoundException;

/**
 * Servicios web de productos
 * 
 * @author wpantoja, ahurtado
 *
 */
@RestController
@RequestMapping("products")
@Api(value="Microservicios de productos", description="Crud de productos")
public class ClientController {
	@Autowired
	private IClientService clientService;

	/**
	 * Listar todos
	 * 
	 * @return listado de productos en json
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	@ApiOperation(value="Lista todos los articulos")
	public List<Client> findAll() {
		return (List<Client>) clientService.findAll();
	}

	/**
	 * Listar un producto por id
	 * 
	 * @param id identificador
	 * @return Producto en formato json
	 * @throws Exception
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	@ApiOperation(value="Busca un producto por id")
	public Client findById(@ApiParam(value="Identificador del producto") @PathVariable Long id) throws ResourceNotFoundException {

		Client client = clientService.findById(id);
		return client;
	}

	/**
	 * Crear un producto
	 * 
	 * @param client producto
	 * @return producto creado
	 */

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Client create(@RequestBody Client client) throws ClientDomainException {
		return clientService.create(client);
	}

	/**
	 * Editar
	 * 
	 * @param client Producto a editar
	 * @param id      identificador del producto
	 * @return producto editado
	 * @throws ResourceNotFoundException recurso no encontrado
	 * @throws Exception                 Id no encontrado
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody
	public Client update(@RequestBody Client client, @PathVariable Long id)
			throws ClientDomainException, ResourceNotFoundException {
		return clientService.update(id, client);
	}

	/**
	 * Eliminar
	 * 
	 * @param id id del producto
	 * @throws ResourceNotFoundException id no encontrado
	 */

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) throws ResourceNotFoundException {
		clientService.deleteById(id);
	}
}