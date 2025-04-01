package com.mithra.documerge.documerge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.mithra.documerge.documerge.repository")
public class DocumergeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumergeApplication.class, args);
	}

}
