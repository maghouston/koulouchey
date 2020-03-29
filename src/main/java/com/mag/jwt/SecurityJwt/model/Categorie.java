package com.mag.jwt.SecurityJwt.model;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORIE")
public class Categorie {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "LIBELLE")
    private String libelle;

}
