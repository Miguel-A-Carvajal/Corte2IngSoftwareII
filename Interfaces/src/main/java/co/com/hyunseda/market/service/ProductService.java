package co.com.hyunseda.market.service;


import co.com.hyunseda.market.entities.Category;
import co.com.hyunseda.market.entities.Product;
import co.com.hyunseda.market.access.IProductRepository;
import co.com.hyunseda.market.entities.ShoppingCart;
import co.com.hyunseda.market.infra.Subject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
/**
 * @brief Clase que representa un servicio de gestión de productos.
 * Extiende la clase Subject.
 */
public class ProductService extends Subject {
    
    // Atributos
    private IProductRepository repository; ///< Repositorio de productos.

    /**
     * @brief Constructor de la clase ProductService.
     * @param repository Repositorio de productos.
     */
    public ProductService(IProductRepository repository) { 
        this.repository = repository;
    }

    /**
     * @brief Método para guardar un nuevo producto.
     * @param newProduct El nuevo producto a guardar.
     * @return true si se guarda correctamente, false si no.
     */
    public boolean saveProduct(Product newProduct) {  
        boolean respuesta = repository.save(newProduct);
        
        if(respuesta){
            notifyAllObserves();
        }
        return respuesta;
    }

    /**
     * @brief Método para encontrar todos los productos.
     * @return Una lista de todos los productos.
     */
    public List<Product> findAllProducts() {
        List<Product> products = new ArrayList<>();
        products = repository.findAll();

        return products;
    }
    
    /**
     * @brief Método para encontrar un producto por su ID.
     * @param id El ID del producto a buscar.
     * @return El producto encontrado.
     */
    public Product findProductById(Long id){
        return repository.findById(id);
    }
    
    /**
     * @brief Método para encontrar productos por categoría.
     * @param categoryId El ID de la categoría de productos.
     * @return Una lista de productos pertenecientes a la categoría especificada.
     */
    public List<Product> findProductsByCategory(Long categoryId) {
        List<Product> products = new ArrayList<>();
        products = repository.findByCategory(categoryId);

        return products;
    }
    
    public boolean actualizarStockCompra(ShoppingCart shoppingCart){
        
        for(Product sh: shoppingCart.getCarro()){
            Product aux = findProductById(sh.getProduct_id());
            aux.setStock(aux.getStock() - sh.getStock());
            boolean auxRespuesta = editProduct(sh.getProduct_id(), aux);
        }
        return true;
    }
    
    public boolean editProduct(Long productId, Product prod) {
        
        //Validate product
        if (prod == null || prod.getName().isEmpty() || prod.getCategories() == null ) {
            return false;
        }
        boolean respuesta=repository.edit(productId, prod);
        if(respuesta){
            notifyAllObserves();
        }
        return respuesta;
    }
}
