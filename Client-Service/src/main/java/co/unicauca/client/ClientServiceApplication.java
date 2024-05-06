package co.unicauca.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Aplicación principal. Debe estar decorada con la
 * anotación @SpringBootApplication
 * 
 * @author wpantoja, ahurtado
 *
 */
@SpringBootApplication
@EnableSwagger2
public class ClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientServiceApplication.class, args);
	}

}
