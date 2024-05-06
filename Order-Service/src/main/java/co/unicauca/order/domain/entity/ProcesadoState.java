/**
 * @file ProcesadoState.java
 * @brief Archivo que contiene la definición de la clase ProcesadoState.
 */

package co.unicauca.order.domain.entity;

/**
 * @class ProcesadoState
 * @brief Clase que representa el estado "Procesado" de una orden.
 *        Extiende de la clase OrderState.
 */
public class ProcesadoState extends OrderState {

    /**
     * @brief Constructor de la clase ProcesadoState.
     * @param order La orden asociada al estado.
     */
    public ProcesadoState(Order order) {
        super(order);
    }

    /**
     * @brief Constructor de copia de la clase ProcesadoState.
     * @param source El estado fuente a copiar.
     */
    public ProcesadoState(OrderState source) {
        super(source);
    }

    public Order siguiente() {
        getContext().setState("Enviado");
        return getContext();
    }

    public Order cancelar() {
        getContext().setState("Cancelado");
        return getContext();
    }
}

