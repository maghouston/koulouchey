package com.mag.jwt.SecurityJwt.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "VENTE")
public class Vente {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "vente")
    private List<Annonce> annonces;
    @OneToOne
    @JoinColumn(name = "ACHETEUR_FK")
    private UserInfo acheteur;

    @Column(name = "MONTANT_VENTE")
    private BigDecimal montantTotal;

    @Column(name = "DATE_VENTE")
    private Date dateVente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Annonce> getAnnonces() {
        return annonces;
    }

    public void setAnnonces(List<Annonce> annonces) {
        this.annonces = annonces;
    }

    public UserInfo getAcheteur() {
        return acheteur;
    }

    public void setAcheteur(UserInfo acheteur) {
        this.acheteur = acheteur;
    }

    public BigDecimal getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(BigDecimal montantTotal) {
        this.montantTotal = montantTotal;
    }


}
