/**
 * @file IProductClientRest.java
 * @brief Este archivo contiene la interfaz IProductClientRest, la cual se encarga de definir la comunicación con el servicio web de productos utilizando Feign.
 */

package co.unicauca.order.domain.service;

import co.unicauca.order.domain.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @interface IProductClientRest
 * @brief Esta interfaz define la comunicación con el servicio web de productos utilizando Feign, una forma declarativa de comunicar microservicios.
 * @author Libardo, Julio
 * @date Fecha de creación: [fecha]
 */

@FeignClient(name = "product-service", url = "localhost:8001")
public interface IProductClientRest {

	/**
	 * @brief Lista todos los productos disponibles.
	 * @return Lista de productos.
	 */
	@GetMapping("/products/")
	public List<Product> list();

	/**
	 * @brief Obtiene los detalles de un producto específico.
	 * @param id Identificador del producto.
	 * @return Detalles del producto.
	 */
	@GetMapping("/products/{id}")
	public Product detail(@PathVariable Long id);

	/**
	 * @brief Crea un nuevo producto.
	 * @param product Producto a crear.
	 * @return Producto creado.
	 */
	@PostMapping("/products")
	public Product create(@RequestBody Product product);

	/**
	 * @brief Actualiza un producto existente.
	 * @param product Producto actualizado.
	 * @param id Identificador del producto a actualizar.
	 * @return Producto actualizado.
	 */
	@PutMapping("/products/{id}")
	public Product update(@RequestBody Product product, @PathVariable Long id);

	/**
	 * @brief Elimina un producto.
	 * @param id Identificador del producto a eliminar.
	 */
	@DeleteMapping("/eliminar/{id}")
	public void delete(@PathVariable Long id);
}

