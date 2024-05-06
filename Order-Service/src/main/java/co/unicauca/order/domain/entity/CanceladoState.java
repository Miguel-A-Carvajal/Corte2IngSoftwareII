/**
 * @file CanceladoState.java
 * @brief Define el estado "Cancelado" de una orden en el dominio de la aplicación.
 */

package co.unicauca.order.domain.entity;

/**
 * @class CanceladoState
 * @brief Representa el estado "Cancelado" de una orden.
 * @details Este estado indica que la orden ha sido cancelada por el usuario.
 */
public class CanceladoState extends OrderState {

    /**
     * @brief Constructor de la clase CanceladoState.
     * @param order La orden asociada al estado.
     */
    public CanceladoState(Order order) {
        super(order);
    }

    /**
     * @brief Constructor de copia de la clase CanceladoState.
     * @param source Estado fuente del cual copiar la información.
     */
    public CanceladoState(OrderState source) {
        super(source);
    }

    /**
     * @brief Obtiene el siguiente estado de la orden.
     * @details En el estado cancelado, no hay un siguiente estado.
     * @return El mismo estado "Cancelado".
     */
    public Order siguiente() {
        getContext().setState("Cancelado");
        return getContext();
    }

    /**
     * @brief Intenta cancelar la orden.
     * @details En el estado cancelado, la orden ya está cancelada, por lo que este método
     * simplemente imprime un mensaje indicando que la orden ya ha sido cancelada.
     * @return El mismo estado "Cancelado".
     */
    public Order cancelar() {
        getContext().setState("Cancelado");
        return getContext();
    }

}
