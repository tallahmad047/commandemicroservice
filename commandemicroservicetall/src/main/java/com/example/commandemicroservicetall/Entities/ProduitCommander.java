package com.example.commandemicroservicetall.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor@ToString
public class ProduitCommander implements Serializable {
    //private Produit produit;
    private int Quantite;
    private double montant;
}
