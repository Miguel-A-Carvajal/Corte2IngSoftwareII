package co.unicauca.product.domain.service;

import co.unicauca.product.access.dao.ICategoryDao;
import co.unicauca.product.access.dao.IProductDao;
import co.unicauca.product.domain.entity.Category;
import co.unicauca.product.domain.entity.Product;
import co.unicauca.product.presentation.rest.exceptions.ProductDomainException;
import co.unicauca.product.presentation.rest.exceptions.ProductError;
import co.unicauca.product.presentation.rest.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CategoryImplService implements ICategoryService{
    /**
     * Inyección de producto Dao
     */
    @Autowired
    private ICategoryDao categoryDao;
    /**
     * Servicio para buscar todas las categrias
     *
     * @return Listado de categorias
     */
    @Override
    @Transactional(readOnly = true) // Para que esté sincronizada con la bd
    public List<Category> findAll() {
        return (List<Category>) categoryDao.findAll();
    }

    /**
     * Busca una categoria por su Id
     *
     * @param id_category identificador del producto
     * @return objeto de tipo category
     */
    @Override // Para que esté sincronizada con la bd
    public Category findById(Long id_category) throws ResourceNotFoundException {
        Category categ = categoryDao.findById(id_category).orElse(null);
        if (categ == null) {
            throw new ResourceNotFoundException();

        }
        return categ;
    }

    /**
     * Crea una nueva categoria
     *
     * @param category categoria a crear en la bd
     * @return Cateoria creada
     */
    @Override
    @Transactional
    public Category create(Category category) throws ProductDomainException {
        //crear excepxiones para categorias
        List<ProductError> errors = validateDomain(category);

        if (!errors.isEmpty()) {
            throw new ProductDomainException(errors);
        }

        return categoryDao.save(category);
    }

    /**
     * Modifica o edita un producto
     *
     * @param id_category,     identificador de la categoria a modificar
     * @param category categoria con los datos a editar
     * @return Producto modificado
     */
    @Override
    @Transactional
    public Category update(Long id_category, Category category) throws ProductDomainException, ResourceNotFoundException {
        Category categ = this.findById(id_category);
        if (categ == null) {
            throw new ResourceNotFoundException();
        }

        List<ProductError> errors = validateDomain(category);

        if (!errors.isEmpty()) {
            throw new ProductDomainException(errors);
        }

        categ.setName(category.getName());

        return categoryDao.save(categ);
    }

    /**
     * Aplica validaciones o reglas del dominio para un producto. Antes de ser
     * agregado o modificado.
     *
     * @param category producto a validad
     * @return lista de errores de validación
     */

    private List<ProductError> validateDomain(Category category) {
        List<ProductError> errors = new ArrayList<>();

        if (category.getName() == null || category.getName().isBlank()) {
            errors.add(new ProductError(EnumErrorCodes.EMPTY_FIELD, "name", "El nombre del categoria es obligatorio"));
        }

        return errors;

    }

    /**
     * Eliminar producto por su id
     *
     * @param id_category identificador del categoria a eliminar
     */
    @Override
    @Transactional
    public void deleteById(Long id_category) throws ResourceNotFoundException {
        Category categ = this.findById(id_category);
        if (categ == null) {
            throw new ResourceNotFoundException();
        }
        categoryDao.deleteById(id_category);
    }
}
