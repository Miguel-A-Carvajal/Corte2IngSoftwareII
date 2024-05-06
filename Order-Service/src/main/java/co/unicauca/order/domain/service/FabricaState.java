package co.unicauca.order.domain.service;

import co.unicauca.order.domain.entity.*;

public class FabricaState implements IFabricaState {

    @Override
    public OrderState crearState(String tipo, Order order) {
        switch (tipo) {
            case "NoEnviado":
                return new NoEnviadoState(order);
            case "Procesado":
                return new ProcesadoState(order);
            case "Enviado":
                return new EnviadoState(order);
            case "Embarcado":
                return new EmbarcadoState(order);
            case "Recibido":
                return new RecibidoState(order);
            case "Cancelado":
                return new CanceladoState(order);
            default:
                throw new IllegalArgumentException("Tipo de producto desconocido: " + tipo);
        }
    }
}
