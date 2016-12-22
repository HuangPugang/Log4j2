package org.hp.leopard;

import org.hp.leopard.context.EnvironmentPreparedListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoggerApplication {


	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(LoggerApplication.class);
		app.addListeners(new EnvironmentPreparedListener());
		app.run(args);
	}
}
