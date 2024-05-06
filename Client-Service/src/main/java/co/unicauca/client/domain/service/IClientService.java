package co.unicauca.client.domain.service;

import java.util.List;

import co.unicauca.client.domain.entity.Client;
import co.unicauca.client.presentation.rest.exceptions.ResourceNotFoundException;
import co.unicauca.client.presentation.rest.exceptions.ClientDomainException;

/**
 * Interfaz de operaciones de la bd de client
 * 
 * @author wpantoja, ahurtado
 *
 */

public interface IClientService {
	public List<Client> findAll();

	public Client findById(Long id) throws ResourceNotFoundException;

	public Client create(Client client) throws ClientDomainException;

	public Client update(Long id, Client client) throws ClientDomainException, ResourceNotFoundException;

	public void deleteById(Long id) throws ResourceNotFoundException;

}
