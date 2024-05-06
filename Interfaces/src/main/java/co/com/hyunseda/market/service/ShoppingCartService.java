/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.market.service;

import co.com.hyunseda.market.entities.Product;
import co.com.hyunseda.market.entities.ShoppingCart;
import co.com.hyunseda.market.entities.User;
import co.com.hyunseda.market.infra.Subject;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author JUAN CARLOS MELO
 */
/**
 * @brief Clase que representa un servicio de carrito de compras.
 * Extiende la clase Subject.
 */
public class ShoppingCartService extends Subject{

    // Atributos
    private ShoppingCart cart; ///< Carrito de compras asociado al servicio.
   
    /**
     * @brief Constructor de la clase ShoppingCartService.
     * @param user Usuario al que se asociará el carrito.
     */
    public ShoppingCartService(User user) {
        // Se crea un nuevo carrito y se asocia al usuario
        ShoppingCart aux = new ShoppingCart();
        aux.setUser(user);
        aux.setCarro(new ArrayList<Product>());
        this.cart = aux;
    }

    /**
     * @brief Método para obtener el carrito de compras.
     * @return El carrito de compras.
     */
    public ShoppingCart getCart() {
        return cart;
    }

    /**
     * @brief Método para establecer el carrito de compras.
     * @param cart El nuevo carrito de compras.
     */
    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }
    
    /**
     * @brief Método para añadir un producto al carrito.
     * @param producto Producto a añadir al carrito.
     */
    public void aniadirProducto(Product producto){
        ArrayList<Product> auxiliar = cart.getCarro();
        auxiliar.add(producto);
        cart.setCarro(auxiliar);
        this.notifyAllObserves();
    }
    
    /**
     * @brief Método para eliminar un producto del carrito por su ID.
     * @param idEliminar ID del producto a eliminar.
     */
    public void eliminarProducto(Long idEliminar){
        ArrayList<Product> auxiliar = cart.getCarro();
        int i;
        for(i = 0; i<auxiliar.size();i++){
            if(Objects.equals(auxiliar.get(i).getProduct_id(), idEliminar)){
                auxiliar.remove(i);
                break;
            }
        }
        cart.setCarro(auxiliar);
        this.notifyAllObserves();
    }
    
    /**
     * @brief Método para verificar si un producto existe en el carrito.
     * @param buscado ID del producto a buscar.
     * @return true si el producto existe en el carrito, false en caso contrario.
     */
    public boolean verificarExistencia(Long buscado){

        for(Product p : cart.getCarro()){
            if(Objects.equals(p.getProduct_id(), buscado)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * @brief Método para vaciar el carrito de compras.
     */
    public void vaciarCarrito(){
        this.cart.setCarro(new ArrayList<Product>());
        this.notifyAllObserves();
    }
    
}

