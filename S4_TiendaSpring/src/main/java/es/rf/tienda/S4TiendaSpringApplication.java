package es.rf.tienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages="es.rf.tienda")//(exclude = {DataSourceAutoConfiguration.class}) // Permite ver qué errores da
public class S4TiendaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(S4TiendaSpringApplication.class, args);
	}

}
