package com.mag.jwt.SecurityJwt.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ANNONCE")
public class Annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "LIBELLE")
    private String libelle;
    @Column(name = "PRIX")
    private BigDecimal prix;
    @Column(name = "DATE_PUBLICATION")
    private Date datePublication;

    @ManyToOne
    @JoinColumn(name = "VENDEUR_FK")
    private UserInfo vendeur;

    @ManyToOne
    @JoinColumn(name = "VENTE_FK")
    private Vente vente;

    public Vente getVente() {
        return vente;
    }

    public void setVente(Vente vente) {
        this.vente = vente;
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

    public UserInfo getVendeur() {
        return vendeur;
    }

    public void setVendeur(UserInfo vendeur) {
        this.vendeur = vendeur;
    }


}
