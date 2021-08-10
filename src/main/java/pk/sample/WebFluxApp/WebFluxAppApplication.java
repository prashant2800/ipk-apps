package pk.sample.WebFluxApp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class WebFluxAppApplication {

	@Value("${spring.application.name:demoservice}")
	public String name;

	public static void main(String[] args) {
		SpringApplication.run(WebFluxAppApplication.class, args);
	}

	@GetMapping("/")
	public Mono<String> name() {
		return Mono.just(name);
	}

}
