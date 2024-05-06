package co.unicauca.order.domain.service;

import co.unicauca.order.domain.entity.Order;
import co.unicauca.order.domain.entity.OrderState;

public interface IFabricaState {
    OrderState crearState(String tipo, Order order);
}
