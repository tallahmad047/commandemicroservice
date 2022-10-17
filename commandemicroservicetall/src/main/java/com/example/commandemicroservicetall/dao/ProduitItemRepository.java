package com.example.commandemicroservicetall.dao;

import com.example.commandemicroservicetall.Entities.ProduitItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface ProduitItemRepository extends JpaRepository<ProduitItem,Long> {
}
