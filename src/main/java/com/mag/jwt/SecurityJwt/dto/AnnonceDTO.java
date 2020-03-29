package com.mag.jwt.SecurityJwt.dto;

import java.math.BigDecimal;
import java.util.Date;

public class AnnonceDTO {

    private CategorieDTO categorie;

    public CategorieDTO getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieDTO categorie) {
        this.categorie = categorie;
    }

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

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public UserDTO getVendeur() {
        return vendeur;
    }

    public void setVendeur(UserDTO vendeur) {
        this.vendeur = vendeur;
    }

    public VenteDTO getVente() {
        return vente;
    }

    public void setVente(VenteDTO vente) {
        this.vente = vente;
    }

    private Long id;
    private String libelle;
    private BigDecimal prix;
    private Date datePublication;
    private UserDTO vendeur;
    private VenteDTO vente;
}
