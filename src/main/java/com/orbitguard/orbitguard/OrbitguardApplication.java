package com.orbitguard.orbitguard;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.orbitguard.orbitguard.view.home.Home;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OrbitguardApplication {
    public static void main(String[] args) {
        FlatDarculaLaf.setup();
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(OrbitguardApplication.class)
                .headless(false).run(args);
        ctx.getBean(Home.class);
    }
}
