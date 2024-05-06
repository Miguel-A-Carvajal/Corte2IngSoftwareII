package co.unicauca.product.presentation.rest;

import co.unicauca.product.domain.entity.Category;
import co.unicauca.product.domain.entity.Product;
import co.unicauca.product.domain.service.ICategoryService;
import co.unicauca.product.domain.service.IProductService;
import co.unicauca.product.presentation.rest.exceptions.ProductDomainException;
import co.unicauca.product.presentation.rest.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    /**
     * Listar todos
     *
     * @return listado de categorias en json
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Category> findAll() {
        return (List<Category>) categoryService.findAll();
    }

    /**
     * Listar un producto por id
     *
     * @param id_category identificador
     * @return Categoria en formato json
     * @throws Exception
     */
    @RequestMapping(value = "{id_category}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Category findById(@PathVariable Long id_category) throws ResourceNotFoundException {

        Category category = categoryService.findById(id_category);
        return category;
    }

    /**
     * Crear un producto
     *
     * @param category producto
     * @return producto creado
     */

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Category create(@RequestBody Category category) throws ProductDomainException {
        return categoryService.create(category);
    }

    /**
     * Editar
     *
     * @param category Producto a editar
     * @param id_category      identificador del producto
     * @return producto editado
     * @throws ResourceNotFoundException recurso no encontrado
     * @throws Exception                 Id no encontrado
     */
    @RequestMapping(value = "{id_category}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Category update(@RequestBody Category category, @PathVariable Long id_category)
            throws ProductDomainException, ResourceNotFoundException {
        return categoryService.update(id_category, category);
    }

    /**
     * Eliminar
     *
     * @param id_category id del producto
     * @throws ResourceNotFoundException id no encontrado
     */

    @RequestMapping(value = "{id_category}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id_category) throws ResourceNotFoundException {
        categoryService.deleteById(id_category);
    }
}
