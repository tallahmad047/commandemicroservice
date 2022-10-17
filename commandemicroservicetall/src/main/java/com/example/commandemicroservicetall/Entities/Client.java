package com.example.commandemicroservicetall.Entities;

import lombok.Data;

@Data
public class Client {
    private Long id;
    private String nom ;
    private String prenom;
    private String email;
    private String adresse;
    private String tel;
}
