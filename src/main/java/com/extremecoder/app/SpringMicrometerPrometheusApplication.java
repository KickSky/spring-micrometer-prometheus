package com.extremecoder.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class SpringMicrometerPrometheusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMicrometerPrometheusApplication.class, args);
    }

    @GetMapping("/hello")
    public Map<String, String> hello() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello");
        return response;
    }

}
