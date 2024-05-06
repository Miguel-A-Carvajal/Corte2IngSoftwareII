package co.com.hyunseda.market.entities;

import java.util.ArrayList;
import java.util.List;


/**
 * @brief Clase que representa una categoría de productos.
 */
public class Category {
    
    // Atributos
    private Long id_category; ///< ID de la categoría.
    private String name; ///< Nombre de la categoría.
    private List<Product> products = new ArrayList<>(); ///< Lista de productos asociados a la categoría.

    /**
     * @brief Constructor vacío de la clase Category.
     */
    public Category() {
    }

    /**
     * @brief Constructor de la clase Category.
     * @param id_category ID de la categoría.
     * @param name Nombre de la categoría.
     */
    public Category(Long id_category, String name) {
        this.id_category = id_category;
        this.name = name;
    }

    /**
     * @brief Método para obtener el ID de la categoría.
     * @return El ID de la categoría.
     */
    public Long getId_category() {
        return id_category;
    }

    /**
     * @brief Método para establecer el ID de la categoría.
     * @param id_category El nuevo ID de la categoría.
     */
    public void setId_category(Long id_category) {
        this.id_category = id_category;
    }

    /**
     * @brief Método para obtener el nombre de la categoría.
     * @return El nombre de la categoría.
     */
    public String getName() {
        return name;
    }

    /**
     * @brief Método para establecer el nombre de la categoría.
     * @param name El nuevo nombre de la categoría.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @brief Método para obtener la lista de productos asociados a la categoría.
     * @return La lista de productos asociados a la categoría.
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * @brief Método para establecer la lista de productos asociados a la categoría.
     * @param products La nueva lista de productos asociados a la categoría.
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
