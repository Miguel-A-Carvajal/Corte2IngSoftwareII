/**
 * @file RecibidoState.java
 * @brief Archivo que contiene la definición de la clase RecibidoState.
 */

package co.unicauca.order.domain.entity;

/**
 * @class RecibidoState
 * @brief Clase que representa el estado de "Recibido" de una orden.
 * Extiende de OrderState.
 */
public class RecibidoState extends OrderState  {

    /**
     * @brief Constructor de la clase RecibidoState.
     * @param order La orden asociada al estado.
     */
    public RecibidoState(Order order) {
        super(order);
    }

    /**
     * @brief Constructor de copia de la clase RecibidoState.
     * @param source El estado fuente a copiar.
     */
    public RecibidoState(OrderState source) {
        super(source);
    }

    public Order siguiente() {
        getContext().setState("Enviado");
        return getContext();
    }

    public Order cancelar() {
        getContext().setState("Enviado");
        return getContext();
    }
}

