/**
 * @file ErrorsPayload.java
 * @brief Define la clase ErrorsPayload para manejar errores en la capa de presentación REST.
 */

package co.unicauca.user.presentation.rest.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * @class ErrorsPayload
 * @brief Clase utilizada por GlobalDefaultExceptionHandler para manejar los errores.
 * Esta clase encapsula una lista de errores en formato JSON.
 * @author wpantoja, ahurtado
 * @date Fecha actual
 */
public class ErrorsPayload {

	/**
	 * @brief Lista de errores en formato JSON.
	 */
	public final List<ErrorJSON> errors;

	/**
	 * @brief Constructor de ErrorsPayload.
	 * @param applicationErrors Lista de errores de la aplicación.
	 */
	public ErrorsPayload(List<UsuarioError> applicationErrors) {
		this.errors = new ArrayList<>();
		applicationErrors.forEach(applicationError -> errors.add(fromApplicationError(applicationError)));
	}

	/**
	 * @brief Convierte un error de la aplicación a un objeto ErrorJSON.
	 * @param error Error de la aplicación a convertir.
	 * @return Objeto ErrorJSON correspondiente al error de la aplicación.
	 */
	private ErrorJSON fromApplicationError(UsuarioError error) {
		return new ErrorJSON(error.code, error.field, error.description);
	}
}

