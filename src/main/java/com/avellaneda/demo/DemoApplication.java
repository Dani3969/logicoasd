package com.avellaneda.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

import com.avellaneda.demo.domain.User;
import com.avellaneda.demo.service.UserService;


@SpringBootApplication
public class DemoApplication {

	@Autowired
	UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	
	@ConditionalOnProperty(name="mock.usuarios")
	@Bean
	public CommandLineRunner commandLineRunner(UserService userService) {
				return args -> {
					userService.registrarUsuario(new User("maxi19@gmail.com","123456","maxi","guzman")  );
		};
	}
	
}
