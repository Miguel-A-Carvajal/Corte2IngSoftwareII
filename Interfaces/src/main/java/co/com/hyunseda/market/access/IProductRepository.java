/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.hyunseda.market.access;

import co.com.hyunseda.market.entities.Product;
import java.util.List;

/**
 *
 * @author JUAN CARLOS MELO
 */

/**
 * @brief Interfaz que define las operaciones del repositorio de productos.
 */
public interface IProductRepository {

    /**
     * @brief Método para guardar un nuevo producto.
     * @param newProduct El nuevo producto a guardar.
     * @return true si se guarda correctamente, false si no.
     */
    public boolean save(Product newProduct);

    /**
     * @brief Método para encontrar todos los productos.
     * @return Una lista de todos los productos.
     */
    public List<Product> findAll();

    /**
     * @brief Método para encontrar un producto por su ID.
     * @param id El ID del producto a buscar.
     * @return El producto encontrado.
     */
    public Product findById(Long id);

    /**
     * @brief Método para encontrar productos por categoría.
     * @param categoryId El ID de la categoría de productos.
     * @return Una lista de productos pertenecientes a la categoría especificada.
     */
    public List<Product> findByCategory(Long categoryId);
    
    
    public boolean edit(Long id, Product product);
}
