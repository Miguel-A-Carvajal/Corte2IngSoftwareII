/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package co.com.hyunseda.market.access;

import co.com.hyunseda.market.entities.Product;
import co.com.hyunseda.market.entities.Product;
import co.com.hyunseda.market.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.http.HttpEntity;
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
public class ProductRepositoryTest {
    
    
    public ProductRepositoryTest() {
    }
    /*
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    void setUp() {
        
    }
    
    @AfterEach
    public void tearDown() {
    }*/

    /**
     * Test of productosIniciales method, of class ProductRepository.
     */
    /*@Test
    public void testProductosIniciales() {
        System.out.println("productosIniciales");
        ProductRepository instance = new ProductRepository();
        instance.productosIniciales();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of save method, of class ProductRepository.
     */
    /*@Test
    public void testSave() {
        System.out.println("save");
        Product newProduct = null;
        ProductRepository instance = new ProductRepository();
        boolean expResult = false;
        boolean result = instance.save(newProduct);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of findAll method, of class ProductRepository.
     */
    @Test
    public void testFindAll() throws IOException {
        // Crear un cliente HTTP real
        HttpClient httpClient = HttpClients.createDefault();
        

        // Definir la URL del microservicio de productos
        String apiUrl = "http://localhost:8001/products";

        // Crear una solicitud GET para obtener todos los productos
        HttpGet request = new HttpGet(apiUrl);

        // Ejecutar la solicitud y obtener la respuesta
        HttpResponse response = httpClient.execute(request);

        // Verificar el código de estado de la respuesta
        int statusCode = response.getStatusLine().getStatusCode();
        assertEquals(200, statusCode, "El código de estado de la respuesta no es 200");

        // Procesar la respuesta
        HttpEntity entity = response.getEntity();
        String jsonResponse = EntityUtils.toString(entity);

        // Convertir la respuesta JSON a objetos Product
        ObjectMapper mapper = new ObjectMapper();
        Product[] products = mapper.readValue(jsonResponse, Product[].class);

        // Verificar que al menos un producto ha sido devuelto
        assertEquals(true, products.length > 0, "No se devolvieron productos en la respuesta");

        // Puedes realizar más aserciones según la estructura de tus datos esperados
    }

    /**
     * Test of findById method, of class ProductRepository.
     */
    @Test
    void testFindById() throws IOException {
        IProductRepository reposity = new ProductRepository();
        // Definir el ID del producto a buscar
        Long productId = 5L;

        // Enviar la solicitud para buscar el producto por su ID
        Product product = reposity.findById(productId);

        // Verificar que el producto no sea nulo
        assertNotNull(product, "El producto devuelto no debe ser nulo");

        // Verificar que el ID del producto devuelto sea el esperado
        assertEquals(productId, product.getProduct_id(), "El ID del producto devuelto no coincide con el ID esperado");

        // Puedes realizar más aserciones según la lógica específica de tu aplicación
    }

    /**
     * Test of findByCategory method, of class ProductRepository.
     */
    /*@Test
    public void testFindByCategory() {
        System.out.println("findByCategory");
        Long categoryId = null;
        ProductRepository instance = new ProductRepository();
        List<Product> expResult = null;
        List<Product> result = instance.findByCategory(categoryId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of edit method, of class ProductRepository.
     */
    /*@Test
    public void testEdit() {
        System.out.println("edit");
        Long id = null;
        Product product = null;
        ProductRepository instance = new ProductRepository();
        boolean expResult = false;
        boolean result = instance.edit(id, product);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
