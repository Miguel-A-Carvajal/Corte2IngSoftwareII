package co.com.hyunseda.market.access;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */


import co.com.hyunseda.market.entities.Order;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author JUAN CARLOS MELO
 */
public interface IOrderReposity {
    public List<Order> findAll();
    public Optional<Order> findById(Long id);
    public boolean create(Order order);
    public void delete(Long id);
    public Order actualizarEstado(Long id,String estado);
}
