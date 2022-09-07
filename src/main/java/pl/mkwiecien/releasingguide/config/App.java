package pl.mkwiecien.releasingguide.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "pl.mkwiecien.releasingguide.app.domain")
@ComponentScan(basePackages = "pl.mkwiecien.releasingguide")
@EntityScan(basePackages = "pl.mkwiecien.releasingguide.app.domain")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
