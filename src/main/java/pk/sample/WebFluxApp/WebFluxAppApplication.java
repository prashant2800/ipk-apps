package pk.sample.WebFluxApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
@RestController
public class WebFluxAppApplication {

	@Value("${spring.application.name:demoservice}")
	public String name;

	public static void main(String[] args) {
		SpringApplication.run(WebFluxAppApplication.class, args);
	}

	@GetMapping("/name")
	public String name() {
		return name;
	}

}
