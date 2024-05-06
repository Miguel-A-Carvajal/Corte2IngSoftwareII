package co.unicauca.client.presentation.rest.exceptions;

import java.util.List;

/**
 * Lista de errores del dominio para un cliente
 * 
 * @author wpantoja, ahurtado
 *
 */
public class ClientDomainException extends Exception {
	/**
	 * Listado de errores
	 */
	public final List<ClientError> errors;

	public ClientDomainException(List<ClientError> errors) {
		this.errors = errors;
	}
}
