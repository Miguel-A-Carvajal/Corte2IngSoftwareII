/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.market.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author JUAN CARLOS MELO
 */
public class Order {

    private Long id;
    private Date date;
    private String state;
    private List<Item> items = new ArrayList<>();

    public Order() {
    }

    public Order(Long id, Date date, String state, List<Item> items) {
        this.id = id;
        this.date = date;
        this.state = state;
        this.items = items;
    }

    public Order(Long id, Date date) {
        this.id = id;
        this.date = date;
    }

    public Order(Date date, String state,List<Item> items) {
        this.date = date;
        this.state = state;
        this.items = items;
    }

    public Order(Date date, List<Item> items) {
        this.date = date;
        this.items = items;
    }

    
    /**
     * @brief Calcula el costo total del pedido.
     * @return El costo total del pedido.
     */
    public double getTotal() {
        double total = 0.0;
        if (items != null) {
            for (Item item : items) {
                total += item.getTotal();
            }
        }
        return total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
