package com.example.commandemicroservicetall.dao;

import com.example.commandemicroservicetall.Entities.Commande;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface RepositoryCommande extends JpaRepository<Commande,Long> {
}
