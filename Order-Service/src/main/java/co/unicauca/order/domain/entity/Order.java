/**
 * @file Order.java
 * @brief Defines the Order entity class.
 */

package co.unicauca.order.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @class Order
 * @brief Represents an order entity.
 */
@Entity
@Table(name = "OrderE")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    private String state;
    @OneToMany(mappedBy = "order")
    private List<Item> items = new ArrayList<>();

    /**
     * @brief Constructs an Order object with specified id, date, state, and items.
     * @param id The identifier of the order.
     * @param date The date of the order.
     * @param state The state of the order.
     * @param items The list of items in the order.
     */
    public Order(Long id, Date date, String state, List<Item> items) {
        this.id = id;
        this.date = date;
        this.state = state;
        this.items = items;
    }

    /**
     * @brief Constructs an Order object with specified id and date.
     * @param id The identifier of the order.
     * @param date The date of the order.
     */
    public Order(Long id, Date date) {
        this.id = id;
        this.date = date;
    }

    /**
     * @brief Constructs an empty Order object.
     */
    public Order() {}

    /**
     * @brief Calculates the total cost of the order.
     * @return The total cost of the order.
     */
    @JsonIgnore
    public double getTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getTotal();
        }
        return total;
    }

    // Getters and setters

    /**
     * @brief Gets the id of the order.
     * @return The id of the order.
     */
    public Long getId() {
        return id;
    }

    /**
     * @brief Sets the id of the order.
     * @param id The id of the order.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @brief Gets the date of the order.
     * @return The date of the order.
     */
    public Date getDate() {
        return date;
    }

    /**
     * @brief Sets the date of the order.
     * @param date The date of the order.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @brief Gets the list of items in the order.
     * @return The list of items in the order.
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * @brief Sets the list of items in the order.
     * @param items The list of items in the order.
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * @brief Gets the state of the order.
     * @return The state of the order.
     */
    public String getState() {
        return state;
    }

    /**
     * @brief Sets the state of the order.
     * @param state The state of the order.
     */
    public void setState(String state) {
        this.state = state;
    }
}
