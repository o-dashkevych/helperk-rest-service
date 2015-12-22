package ua.nure.helperk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Application.class, args);
        System.out.println("Executor start");

        Thread.currentThread().sleep(1000000000000L);
        System.out.println("Executor end");
    }
}
