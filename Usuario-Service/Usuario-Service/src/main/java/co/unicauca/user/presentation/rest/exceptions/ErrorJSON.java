/**
 * @file ErrorJSON.java
 * @brief Definición de la clase ErrorJSON.
 */

package co.unicauca.user.presentation.rest.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;

import co.unicauca.user.domain.service.EnumErrorCodes;

/**
 * @brief Clase que maneja los errores en formato JSON.
 * Esta clase es utilizada por ErrorsPayload.
 * @author wpantoja, ahurtado
 * @date Fecha de creación/modificación
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorJSON {

	/**
	 * @brief Código del error.
	 */
	public final EnumErrorCodes code;

	/**
	 * @brief Campo relacionado al error.
	 */
	public final String field;

	/**
	 * @brief Mensaje descriptivo del error.
	 */
	public final String message;

	/**
	 * @brief Constructor de la clase ErrorJSON.
	 * @param code Código del error.
	 * @param field Campo relacionado al error.
	 * @param message Mensaje descriptivo del error.
	 */
	public ErrorJSON(EnumErrorCodes code, String field, String message) {
		this.code = code;
		this.field = field;
		this.message = message;
	}
}
