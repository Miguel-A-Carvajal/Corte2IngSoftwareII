package co.unicauca.client.presentation.rest.exceptions;

import co.unicauca.client.domain.service.EnumErrorCodes;

/**
 * Error de un cliente
 * 
 * @author wpantoja, ahurtado
 *
 */
public class ClientError {
	/**
	 * Codigo del error
	 */
	public final EnumErrorCodes code;
	/**
	 * Campo del error
	 */
	public final String field;
	/**
	 * Descripción del error
	 */
	public final String description;

	public ClientError(EnumErrorCodes code, String field, String description) {
		this.code = code;
		this.field = field;
		this.description = description;
	}
}
