/**
 * @file IRolDao.java
 * @brief Interfaz para acceder a la capa de persistencia de roles de usuario.
 */

package co.unicauca.user.access.dao;

import co.unicauca.user.domain.entity.Rol;
import org.springframework.data.repository.CrudRepository;

/**
 * @interface IRolDao
 * @brief Interfaz que define las operaciones CRUD para la entidad Rol.
 * Esta interfaz extiende CrudRepository, proporcionando métodos CRUD básicos.
 */
public interface IRolDao extends CrudRepository<Rol, Long> {
}
