package com.example.service1;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
public class Controller {

    private final RestTemplate template;

    private final DiscoveryClient discoveryClient;

    public Controller(RestTemplate template, DiscoveryClient discoveryClient) {
        this.template = template;
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/service2")
    public String service2() {
        return template.getForObject(resolveURI(), String.class);
    }

    private URI resolveURI() {
        return discoveryClient.getInstances("Service1").stream()
                .map(si -> si.getUri())
                .findFirst()
                .map(s -> s.resolve("/service1"))
                .get();
    }
}
