package com.example.UserServiece.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@EnableDiscoveryClient
@RestController
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/getAll")
    public String invokeWorkerDetails(){
        URI uri = discoveryClient.getInstances("workerDetails").stream()
                .map(serviceInstance -> serviceInstance.getUri()).findFirst()
                .map(s -> s.resolve("/worker/getAll")).get();
        return restTemplate.getForObject(uri,String.class);
    }
}
