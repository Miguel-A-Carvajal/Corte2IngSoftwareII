/**
 * @file OrderState.java
 * @brief Archivo que contiene la definición de la clase OrderState.
 */

package co.unicauca.order.domain.entity;

/**
 * @class OrderState
 * @brief Clase que representa el estado de una orden.
 */
public class OrderState {
    private Order context; /**< Contexto de la orden. */

    /**
     * @brief Constructor de la clase OrderState.
     * @param account La orden asociada al estado.
     */
    public OrderState(Order account) {
        setContext(account);
    }

    /**
     * @brief Obtiene el contexto de la orden.
     * @return El contexto de la orden.
     */
    public Order getContext() {
        return context;
    }

    /**
     * @brief Establece el contexto de la orden.
     * @param newOrder La nueva orden a establecer como contexto.
     */
    public void setContext(Order newOrder) {
        context = newOrder;
    }


    /**
     * @brief Constructor de copia de la clase OrderState.
     * @param source El estado a copiar.
     */
    public OrderState(OrderState source) {
        setContext(source.getContext());
    }

    /**
     * @brief Obtiene el estado inicial de una orden.
     * @param order La orden para la que se obtendrá el estado inicial.
     * @return El estado inicial de la orden.
     */
    public static OrderState InitialState(Order order) {
        return new NoEnviadoState(order);
    }

    /**
     * @brief Método para avanzar al siguiente estado de la orden (depósito).
     * @return El siguiente estado de la orden.
     */
    public Order siguiente() {
        return getContext();
    }

    /**
     * @brief Método para cancelar la orden (retiro).
     * @return El estado actual de la orden después de la cancelación.
     */
    public Order cancelar() {
        return getContext();
    }
}

