package com.mag.jwt.SecurityJwt.mapper;

import com.mag.jwt.SecurityJwt.dto.AnnonceDTO;
import com.mag.jwt.SecurityJwt.dto.CategorieDTO;
import com.mag.jwt.SecurityJwt.model.Annonce;

public class AnnonceMapper {

    public static AnnonceDTO map(Annonce annonce){
        if(annonce != null) {
            AnnonceDTO annonceDTO = new AnnonceDTO();
            annonceDTO.setDatePublication(annonce.getDatePublication());
            annonceDTO.setId(annonce.getId());
            annonceDTO.setLibelle(annonce.getLibelle());
            annonceDTO.setPrix(annonce.getPrix());
            annonceDTO.setVendeur(UserMapper.map(annonce.getVendeur()));
            annonceDTO.setVente(VenteMapper.map(annonce.getVente()));
            annonceDTO.setCategorie(CategorieMapper.map(annonce.getCategorie()));
            return annonceDTO;
        }
        return null;
    }

}
