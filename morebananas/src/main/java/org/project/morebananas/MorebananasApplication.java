package org.project.morebananas;

import org.project.morebananas.configuration.JpaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"org.project.morebananas"})
public class MorebananasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MorebananasApplication.class, args);
	}

}


// java -jar target/morebananas-1.0.0.jar --spring.profiles.active=default