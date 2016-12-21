package org.hp.leopard;

import org.hp.leopard.context.BootListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoggerApplication {


	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(LoggerApplication.class);
		app.addListeners(new BootListener());
		app.run(args);
	}
}
