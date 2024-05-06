/**
 * @file
 * @brief Definición de la interfaz IItemDao
 */

/**
 * @brief Interfaz DAO para la gestión de productos
 *
 * Esta interfaz define los métodos necesarios para la gestión de productos en la capa de acceso a datos.
 * Extiende CrudRepository para proporcionar operaciones CRUD básicas.
 *
 * @author wpantoja, ahurtado
 * @date Fecha de última modificación
 */
package co.unicauca.order.acces.dao;

import co.unicauca.order.domain.entity.Item;
import org.springframework.data.repository.CrudRepository;

/**
 * @brief Interfaz DAO de productos
 *
 * Esta interfaz proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre entidades de tipo Item.
 * Hereda de CrudRepository, lo que le permite acceder a métodos genéricos para la gestión de entidades.
 *
 * @tparam Item Tipo de la entidad de producto
 * @tparam Long Tipo del identificador único de producto
 */
public interface IItemDao extends CrudRepository<Item, Long> {

}
