package co.unicauca.product.access.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.unicauca.product.domain.entity.Product;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * Interfaces DAO de productos
 * @author wpantoja, ahurtado
 *
 */
public interface IProductDao extends CrudRepository<Product, Long> {
    @Query("SELECT p FROM Product p JOIN p.categories c WHERE c.id_category = :categoryId")
    List<Product> findByCategoriesCategoryId(@Param("categoryId") Long categoryId);
}