/**
 * @file ItemController.java
 * @brief Contiene la definición del controlador REST para la gestión de ítems de orden.
 */

package co.unicauca.order.rest;

import co.unicauca.order.domain.entity.Item;
import co.unicauca.order.domain.entity.Product;
import co.unicauca.order.domain.service.IItemService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de ítems de orden.
 */
@RestController
@RequestMapping("/items")
public class ItemController {
	@Autowired
	private IItemService itemService;

	/**
	 * Recupera todos los ítems.
	 * @return Lista de ítems
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Item> findAll() {
		return itemService.findAll();
	}

	/**
	 * Busca un ítem por su identificador.
	 * @param id Identificador del ítem
	 * @param amount Cantidad del ítem
	 * @return El ítem encontrado
	 */
	@GetMapping("/{id}/amount/{amount}")
	public Item findById(@PathVariable Long id, @PathVariable Integer amount) {
		return itemService.findById(id, amount);
	}

	/**
	 * Actualiza un ítem existente.
	 * @param product El producto actualizado
	 * @param id Identificador del ítem a actualizar
	 * @return El producto actualizado
	 */
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Product update(@RequestBody Product product, @PathVariable Long id) {
		return itemService.update(product, id);
	}

	/**
	 * Elimina un ítem por su identificador.
	 * @param id Identificador del ítem a eliminar
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		itemService.delete(id);
	}
}

