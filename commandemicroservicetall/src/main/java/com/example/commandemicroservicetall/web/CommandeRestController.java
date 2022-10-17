package com.example.commandemicroservicetall.web;

import com.example.commandemicroservicetall.Entities.Commande;
import com.example.commandemicroservicetall.dao.ProduitItemRepository;
import com.example.commandemicroservicetall.dao.RepositoryCommande;
import com.example.commandemicroservicetall.service.ClientService;
import com.example.commandemicroservicetall.service.InvetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class CommandeRestController {
    @Autowired
    private RepositoryCommande repositoryCommande;
    @Autowired
    private ProduitItemRepository produitItemRepository;
    @Autowired
    private ClientService clientService;
    @Autowired
    private InvetorService invetorService;
    @GetMapping("/fullCommande/{id}")
    public Commande getCommande(@PathVariable (name = "id") Long id){
        Commande commande=repositoryCommande.findById(id).get();
        commande.setClient(clientService.findCustomerById(commande.getIdClient()));
        commande.getProduitItems().forEach(produitItem -> {
            produitItem.setProduit(invetorService.findProductById(produitItem.getProduitId()));
        });
        return  commande;
    }
    @PutMapping("/commandes/{id}")
    public Commande update(@PathVariable Long id, @RequestBody Commande com){
        Commande  moncommande =repositoryCommande.findById(id).orElseThrow();
        if(com.getQuantite() !=0) moncommande.setQuantite( com.getQuantite());
         moncommande.setClient(clientService.findCustomerById(moncommande.getIdClient()));
        moncommande.getProduitItems().forEach(produitItem -> {
            produitItem.setProduit(invetorService.findProductById(produitItem.getProduitId()));
        });

        return repositoryCommande.save(moncommande);


    }
}
