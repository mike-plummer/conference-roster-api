package com.objectpartners.conference_roster;

import com.objectpartners.conference_roster.config.DocumentationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        DocumentationConfiguration.class
})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
