/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package co.com.hyunseda.market.access;

import co.com.hyunseda.market.entities.Category;
import co.com.hyunseda.market.access.OrderRepository;
import co.com.hyunseda.market.access.IOrderReposity;
import co.com.hyunseda.market.entities.Item;
import co.com.hyunseda.market.entities.Order;
import co.com.hyunseda.market.entities.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.http.HttpEntity;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author shadi
 */
public class OrderRepositoryTest {
    
    public OrderRepositoryTest() {
    }/*
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }*/

    /**
     * Test of findAll method, of class OrderRepository.
     *//*
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        OrderRepository instance = new OrderRepository();
        List<Order> expResult = null;
        List<Order> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of findById method, of class OrderRepository.
     *//*
    @Test
    public void testFindById() {
        System.out.println("findById");
        Long id = null;
        OrderRepository instance = new OrderRepository();
        Optional<Order> expResult = null;
        Optional<Order> result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of create method, of class OrderRepository.
     */
    @Test
    void testCreateOrder() throws IOException {
        IOrderReposity reposity = new OrderRepository();
        // Crear un cliente HTTP real
        HttpClient httpClient = HttpClients.createDefault();
        // Crear la lista de categorías para cada producto
        List<Category> categories1 = new ArrayList<>();
        categories1.add(new Category(1L, "CategoryName1"));
        Product product1 = new Product(10, "ProductName1", "ProductDescription1", categories1, 5L, 10.5, "ImageUrl1");

        List<Category> categories2 = new ArrayList<>();
        categories2.add(new Category(2L, "CategoryName2"));
        Product product2 = new Product(20, "ProductName2", "ProductDescription2", categories2, 110L, 20.5, "ImageUrl2");

        List<Category> categories3 = new ArrayList<>();
        categories3.add(new Category(3L, "CategoryName3"));
        Product product3 = new Product(30, "ProductName3", "ProductDescription3", categories3, 75L, 30.5, "ImageUrl3");

        // Crear los objetos Item utilizando los Product creados
        Item item1 = new Item(product1, 3);
        Item item2 = new Item(product2, 2);
        Item item3 = new Item(product3, 1);
        // Crear un objeto Order de ejemplo
        Order order = new Order();
        order.setDate(new Date());
        order.setState("NoEnviado");
        
        order.getItems().add(item1);
        order.getItems().add(item2);
        order.getItems().add(item3);

        // Enviar la orden y obtener el resultado
        boolean result = reposity.create(order);

        // Verificar el resultado
        assertEquals(true, result, "La creación de la orden ha sido exitosa");

        // Puedes realizar más aserciones según la lógica específica de tu aplicación
    }

    /**
     * Test of update method, of class OrderRepository.
     *//*
    @Test
    public void testUpdate() {
        System.out.println("update");
        Order order = null;
        Long id = null;
        OrderRepository instance = new OrderRepository();
        boolean expResult = false;
        boolean result = instance.update(order, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of delete method, of class OrderRepository.
     *//*
    @Test
    public void testDelete() {
        System.out.println("delete");
        Long id = null;
        OrderRepository instance = new OrderRepository();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of actualizarEstado method, of class OrderRepository.
     *//*
    @Test
    public void testActualizarEstado() {
        System.out.println("actualizarEstado");
        Long id = null;
        String estado = "";
        OrderRepository instance = new OrderRepository();
        Order expResult = null;
        Order result = instance.actualizarEstado(id, estado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
