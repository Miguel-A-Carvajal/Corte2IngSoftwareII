package co.com.hyunseda.market.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
/**
 * @brief Clase que representa un producto.
 */
/**
 * Clase que representa un producto.
 */
public class Product {

    // slug es una babosa y si toca hacer una clase de eso
    // keywords preguntar si es lista(string) o clase  *
    // imagenes preguntar si va a hacer en clase
    // stock preguntar porque cada producto es unico
    // preguntar lo del producto en varias categorias
    // caracteristicas no es lo mismo que descripcion

    private Long product_id; ///< ID del producto.
    private String name; ///< Nombre del producto.
    private String description; ///< Descripción del producto.
    private Double price; ///< Precio del producto.
    private int stock; ///< Stock disponible del producto.
    private String keyWords; ///< Palabras clave relacionadas con el producto.
    private String characteristics; ///< Características del producto.
    private String urlImagen; ///< URL de la imagen del producto.
    private Date createAt; ///< Fecha de creación del producto.
    private List<Category> categories = new ArrayList<>();; ///< Lista de categorías a las que pertenece el producto.

    /**
     * Constructor por defecto de la clase Product.
     */
    public Product() {
    }

    /**
     * Constructor de la clase Product.
     * @param product_id ID del producto.
     * @param name Nombre del producto.
     * @param description Descripción del producto.
     * @param price Precio del producto.
     * @param stock Stock disponible del producto.
     * @param keyWords Palabras clave relacionadas con el producto.
     * @param characteristics Características del producto.
     * @param urlImagen URL de la imagen del producto.
     * @param createAt Fecha de creación del producto.
     */
    public Product(Long product_id, String name, String description, Double price, int stock, String keyWords, String characteristics, String urlImagen, Date createAt) {
        this.product_id = product_id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.keyWords = keyWords;
        this.characteristics = characteristics;
        this.urlImagen = urlImagen;
        this.createAt = createAt;
    }

    /**
     * Constructor de la clase Product.
     * @param product_id ID del producto.
     * @param name Nombre del producto.
     * @param description Descripción del producto.
     * @param price Precio del producto.
     * @param stock Stock disponible del producto.
     * @param keyWords Palabras clave relacionadas con el producto.
     * @param characteristics Características del producto.
     * @param urlImagen URL de la imagen del producto.
     * @param categories Lista de categorías a las que pertenece el producto.
     */
    public Product(Long product_id, String name, String description, Double price, int stock, String keyWords, String characteristics, String urlImagen, ArrayList<Category> categories) {
        this.product_id = product_id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.keyWords = keyWords;
        this.characteristics = characteristics;
        this.urlImagen = urlImagen;
        this.categories = categories;
    }

    /**
     * Constructor de la clase Product.
     * @param stock Stock del producto.
     * @param name Nombre del producto.
     * @param description Descripción del producto.
     * @param categories Lista de categorías a las que pertenece el producto.
     * @param product_id ID del producto.
     * @param price Precio del producto.
     * @param urlImagen URL de la imagen del producto.
     */
    public Product(int stock, String name, String description, List<Category> categories, Long product_id, Double price, String urlImagen) {
        this.stock = stock;
        this.name = name;
        this.description = description;
        this.categories = categories;
        this.product_id = product_id;
        this.price = price;
        this.urlImagen = urlImagen;
    }

    

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    
    /**
     * Método para obtener las categorías formateadas como una cadena.
     * @return Las categorías del producto formateadas como una cadena.
     */
    public String obtenerCategoriasConFormato() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("[");
        for (int i = 0; i < categories.size(); i++) {
            resultado.append(categories.get(i).getName());
            if (i < categories.size() - 1) {
                resultado.append(",");
            }
        }
        resultado.append("]");
        return resultado.toString();
    }
}

