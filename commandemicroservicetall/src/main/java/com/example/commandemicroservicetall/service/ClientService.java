package com.example.commandemicroservicetall.service;

import com.example.commandemicroservicetall.Entities.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@CrossOrigin("*")
@FeignClient(url = "http://localhost:8081",name = "tallmicroserviceclient")
public interface ClientService {
    @GetMapping("/clients/{id}")
    public Client findCustomerById(@PathVariable (name = "id") Long id);
}
