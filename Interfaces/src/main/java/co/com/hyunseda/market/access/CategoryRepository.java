/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.market.access;

import co.com.hyunseda.market.entities.Category;
import co.com.hyunseda.market.entities.Product;
import co.com.hyunseda.market.service.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author usuario
 */
/**
 * @brief Clase que implementa el repositorio de categorías.
 * Implementa la interfaz ICategoryRepository.
 */
public class CategoryRepository implements ICategoryRepository {

    /**
     * @brief Método para encontrar todas las categorías.
     * @return Una lista de todas las categorías.
     */
    @Override
    public List<Category> findAll() {
        HttpClient httpClient = HttpClients.createDefault();
        ObjectMapper mapper = new ObjectMapper();
        List<Category> list = new ArrayList<>();
        try {

            // Definir la URL de la API REST de categorías
            String apiUrl = "http://localhost:8001/categories";
            // Crear una solicitud GET para obtener todas las categorías
            HttpGet request = new HttpGet(apiUrl);

            // Ejecutar la solicitud y obtener la respuesta
            HttpResponse response = httpClient.execute(request);

            // Verificar el código de estado de la respuesta
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                // La solicitud fue exitosa, procesar la respuesta
                String jsonResponse = EntityUtils.toString(response.getEntity());

                // Mapear la respuesta JSON a objetos Category
                Category[] categories = mapper.readValue(jsonResponse, Category[].class);

                for (Category category : categories) {
                    list.add(category);
                }
            } else {
                // La solicitud falló, mostrar el código de estado
                Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, "Error al obtener categorías. Código de estado: " + statusCode);
            }
        } catch (IOException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}

