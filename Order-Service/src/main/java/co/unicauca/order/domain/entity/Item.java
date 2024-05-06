/**
 * @file Item.java
 * @brief Contiene la definición de la clase Item.
 * @author wpantoja, ahurtado
 */

package co.unicauca.order.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

/**
 * @class Item
 * @brief Representa un ítem de una orden de compra o una factura.
 */
@Entity
@Table(name = "Item")
public class Item {
	/**
	 * @brief Identificador único del ítem.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * @brief Orden a la que pertenece el ítem.
	 */
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	/**
	 * @brief Producto asociado al ítem.
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private Product product;

	/**
	 * @brief Cantidad del producto en el ítem.
	 */
	private Integer amount;

	/**
	 * @brief Constructor de la clase.
	 * @param amount Cantidad del producto.
	 * @param product Producto asociado al ítem.
	 */
	public Item(Integer amount, Product product) {
		this.amount = amount;
		this.product = product;
	}

	/**
	 * @brief Constructor por defecto.
	 */
	public Item() {}

	/**
	 * @brief Obtiene la orden asociada al ítem.
	 * @return La orden asociada.
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @brief Establece la orden asociada al ítem.
	 * @param order La orden a establecer.
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @brief Obtiene el identificador del ítem.
	 * @return El identificador del ítem.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @brief Establece el identificador del ítem.
	 * @param id El identificador a establecer.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @brief Obtiene el producto asociado al ítem.
	 * @return El producto asociado.
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @brief Establece el producto asociado al ítem.
	 * @param product El producto a establecer.
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @brief Obtiene la cantidad del producto en el ítem.
	 * @return La cantidad del producto.
	 */
	public Integer getAmount() {
		return amount;
	}

	/**
	 * @brief Establece la cantidad del producto en el ítem.
	 * @param amount La cantidad a establecer.
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	/**
	 * @brief Calcula el total del ítem.
	 * @return El total del ítem (precio del producto multiplicado por la cantidad).
	 */
	@JsonIgnore
	public Double getTotal() {
		return product.getPrice() * amount.doubleValue();
	}
}
