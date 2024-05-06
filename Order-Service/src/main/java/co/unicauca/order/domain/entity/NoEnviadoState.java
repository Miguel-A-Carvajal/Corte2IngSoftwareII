/**
 * @file
 * @brief Contiene la definición de la clase NoEnviadoState.
 */

package co.unicauca.order.domain.entity;

/**
 * @class NoEnviadoState
 * @brief Clase que representa el estado de una orden que no ha sido enviada.
 *
 * Esta clase hereda de OrderState y representa el estado de una orden que aún no ha sido enviada.
 */
public class NoEnviadoState extends OrderState {

    /**
     * @brief Constructor de la clase NoEnviadoState.
     * @param order La orden asociada al estado.
     */
    public NoEnviadoState(Order order) {
        super(order);
    }

    /**
     * @brief Constructor de copia de la clase NoEnviadoState.
     * @param source El estado a copiar.
     */
    public NoEnviadoState(OrderState source) {
        super(source);
    }

    public Order siguiente() {
        getContext().setState("Procesado");
        return getContext();
    }

    public Order cancelar() {
        getContext().setState("Cancelado");
        return getContext();
    }
}

