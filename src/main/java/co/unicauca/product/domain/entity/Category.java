package co.unicauca.product.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa un producto de una tienda. Mapeada con la bd.
 *
 * @author wpantoja, ahurtado
 */

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_category;
    private String name;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    private List<Product> products = new ArrayList<>();



    public Long getId_category() {
        return id_category;
    }

    public void setId_category(Long id_category) {
        this.id_category = id_category;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
