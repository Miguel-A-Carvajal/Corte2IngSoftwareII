/**
 * @file IUsuarioDao.java
 * @brief Definición de la interfaz IUsuarioDao.
 */

package co.unicauca.user.access.dao;

import org.springframework.data.repository.CrudRepository;

import co.unicauca.user.domain.entity.Usuario;

/**
 * @interface IUsuarioDao
 * @brief Interfaz que define las operaciones de acceso a datos para la entidad Usuario.
 * Esta interfaz extiende CrudRepository, lo que proporciona operaciones CRUD básicas para la entidad Usuario.
 */
public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

}
