package com.example.commandemicroservicetall.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
public class Commande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date DateCom;
    private int quantite;
    private double montant;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long idClient;

    @Transient
    private  Client client;
     @OneToMany(mappedBy ="commande")
    private Collection<ProduitItem> produitItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCom() {
        return DateCom;
    }

    public void setDateCom(Date dateCom) {
        DateCom = dateCom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public Collection<ProduitItem> getProduitItems() {
        return produitItems;
    }

    public void setProduitItems(Collection<ProduitItem> produitItems) {
        this.produitItems = produitItems;
    }
}
