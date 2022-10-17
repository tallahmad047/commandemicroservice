package com.example.commandemicroservicetall.Entities;

import lombok.Data;

@Data
public class Produit {
    private Long id;
    private String  designtion;
    private double  price;
    private int quantite;
    private String description;
    private String photoProd;
    private String categorie;
}
