package co.unicauca.order.domain.service;

/**
 * Códigos de error. Lo usa ProductImplService para hacer validaciones de
 * dominio
 * 
 * @author wpantoja, ahurtado
 *
 */
public enum EnumErrorCodes {
	EMPTY_FIELD, INVALID_NUMBER, INVALID_TODO_NUMBER,INVALID_DESCRIPTION,EMPTY_OR_NULL_FIELD
	,INVALID_STOCK,INVALID_CATEGORY, INVALID_LENGTH,INVALID_ID;
}