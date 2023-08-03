package com.extremecoder.app;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
@RestController
public class SpringMicrometerPrometheusApplication {

    private final MeterRegistry meterRegistry;
    private AtomicInteger activeUsers = new AtomicInteger(0);

    public SpringMicrometerPrometheusApplication(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @GetMapping("/hello")
    public Map<String, String> hello() {
        Map<String, String> response = new HashMap<>();
        Random random = new Random();
        activeUsers.set(random.nextInt(1000));
        response.put("message", "active User " +  activeUsers);
        meterRegistry.gauge("number.of.active.users", activeUsers);
        return response;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringMicrometerPrometheusApplication.class, args);
    }

}
