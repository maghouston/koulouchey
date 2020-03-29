package com.mag.jwt.SecurityJwt.dto;

public class CategorieDTO {
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

    private Long id;
    private String libelle;
}
