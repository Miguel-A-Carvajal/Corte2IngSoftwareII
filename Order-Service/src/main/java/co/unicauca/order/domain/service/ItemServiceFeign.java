/**
 * @file ItemServiceFeign.java
 * @brief Implementación de los servicios de gestión de ítems utilizando Feign para comunicación de microservicios.
 */

		package co.unicauca.order.domain.service;

import co.unicauca.order.acces.dao.IItemDao;
import co.unicauca.order.acces.dao.IProductDao;
import co.unicauca.order.domain.entity.Item;
import co.unicauca.order.domain.entity.Order;
import co.unicauca.order.domain.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación de la interfaz IItemService que proporciona servicios CRUD para ítems.
 * Se utiliza Feign, una forma declarativa de comunicación entre microservicios.
 *
 * @author wpantoja, ahurtado
 * @version 1.0
 */
@Service("serviceFeign")
public class ItemServiceFeign implements IItemService {

	@Autowired
	private IProductClientRest clientFeign;

	/**
	 * Inyección del DAO de ítems
	 */
	@Autowired
	private IItemDao itemDao;

	@Autowired
	private IProductDao productDao;

	/**
	 * Obtiene todos los ítems.
	 *
	 * @return Lista de ítems
	 */
	@Override
	public List<Item> findAll() {
		return (List<Item>) itemDao.findAll();
	}

	/**
	 * Obtiene todos los productos disponibles.
	 *
	 * @return Lista de productos
	 */
	public List<Product> findAllProducts() {
		return clientFeign.list();
	}

	/**
	 * Busca un ítem por su identificador y cantidad.
	 *
	 * @param id     Identificador del ítem
	 * @param amount Cantidad del ítem
	 * @return Ítem encontrado
	 */
	@Override
	public Item findById(Long id, Integer amount) {
		return new Item(amount, clientFeign.detail(id));
	}

	/**
	 * Crea una lista de ítems.
	 *
	 * @param items Lista de ítems a crear
	 * @return true si se crearon los ítems exitosamente, false en caso contrario
	 */
	@Override
	public boolean create(List<Item> items) {
		for (Item item : items) {
			item.setProduct(verificarProductoExistente(item.getProduct()));
			itemDao.save(item);
		}
		return true;
	}

	/**
	 * Verifica si un producto ya existe en la base de datos.
	 * Si no existe, lo guarda en la base de datos.
	 *
	 * @param product Producto a verificar
	 * @return Producto existente o guardado
	 */
	private Product verificarProductoExistente(Product product) {
		Product p = productDao.findById(product.getProduct_id()).orElse(null);
		if (p == null) {
			p = productDao.save(clientFeign.detail(product.getProduct_id()));
		}
		return p;
	}

	/**
	 * Actualiza un producto.
	 *
	 * @param product Producto a actualizar
	 * @param id      Identificador del producto
	 * @return Producto actualizado
	 */
	@Override
	public Product update(Product product, Long id) {
		return clientFeign.update(product, id);
	}

	/**
	 * Elimina un ítem por su identificador.
	 *
	 * @param id Identificador del ítem a eliminar
	 */
	@Override
	public void delete(Long id) {
		itemDao.deleteById(id);
	}



}