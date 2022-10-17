package com.example.commandemicroservicetall.service;

import com.example.commandemicroservicetall.Entities.Client;
import com.example.commandemicroservicetall.Entities.Produit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
@CrossOrigin("*")
@FeignClient(url = "http://localhost:8084",name = "tallmicroserviceproduit")
public interface InvetorService {
    @GetMapping("/produits/{id}")
    public Produit findProductById(@PathVariable(name = "id") Long id);
    @GetMapping("/produits")
    public Collection<Produit> findAllProduits();
}
