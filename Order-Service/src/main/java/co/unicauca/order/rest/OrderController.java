/**
 * @file OrderController.java
 * @brief Controlador REST para manipular órdenes de pedidos.
 */

package co.unicauca.order.rest;

import co.unicauca.order.domain.entity.Item;
import co.unicauca.order.domain.entity.Order;
import co.unicauca.order.domain.entity.Product;
import co.unicauca.order.domain.service.IItemService;
import co.unicauca.order.domain.service.IOrderService;
import co.unicauca.order.rest.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @class OrderController
 * @brief Controlador REST para gestionar órdenes de pedidos.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IItemService itemService;

    @Autowired
    private IOrderService orderService;

    /**
     * @brief Crea una nueva orden de pedido.
     * @param order La orden de pedido a crear.
     * @return La orden de pedido creada, incluyendo los items asociados.
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    @Transactional
    public Optional<Order> create(@RequestBody Order order){
        // Persistir la orden para obtener su ID
        Order createdOrder = orderService.create(order);

        // Asociar los items a la orden con el ID obtenido
        List<Item> items = order.getItems();
        for (Item item : items) {
            item.setOrder(createdOrder);
        }

        // Persistir los items en la base de datos
        itemService.create(items);

        // Recuperar la orden completa (incluyendo los items) desde la base de datos
        return findById(createdOrder.getId());
    }

    /**
     * @brief Obtiene todas las órdenes de pedido.
     * @return Lista de todas las órdenes de pedido.
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Order> findAll() {
        return orderService.findAll();
    }

    /**
     * @brief Busca una orden de pedido por su ID.
     * @param id El ID de la orden de pedido a buscar.
     * @return La orden de pedido encontrada, si existe.
     */
    @GetMapping("/{id}")
    public Optional<Order> findById(@PathVariable Long id) {
        return orderService.findById(id);
    }

    /**
     * Actualiza un ítem existente.
     * @param id Identificador del ítem a actualizar
     * @return El producto actualizado
     */
    @PutMapping("/{id}/paso/{paso}")
    @ResponseStatus(HttpStatus.CREATED)
    public Order actualizarEstado(@PathVariable Long id,@PathVariable String paso) throws ResourceNotFoundException {
        return orderService.actualizarEstado(id, paso);
    }


}

