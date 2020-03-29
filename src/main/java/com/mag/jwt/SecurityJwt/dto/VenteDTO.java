package com.mag.jwt.SecurityJwt.dto;

import com.mag.jwt.SecurityJwt.model.Annonce;
import com.mag.jwt.SecurityJwt.model.UserInfo;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class VenteDTO {

    private Long id;
    private List<AnnonceDTO> annonces;
    private UserDTO acheteur;
    private BigDecimal montantTotal;
    private Date dateVente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<AnnonceDTO> getAnnonces() {
        return annonces;
    }

    public void setAnnonces(List<AnnonceDTO> annonces) {
        this.annonces = annonces;
    }

    public UserDTO getAcheteur() {
        return acheteur;
    }

    public void setAcheteur(UserDTO acheteur) {
        this.acheteur = acheteur;
    }

    public BigDecimal getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(BigDecimal montantTotal) {
        this.montantTotal = montantTotal;
    }

    public Date getDateVente() {
        return dateVente;
    }

    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }


}
