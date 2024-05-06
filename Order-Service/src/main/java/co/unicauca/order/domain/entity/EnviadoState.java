/**
 * @file EnviadoState.java
 * @brief Define la clase EnviadoState que representa el estado de un pedido cuando ha sido enviado.
 * @version 1.0
 */

package co.unicauca.order.domain.entity;

/**
 * @class EnviadoState
 * @brief Representa el estado de un pedido cuando ha sido enviado.
 * @details Esta clase hereda de OrderState y define el comportamiento específico para el estado "Enviado".
 */
public class EnviadoState extends OrderState {

    /**
     * @brief Constructor de la clase EnviadoState.
     * @param order Objeto Order al que se asociará este estado.
     */
    public EnviadoState(Order order) {
        super(order);
    }

    /**
     * @brief Constructor de la clase EnviadoState a partir de otro estado.
     * @param source Estado del cual se copiarán los atributos.
     */
    public EnviadoState(OrderState source) {
        super(source);
    }

    public Order siguiente() {
        getContext().setState("Embarcado");
        return getContext();
    }

    public Order cancelar() {
        getContext().setState("Cancelado");
        return getContext();
    }
}

