/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.market.service;

import co.com.hyunseda.market.access.IOrderReposity;
import co.com.hyunseda.market.entities.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author JUAN CARLOS MELO
 */
public class OrderService {

    private IOrderReposity reposity;

    public OrderService(IOrderReposity reposity) {
        this.reposity = reposity;
    }

    public boolean saveOrder(Order order) {
        boolean respuesta = reposity.create(order);
        /*
        if(respuesta){
            notifyAllObserves();
        }
         */
        return respuesta;
    }

    public List<Order> findAllOrder() {
        List<Order> orders = new ArrayList<>();
        orders = reposity.findAll();

        return orders;
    }

    public Optional<Order> findOrderById(Long id) {
        return reposity.findById(id);
    }

    public Order actualizarEstado(Long id, String estado) {


        Order respuesta = reposity.actualizarEstado(id, estado);
        /*
        if (respuesta) {
            notifyAllObserves();
        }
         */
        return respuesta;
    }

}
