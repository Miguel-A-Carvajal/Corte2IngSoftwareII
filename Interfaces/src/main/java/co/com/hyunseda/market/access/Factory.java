package co.com.hyunseda.market.access;

import co.com.hyunseda.market.infra.Utilities;

/**
 * @brief Clase que actúa como fábrica para crear instancias de repositorios.
 * Implementa el patrón de diseño Singleton.
 */
public class Factory {

    private static Factory instance; ///< Instancia única de la fábrica.

    /**
     * @brief Constructor privado para evitar la creación de instancias fuera de la clase.
     */
    private Factory() {
    }

    /**
     * @brief Método estático que devuelve la única instancia de la fábrica.
     * @return La instancia de la fábrica.
     */
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;

    }

    /**
     * @brief Método que crea una instancia concreta del repositorio de productos.
     * @return Una instancia de la clase que implementa IProductRepository.
     */
    public IProductRepository getRepository() {

        IProductRepository result = null;
        String type = Utilities.loadProperty("ProductRepository");
        switch (type) {
            case "default":
                result = new ProductRepository();
                break;
        }
        return result;
    }
}

