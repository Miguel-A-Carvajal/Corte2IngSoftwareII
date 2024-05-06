/**
 * @file OrderServiceApplication.java
 * @brief Este archivo contiene la clase principal que inicia la aplicación del servicio de pedidos.
 */

package co.unicauca.order;

import co.unicauca.order.domain.entity.Item;
import co.unicauca.order.domain.entity.Order;
import co.unicauca.order.domain.entity.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @class OrderServiceApplication
 * @brief Clase principal que inicia la aplicación del servicio de pedidos.
 */
@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

	/**
	 * @brief Método principal que inicia la aplicación del servicio de pedidos.
	 * @param args Argumentos de línea de comandos (no se utilizan en esta aplicación).
	 */
	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}

