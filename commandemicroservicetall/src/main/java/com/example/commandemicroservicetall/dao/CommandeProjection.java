package com.example.commandemicroservicetall.dao;

import com.example.commandemicroservicetall.Entities.Commande;
import com.example.commandemicroservicetall.Entities.ProduitItem;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.Date;
@CrossOrigin(value = "*")
@Projection(name = "fullcommande",types = Commande.class)
 public  interface CommandeProjection {

    Long getId();
    Date getDateCom();
    int getQuantite();
    Double getMontant();
    Long getIdClient();
    Collection<ProduitItem> getProduitItems();


}
