/**
 * @file OrderService.java
 * @brief Contiene la implementación de los servicios relacionados con las órdenes de pedido.
 */

package co.unicauca.order.domain.service;

import co.unicauca.order.acces.dao.IItemDao;
import co.unicauca.order.acces.dao.IOrderDao;
import co.unicauca.order.acces.dao.IProductDao;
import co.unicauca.order.domain.entity.Order;
import co.unicauca.order.domain.entity.OrderState;
import co.unicauca.order.rest.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @class OrderService
 * @brief Clase que implementa los servicios relacionados con las órdenes de pedido.
 */
@Service
public class OrderService implements IOrderService{

    @Autowired
    private IOrderDao orderDao;
    @Autowired
    private IItemDao itemDao;
    @Autowired
    private IProductDao productDao;


    /**
     * @brief Método para encontrar todas las órdenes de pedido.
     * @return Lista de todas las órdenes de pedido encontradas.
     */
    @Override
    public List<Order> findAll() {
        return (List<Order>) orderDao.findAll();
    }

    /**
     * @brief Método para encontrar una orden de pedido por su ID.
     * @param id ID de la orden de pedido a buscar.
     * @return Objeto Optional que puede contener la orden de pedido encontrada (si existe).
     */
    @Override
    public Optional<Order> findById(Long id) {
        Optional<Order> ord = orderDao.findById(id);
        return ord;
    }

    /**
     * @brief Método para crear una nueva orden de pedido.
     * @param order Objeto Order que representa la orden de pedido a crear.
     * @return La orden de pedido creada.
     */
    @Override
    public Order create(Order order) {
        order.setState("NoEnviado");
        return orderDao.save(order);
    }

    /**
     * @brief Método para actualizar una orden de pedido existente.
     * @param order Objeto Order que representa la orden de pedido a actualizar.
     * @param id ID de la orden de pedido a actualizar.
     * @return La orden de pedido actualizada.
     */
    @Override
    public Order update(Order order, Long id) {
        return null; // Actualmente no implementado
    }

    /**
     * @brief Método para eliminar una orden de pedido por su ID.
     * @param id ID de la orden de pedido a eliminar.
     */
    @Override
    public void delete(Long id) {
        // Actualmente no implementado
    }

    @Override
    public Order actualizarEstado(Long id, String estado) throws ResourceNotFoundException {
        Order ord = this.findById(id).orElse(null);
        if (ord == null) {
            throw new ResourceNotFoundException();
        }
        FabricaState state = new FabricaState();
        OrderState aux = state.crearState(ord.getState(),ord);
        if(estado.equals("siguiente")){
            ord=aux.siguiente();
        }else{
            ord=aux.cancelar();
        }

        return orderDao.save(ord);
    }
}

