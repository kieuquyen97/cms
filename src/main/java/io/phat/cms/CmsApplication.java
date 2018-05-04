package io.phat.cms;

import io.phat.cms.core.init.DefaultInitializableServiceRegistry;
import io.phat.cms.core.init.InitializableService;
import io.phat.cms.core.init.InitializableServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class CmsApplication {
	public static void main(String[] args) {
		SpringApplication.run(CmsApplication.class, args);
	}

	@Bean
	@Autowired
	public CommandLineRunner runner(InitializableServiceRegistry initServiceRegistry, InitializableService[] initServices) {
		return arg -> {
			Arrays.asList(initServices).forEach(service -> initServiceRegistry.registerService(service));
			initServiceRegistry.exec();
		};
	}
}
