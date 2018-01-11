package com.sample.project;
import com.sample.project.config.SpringConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SpringConfig.class)
public class Application {

    public static void main(String... args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
