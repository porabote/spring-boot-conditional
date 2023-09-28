package com.example.springboot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

    @Autowired
    TestRestTemplate restTemplate;

    @Container
    private GenericContainer<?> devapp = new GenericContainer<>("devapp:latest")
            .withExposedPorts(8080);

    @Container
    private GenericContainer<?> promapp = new GenericContainer<>("promapp:latest")
            .withExposedPorts(8080);

//    @BeforeAll
//    void setUp() {
//        devapp.start();
//        promapp.start();
//    }

    @Test
    void contextLoads() {

        Integer devAppPort = devapp.getMappedPort(8080);
        Integer promAppPort = promapp.getMappedPort(8080);

        ResponseEntity<String> entityDev = restTemplate.getForEntity("http://localhost" + devAppPort, String.class);
        ResponseEntity<String> entityProm = restTemplate.getForEntity("http://localhost" + promAppPort, String.class);

        Assertions.assertEquals("Hello from dev", entityDev.getBody());
        Assertions.assertEquals("Hello from prom", entityProm.getBody());
    }

}
