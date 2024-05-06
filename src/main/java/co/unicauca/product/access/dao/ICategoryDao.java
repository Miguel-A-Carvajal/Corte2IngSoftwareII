package co.unicauca.product.access.dao;

import co.unicauca.product.domain.entity.Category;
import co.unicauca.product.domain.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryDao extends CrudRepository<Category, Long> {
}
