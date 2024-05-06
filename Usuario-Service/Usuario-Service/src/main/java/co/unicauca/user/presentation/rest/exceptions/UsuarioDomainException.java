package co.unicauca.user.presentation.rest.exceptions;

import java.util.List;

/**
 * Lista de errores del dominio para un producto
 *
 * @author wpantoja, ahurtado
 *
 */
public class UsuarioDomainException extends Exception {
    /**
     * Listado de errores
     */
    public final List<UsuarioError> errors;

    public UsuarioDomainException(List<UsuarioError> errors) {
        this.errors = errors;
    }
}