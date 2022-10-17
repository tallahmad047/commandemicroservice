package com.example.commandemicroservicetall.Entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;
import java.util.Date;

/**
 * A Projection for the {@link Commande} entity
 */
@Projection(name = "fullcommande",types = Commande.class)

public interface CommandeInfo {
    Long getId();

    Date getDateCom();

    int getQuantite();

    double getMontant();

    Long getIdClient();

    Collection<ProduitItemInfo> getProduitItems();
}