package co.unicauca.product.domain.service;

import co.unicauca.product.domain.entity.Category;
import co.unicauca.product.domain.entity.Product;
import co.unicauca.product.presentation.rest.exceptions.ProductDomainException;
import co.unicauca.product.presentation.rest.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ICategoryService {
    public List<Category> findAll();

    public Category findById(Long id) throws ResourceNotFoundException;

    public Category create(Category category) throws ProductDomainException;

    public Category update(Long id, Category category) throws ProductDomainException, ResourceNotFoundException;

    public void deleteById(Long id) throws ResourceNotFoundException;
}
