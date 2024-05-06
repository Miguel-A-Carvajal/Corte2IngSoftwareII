/**
 * @file IItemService.java
 * @brief Este archivo contiene la interfaz IItemService, que define los métodos para operar con elementos de pedido.
 */

package co.unicauca.order.domain.service;

import co.unicauca.order.domain.entity.Item;
import co.unicauca.order.domain.entity.Order;
import co.unicauca.order.domain.entity.Product;

import java.util.List;

/**
 * @interface IItemService
 * @brief Interfaz que define los métodos para operar con elementos de pedido.
 */
public interface IItemService {
	/**
	 * @brief Recupera todos los elementos de pedido.
	 * @return Una lista de objetos Item que representan todos los elementos de pedido.
	 */
	public List<Item> findAll();

	/**
	 * @brief Busca un elemento de pedido por su identificador y cantidad.
	 * @param id Identificador del elemento de pedido.
	 * @param amount Cantidad del elemento de pedido.
	 * @return El objeto Item encontrado.
	 */
	public Item findById(Long id, Integer amount);

	/**
	 * @brief Crea uno o más elementos de pedido.
	 * @param items Lista de objetos Item a crear.
	 * @return true si la creación fue exitosa, false en caso contrario.
	 */
	public boolean create(List<Item> items);

	/**
	 * @brief Actualiza un producto asociado a un elemento de pedido.
	 * @param product Nuevo producto a asociar.
	 * @param id Identificador del elemento de pedido.
	 * @return El objeto Product actualizado.
	 */
	public Product update(Product product, Long id);

	/**
	 * @brief Elimina un elemento de pedido por su identificador.
	 * @param id Identificador del elemento de pedido a eliminar.
	 */
	public void delete(Long id);

	/**
	 * @brief Recupera todos los productos asociados a los elementos de pedido.
	 * @return Una lista de objetos Product que representan todos los productos asociados.
	 */
	public List<Product> findAllProducts();
}
