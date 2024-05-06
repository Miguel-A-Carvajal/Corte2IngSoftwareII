package co.unicauca.order.domain.service;

import co.unicauca.order.domain.entity.Order;
import co.unicauca.order.rest.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define los servicios disponibles para manipular órdenes.
 */
public interface IOrderService {
    /**
     * Busca y retorna todas las órdenes existentes.
     * @return Una lista de órdenes
     */
    public List<Order> findAll();

    /**
     * Busca y retorna una orden por su identificador único.
     * @param id El identificador único de la orden a buscar
     * @return La orden encontrada, o un valor vacío si no se encuentra ninguna orden con el ID proporcionado
     */
    public Optional<Order> findById(Long id);

    /**
     * Crea una nueva orden.
     * @param order La orden a ser creada
     * @return La orden creada
     */
    public Order create(Order order);

    /**
     * Actualiza una orden existente.
     * @param order La orden con los datos actualizados
     * @param id El identificador único de la orden a actualizar
     * @return La orden actualizada
     */
    public Order update(Order order, Long id);

    /**
     * Elimina una orden por su identificador único.
     * @param id El identificador único de la orden a eliminar
     */
    public void delete(Long id);

    /**
     * Elimina una orden por su identificador único.
     * @param id El identificador único de la orden a eliminar
     */
    public Order actualizarEstado(Long id,String estado) throws ResourceNotFoundException;

}

