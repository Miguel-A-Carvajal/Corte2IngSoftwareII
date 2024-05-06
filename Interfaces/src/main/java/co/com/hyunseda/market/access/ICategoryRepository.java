/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.market.access;

import co.com.hyunseda.market.entities.Category;
import java.util.List;

/**
 *
 * @author usuario
 */
/**
 * @brief Interfaz que define las operaciones del repositorio de categorías.
 */
public interface ICategoryRepository {

    /**
     * @brief Método para encontrar todas las categorías.
     * @return Una lista de todas las categorías.
     */
    public List<Category> findAll();
}

