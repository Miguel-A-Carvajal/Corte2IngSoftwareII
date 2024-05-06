package co.unicauca.product.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Representa un producto de una tienda. Mapeada con la bd.
 * 
 * @author wpantoja, ahurtado
 */
@Entity
@Table(name = "products")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long product_id;

	private String name;

	private String description;

	private Double price;

	private int stock;

	private String keyWords;

	private String characteristics;

	private String urlImagen;

	@ManyToMany
	@JoinTable(name = "product_category",
			joinColumns = @JoinColumn(name = "product_id"),
			inverseJoinColumns = @JoinColumn(name = "id_category"))
	private List<Category> categories = new ArrayList<>();;

	//private Location location;

	//private User user;

	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	public Product(Long product_id, String name, String description, Double price, int stock, String keyWords, String characteristics, String urlImagen, List<Category> categories, Date createAt) {
		this.product_id = product_id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.keyWords = keyWords;
		this.characteristics = characteristics;
		this.urlImagen = urlImagen;
		this.categories = categories;
		this.createAt = createAt;
	}

	public Product(Long id, String name, String description, Double price, int stock, Date createAt) {
		this.product_id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.createAt = createAt;
	}

	public Product() {

	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
}