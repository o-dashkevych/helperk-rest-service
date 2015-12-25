package ua.nure.helperk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class Application {
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(Application.class, args);
		System.out.println("Executor start");

		Thread.sleep(1000000000000L);
		System.out.println("Executor end");
	}
}
