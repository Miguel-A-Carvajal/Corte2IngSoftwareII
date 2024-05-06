package co.unicauca.client.access.dao;


import co.unicauca.client.domain.entity.Client;
import org.springframework.data.repository.CrudRepository;


/**
 * Interfaces DAO de productos
 * @author wpantoja, ahurtado
 *
 */
public interface IClientDao extends CrudRepository<Client, Long> {

}