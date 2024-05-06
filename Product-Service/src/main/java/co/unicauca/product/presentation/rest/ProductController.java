package co.unicauca.product.presentation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import co.unicauca.product.domain.entity.Product;
import co.unicauca.product.domain.service.IProductService;
import co.unicauca.product.presentation.rest.exceptions.ResourceNotFoundException;
import co.unicauca.product.presentation.rest.exceptions.ProductDomainException;

/**
 * Servicios web de productos
 * 
 * @author wpantoja, ahurtado
 *
 */
@RestController
@RequestMapping("products")
public class ProductController {
	@Autowired
	private IProductService productService;

	/**
	 * Listar todos
	 * 
	 * @return listado de productos en json
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Product> findAll() {
		return (List<Product>) productService.findAll();
	}

	/**
	 * Listar un producto por id
	 * 
	 * @param product_id identificador
	 * @return Producto en formato json
	 * @throws Exception
	 */
	@RequestMapping(value = "{product_id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Product findById(@PathVariable Long product_id) throws ResourceNotFoundException {

		Product product = productService.findById(product_id);
		return product;
	}

	/**
	 * Crear un producto
	 * 
	 * @param product producto
	 * @return producto creado
	 */

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Product create(@RequestBody Product product) throws ProductDomainException {
		return productService.create(product);
	}

	/**
	 * Editar
	 * 
	 * @param product Producto a editar
	 * @param product_id      identificador del producto
	 * @return producto editado
	 * @throws ResourceNotFoundException recurso no encontrado
	 * @throws Exception                 Id no encontrado
	 */
	@RequestMapping(value = "{product_id}", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody
	public Product update(@RequestBody Product product, @PathVariable Long product_id)
			throws ProductDomainException, ResourceNotFoundException {
		return productService.update(product_id, product);
	}

	/**
	 * Eliminar
	 * 
	 * @param product_id id del producto
	 * @throws ResourceNotFoundException id no encontrado
	 */

	@RequestMapping(value = "{product_id}", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long product_id) throws ResourceNotFoundException {
		productService.deleteById(product_id);
	}

	/**
	 * Buscar productos por ID de categoría
	 *
	 * @param categoryId ID de la categoría
	 * @return Lista de productos en formato JSON
	 */
	@GetMapping("/category/{categoryId}")
	public List<Product> findProductsByCategory(@PathVariable Long categoryId) {
		return productService.findByCategory(categoryId);
	}
}