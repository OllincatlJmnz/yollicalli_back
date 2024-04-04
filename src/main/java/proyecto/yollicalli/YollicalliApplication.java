package proyecto.yollicalli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class YollicalliApplication {

	public static void main(String[] args) {
		SpringApplication.run(YollicalliApplication.class, args);
	}//main
	@Configuration
	public class CorsConfig implements WebMvcConfigurer {
	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	                .allowedOrigins("https://dhyanaixchelverjanvargas.github.io/Proyecto-YolliCalli/*") // Permitir solicitudes desde cualquier origen
	                .allowedMethods("GET", "POST", "PUT", "DELETE") // Permitir estos métodos HTTP
	                .allowedHeaders("*"); // Permitir todos los encabezados
	    }
	}
}
