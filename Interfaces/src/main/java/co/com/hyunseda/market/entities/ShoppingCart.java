/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.market.entities;

import java.util.ArrayList;

/**
 *
 * @author JUAN CARLOS MELO
 */
/**
 * @brief Clase que representa un carrito de compras.
 */
public class ShoppingCart {
    private User user; ///< Usuario asociado al carrito.
    private ArrayList<Product> carro; ///< Lista de productos en el carrito.

    /**
     * @brief Constructor por defecto de la clase ShoppingCart.
     */
    public ShoppingCart() {
    }

    /**
     * @brief Constructor de la clase ShoppingCart.
     * @param user Usuario asociado al carrito.
     * @param carro Lista de productos en el carrito.
     */
    public ShoppingCart(User user, ArrayList<Product> carro) {
        this.user = user;
        this.carro = carro;
    }

    /**
     * @brief Método getter para obtener el usuario asociado al carrito.
     * @return El usuario asociado al carrito.
     */
    public User getUser() {
        return user;
    }

    /**
     * @brief Método setter para establecer el usuario asociado al carrito.
     * @param user El usuario a asociar al carrito.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @brief Método getter para obtener la lista de productos en el carrito.
     * @return La lista de productos en el carrito.
     */
    public ArrayList<Product> getCarro() {
        return carro;
    }

    /**
     * @brief Método setter para establecer la lista de productos en el carrito.
     * @param carro La lista de productos a establecer en el carrito.
     */
    public void setCarro(ArrayList<Product> carro) {
        this.carro = carro;
    }
}

