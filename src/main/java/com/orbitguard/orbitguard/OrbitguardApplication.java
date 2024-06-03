package com.orbitguard.orbitguard;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.orbitguard.orbitguard.view.home.HomeScreen;

@SpringBootApplication
public class OrbitguardApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(OrbitguardApplication.class)
				.headless(false).run(args);
		ctx.getBean(HomeScreen.class);
	}

}
