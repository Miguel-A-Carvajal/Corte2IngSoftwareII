/**
 * @file EmbarcadoState.java
 * @brief Define la clase EmbarcadoState que representa el estado "Embarcado" de una orden.
 */

package co.unicauca.order.domain.entity;

/**
 * @class EmbarcadoState
 * @brief Representa el estado "Embarcado" de una orden en el sistema.
 * @details Esta clase extiende la clase OrderState y define el comportamiento específico
 * del estado "Embarcado".
 */
public class EmbarcadoState extends OrderState{

    /**
     * @brief Constructor de la clase EmbarcadoState.
     * @param order La orden asociada al estado "Embarcado".
     */
    public EmbarcadoState(Order order) {
        super(order);
    }

    /**
     * @brief Constructor de la clase EmbarcadoState.
     * @param source El estado fuente del cual se está copiando la instancia.
     */
    public EmbarcadoState(OrderState source) {
        super(source);
    }

    public Order siguiente() {
        getContext().setState("Recibido");
        return getContext();
    }

    public Order cancelar() {
        getContext().setState("Cancelado");
        return getContext();
    }
}

