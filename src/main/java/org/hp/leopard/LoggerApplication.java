package org.hp.leopard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class LoggerApplication {


	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(LoggerApplication.class);
//		app.addListeners(new BootListener());
		app.run(args);
	}
}
