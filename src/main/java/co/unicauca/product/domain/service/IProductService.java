package co.unicauca.product.domain.service;

import java.util.List;

import co.unicauca.product.domain.entity.Product;
import co.unicauca.product.presentation.rest.exceptions.ProductError;
import co.unicauca.product.presentation.rest.exceptions.ResourceNotFoundException;
import co.unicauca.product.presentation.rest.exceptions.ProductDomainException;

/**
 * Interfaz de operaciones de la bd de productos
 * 
 * @author wpantoja, ahurtado
 *
 */

public interface IProductService {
	public List<Product> findAll();

	public Product findById(Long id) throws ResourceNotFoundException;

	public Product create(Product product) throws ProductDomainException;

	public Product update(Long id, Product product) throws ProductDomainException, ResourceNotFoundException;

	public void deleteById(Long id) throws ResourceNotFoundException;

	List<ProductError> validateProduct(Product product);

	public List<Product> findByCategory(Long categoryId);

}
