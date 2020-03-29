package com.mag.jwt.SecurityJwt.mapper;

import com.mag.jwt.SecurityJwt.dto.CategorieDTO;
import com.mag.jwt.SecurityJwt.model.Categorie;

public class CategorieMapper {

    public static CategorieDTO map(Categorie categorie){
        if(categorie != null) {
            CategorieDTO categorieDTO = new CategorieDTO();
            categorieDTO.setId(categorie.getId());
            categorieDTO.setLibelle(categorie.getLibelle());
            return categorieDTO;
        }
        return null;
    }
}
