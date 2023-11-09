package com.demo.todo;

import lombok.extern.slf4j.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class TodoApplication {

	public static void main(String[] args) {
		log.info("Starting application....");
		SpringApplication.run(TodoApplication.class, args);
	}

}
