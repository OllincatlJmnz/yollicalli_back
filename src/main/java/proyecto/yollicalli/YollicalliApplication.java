package proyecto.yollicalli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class YollicalliApplication {

	public static void main(String[] args) {
		SpringApplication.run(YollicalliApplication.class, args);
	}//main

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("https://yollicalli-back.onrender.com")
						.allowedMethods("GET", "POST", "PUT", "DELETE")
						.allowedHeaders("*");
			}
		};
	}	
}
