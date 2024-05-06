package co.unicauca.client.domain.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.unicauca.client.domain.entity.Client;
import co.unicauca.client.presentation.rest.exceptions.ClientDomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.unicauca.client.access.dao.IClientDao;
import co.unicauca.client.presentation.rest.exceptions.ResourceNotFoundException;
import co.unicauca.client.presentation.rest.exceptions.ClientError;

/**
 * Implementación de la Interfaz IClientService
 * 
 * @author wpantoja, ahurtado
 *
 */

@Service
public class ClientImplService implements IClientService {
	/**
	 * Inyección de Cliente Dao
	 */
	@Autowired
	private IClientDao clientDao;

	/**
	 * Servicio para buscar todos los Cliente
	 * 
	 * @return Listado de Cliente
	 */
	@Override
	@Transactional(readOnly = true) // Para que esté sincronizada con la bd
	public List<Client> findAll() {
		return (List<Client>) clientDao.findAll();
	}

	/**
	 * Busca un Cliente por su Id
	 * 
	 * @param id identificador del Cliente
	 * @return objeto de tipo Cliente
	 */
	@Override // Para que esté sincronizada con la bd
	public Client findById(Long id) throws ResourceNotFoundException {
		Client cli = clientDao.findById(id).orElse(null);
		if (cli == null) {
			throw new ResourceNotFoundException();
		}
		return cli;
	}

	/**
	 * Crea un nuevo Cliente
	 * 
	 * @param client Cliente a crear en la bd
	 * @return Cliente creado
	 */
	@Override
	@Transactional
	public Client create(Client client) throws ClientDomainException {
		List<ClientError> errors = validateDomain(client);

		if (!errors.isEmpty()) {
			throw new ClientDomainException(errors);
		}

		if (client.getCreateAt() == null) {
			client.setCreateAt(new Date());
		}

		return clientDao.save(client);
	}

	/**
	 * Modifica o edita un Cliente
	 * 
	 * @param id,     identificador del Cliente a modificar
	 * @param client Cliente con los datos a editar
	 * @return Cliente modificado
	 */
	@Override
	@Transactional
	public Client update(Long id, Client client) throws ClientDomainException, ResourceNotFoundException {
		Client cli = this.findById(id);
		if (cli == null) {
			throw new ResourceNotFoundException();
		}

		List<ClientError> errors = validateDomain(client);

		if (!errors.isEmpty()) {
			throw new ClientDomainException(errors);
		}

		cli.setNombre(client.getNombre());

		return clientDao.save(cli);
	}

	/**
	 * Aplica validaciones o reglas del dominio para un Cliente. Antes de ser
	 * agregado o modificado.
	 * 
	 * @param client producto a validad
	 * @return lista de errores de validación
	 */

	private List<ClientError> validateDomain(Client client) {
		List<ClientError> errors = new ArrayList<>();

		if (client.getNombre() == null || client.getNombre().isBlank()) {
			errors.add(new ClientError(EnumErrorCodes.EMPTY_FIELD, "name", "El nombre del producto es obligatorio"));
		}

		return errors;

	}

	/**
	 * Eliminar Cliente por su id
	 * 
	 * @param id identificador del Cliente a eliminar
	 */
	@Override
	@Transactional
	public void deleteById(Long id) throws ResourceNotFoundException {
		Client prod = this.findById(id);
		if (prod == null) {
			throw new ResourceNotFoundException();
		}
		clientDao.deleteById(id);
	}

}
