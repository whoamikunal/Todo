package com.demo.todo.bootstrap;

import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

@Component
@Slf4j
public class Application implements CommandLineRunner {

    @Value("${spring.application.name}")
    String applicationName;
    @Override
    public void run(String... args) throws Exception {
        log.info("Application running... {}", applicationName);
    }
}
