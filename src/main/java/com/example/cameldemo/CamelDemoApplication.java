package com.example.cameldemo;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.http.HttpEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class CamelDemoApplication {

    private static final String[] PETS = new String[]{"Snoopy", "Fido", "Tony the Tiger"};

    @Autowired
    private ProducerTemplate template;

    @GetMapping(value = "/pets/{id}")
    public Map<String, String> petById(@PathVariable("id") Integer id) {
        if (id != null && id > 0 && id <= PETS.length) {
            int index = id - 1;
            String pet = PETS[index];
            return Collections.singletonMap("name", pet);
        } else {
            return Collections.emptyMap();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(CamelDemoApplication.class, args);
    }

}
