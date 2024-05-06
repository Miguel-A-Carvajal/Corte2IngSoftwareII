/**
 * @file Product.java
 * @brief Definición de la clase Product.
 */

package co.unicauca.order.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * @class Product
 * @brief Clase que representa un producto en el dominio del sistema.
 */
@Entity
@Table(name = "Product")
public class Product {
	/**
	 * Identificador único del producto.
	 */
	@Id
	@Column(name = "product_id")
	private Long product_id;

	/**
	 * Nombre del producto.
	 */
	@Column(name = "name")
	private String name;

	/**
	 * Lista de ítems asociados a este producto.
	 */
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private List<Item> items = new ArrayList<>();

	/**
	 * Precio del producto.
	 */
	private Double price;

	/**
	 * Fecha de creación del producto.
	 */
	private Date createAt;

	/**
	 * Constructor de la clase Product.
	 * @param id Identificador único del producto.
	 * @param name Nombre del producto.
	 * @param price Precio del producto.
	 * @param createAt Fecha de creación del producto.
	 */
	public Product(Long id, String name, Double price, Date createAt) {
		this.product_id = id;
		this.name = name;
		this.price = price;
		this.createAt = createAt;
	}

	/**
	 * Constructor por defecto de la clase Product.
	 */
	public Product() {

	}

	/**
	 * Método para obtener el identificador único del producto.
	 * @return Identificador único del producto.
	 */
	public Long getProduct_id() {
		return product_id;
	}

	/**
	 * Método para establecer el identificador único del producto.
	 * @param product_id Identificador único del producto.
	 */
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	/**
	 * Método para obtener el nombre del producto.
	 * @return Nombre del producto.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Método para establecer el nombre del producto.
	 * @param name Nombre del producto.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Método para obtener el precio del producto.
	 * @return Precio del producto.
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * Método para establecer el precio del producto.
	 * @param price Precio del producto.
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * Método para obtener la fecha de creación del producto.
	 * @return Fecha de creación del producto.
	 */
	public Date getCreateAt() {
		return createAt;
	}

	/**
	 * Método para establecer la fecha de creación del producto.
	 * @param createAt Fecha de creación del producto.
	 */
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	/**
	 * Método para obtener la lista de ítems asociados al producto.
	 * @return Lista de ítems asociados al producto.
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * Método para establecer la lista de ítems asociados al producto.
	 * @param items Lista de ítems asociados al producto.
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}
}
