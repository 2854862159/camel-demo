package com.example.cameldemo;

import org.apache.camel.ProducerTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class CamelDemoApplicationTests {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Test
    void contextLoads() {
        Map o = producerTemplate.requestBody("rest:get:pets/1", new HashMap<>(), Map.class);
        System.out.println(o);
    }

}
