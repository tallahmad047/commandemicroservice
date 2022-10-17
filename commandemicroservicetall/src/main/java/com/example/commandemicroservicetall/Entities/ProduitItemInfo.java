package com.example.commandemicroservicetall.Entities;

/**
 * A Projection for the {@link ProduitItem} entity
 */
public interface ProduitItemInfo {
    Long getProduitId();

    double getPrix();

    double getQuantite();
}