package io.JordanDev.server;

import io.JordanDev.server.enumeration.Status;
import io.JordanDev.server.model.Server;
import io.JordanDev.server.repository.ServerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


import java.util.Arrays;

//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

//	@Bean
//	CommandLineRunner run(ServerRepo serverRepo){
//		return args -> {
//			serverRepo.save(new Server(null, "192.168.1.95", "Kali Linux", "4 GB", "Raspberry Pi Computer",
//					"http://localhost:8080/server/image/server.png", Status.SERVER_UP));
//			serverRepo.save(new Server(null, "192.168.1.38", "MacOS", "16 GB", "macbook Pro M1",
//					"http://localhost:8080/server/image/server-2.png", Status.SERVER_UP));
//			serverRepo.save(new Server(null, "192.168.1.89", "Security Camera", "2 GB", "My Eye Secuirty Camera",
//					"http://localhost:8080/server/image/server-3.png", Status.SERVER_DOWN));
//		};
//	}


	/**
	 * This is for Angular framework
	 */
//	@Bean
//	public CorsFilter corsFilter() {
//		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//		CorsConfiguration corsConfiguration = new CorsConfiguration();
//		corsConfiguration.setAllowCredentials(true);
//		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200"));
//		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
//				"Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
//				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
//		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
//				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Filename"));
//		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
//		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
//		return new CorsFilter(urlBasedCorsConfigurationSource);
//	}






}
