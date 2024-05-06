/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.market.service;

import co.com.hyunseda.market.entities.Category;
import co.com.hyunseda.market.access.ICategoryRepository;
import java.util.List;

/**
 * Servicio para operaciones CRUD relacionadas con las categorías de productos.
 */
/**
 *
 * @author usuario
 */
/**
 * @brief Clase que representa un servicio de gestión de categorías.
 */
public class CategoryService {
    
    // Atributos
    private ICategoryRepository repository; ///< Repositorio de categorías.

    /**
     * @brief Constructor de la clase CategoryService.
     * @param repository Repositorio de categorías.
     */
    public CategoryService(ICategoryRepository repository) { 
        this.repository = repository;
    }

    /**
     * @brief Método para encontrar todas las categorías.
     * @return Una lista de todas las categorías.
     */
    public List<Category> findAllCategories() {
        return repository.findAll();
    }
    
}
