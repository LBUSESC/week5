package uk.ac.leedsbeckett.post_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PostServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(PostServiceApplication.class, args);
		System.out.println("Post Service Application Started");
	}

}
