package com.example.commandemicroservicetall;

import com.example.commandemicroservicetall.Entities.Client;
import com.example.commandemicroservicetall.Entities.Commande;
import com.example.commandemicroservicetall.Entities.Produit;
import com.example.commandemicroservicetall.Entities.ProduitItem;
import com.example.commandemicroservicetall.dao.ProduitItemRepository;
import com.example.commandemicroservicetall.dao.RepositoryCommande;
import com.example.commandemicroservicetall.service.ClientService;
import com.example.commandemicroservicetall.service.InvetorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.Date;

@SpringBootApplication
@EnableFeignClients
@CrossOrigin("*")
public class CommandemicroservicetallApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommandemicroservicetallApplication.class, args);
    }
    @Bean
    CommandLineRunner star (RepositoryCommande repositoryCommande,
                            ProduitItemRepository produitItemRepository, ClientService clientService,
                            InvetorService invetorService, RepositoryRestConfiguration configuration){
        return args ->  {
            configuration.exposeIdsFor(Commande.class);
            Client c1=clientService.findCustomerById(1L);
            Client c2=clientService.findCustomerById(2L);
            Client c3=clientService.findCustomerById(2L);
            System.out.println("-------------------------------------");
            System.out.println("ID="+ c1.getId());
            System.out.println("addres="+ c1.getAdresse());
            System.out.println("nom="+ c1.getNom());
            System.out.println("tel="+ c1.getTel());
            System.out.println("email="+ c1.getEmail());
            System.out.println("prenom="+ c1.getPrenom());
            //System.out.println("ID="+ c1.get);
            System.out.println("-------------------------------------");
            Produit p1=invetorService.findProductById(1L);
            Produit p2=invetorService.findProductById(2L);
            Produit p3=invetorService.findProductById(3L);
            Commande com1=repositoryCommande.save(new Commande(null,new Date(),45,98566, c1.getId(),null, null));

            Collection<Produit> produits=  invetorService.findAllProduits();
            produits.forEach(p->{
                produitItemRepository.save(new ProduitItem(null,p.getId(), null,p.getPrice(), p.getQuantite(), com1));
            });
            Commande com2=repositoryCommande.save(new Commande(null,new Date(),45,98566, c2.getId(),null, null));
            produitItemRepository.save(new ProduitItem(null,p3.getId(), null,p3.getPrice(), p3.getQuantite(), com2));
            produitItemRepository.save(new ProduitItem(null,p2.getId(), null,p2.getPrice(), p2.getQuantite(), com2));
            Commande com3=repositoryCommande.save(new Commande(null,new Date(),45,98566, c3.getId(),null, null));
            produitItemRepository.save(new ProduitItem(null,p3.getId(), null,p3.getPrice(), p3.getQuantite(), com3));
            produitItemRepository.save(new ProduitItem(null,p2.getId(), null,p2.getPrice(), p2.getQuantite(), com3));





        };
    }

}
