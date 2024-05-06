/**
 * @file IProductDao.java
 * @brief Este archivo contiene la interfaz para el acceso a datos de productos.
 */

package co.unicauca.order.acces.dao;

import co.unicauca.order.domain.entity.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * @interface IProductDao
 * @brief Interfaz DAO para la gestión de productos.
 * Esta interfaz proporciona métodos para acceder a los datos de productos en la base de datos.
 * Extiende la interfaz CrudRepository de Spring Data.
 * @author wpantoja
 * @author ahurtado
 * @version 1.0
 */
public interface IProductDao extends CrudRepository<Product, Long> {

}
