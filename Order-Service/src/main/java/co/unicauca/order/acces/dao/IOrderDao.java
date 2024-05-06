/**
 * @file IOrderDao.java
 * @brief Este archivo contiene la definición de la interfaz IOrderDao.
 */

package co.unicauca.order.acces.dao;

import co.unicauca.order.domain.entity.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * @interface IOrderDao
 * @brief Interfaz para acceder a la persistencia de las órdenes de la aplicación.
 */
public interface IOrderDao extends CrudRepository<Order, Long> {

}

