package com.stackroute.userauthentication;

import com.stackroute.userauthentication.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;



@SpringBootApplication
public class JwtfirstApplication  {



	public static void main(String[] args) {
		SpringApplication.run(JwtfirstApplication.class, args);
	}

	@Autowired
	private UserRepository repository;

	@Bean
	public CorsFilter corsFilter()
	{
		final UrlBasedCorsConfigurationSource  source= new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedHeader("*");
        config.addAllowedOrigin("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("POST");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("DELETE");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);

	}


}
