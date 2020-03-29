package com.mag.jwt.SecurityJwt.mapper;

import com.mag.jwt.SecurityJwt.dto.AdresseDTO;
import com.mag.jwt.SecurityJwt.model.Adresse;

public class AdresseMapper {

    public static AdresseDTO map(Adresse adresse) {
        if(adresse != null){
            AdresseDTO adresseDTO = new AdresseDTO();
            adresseDTO.setCodePostal(adresse.getCodePostal());
            adresseDTO.setCommune(adresse.getCommune());
            adresseDTO.setId(adresse.getId());
            adresseDTO.setNomRue(adresse.getNomRue());
            adresseDTO.setNumeroRue(adresse.getNumeroRue());
            adresseDTO.setTypeVoie(adresse.getTypeVoie());

            return adresseDTO;
        }
        return null;
    }
}
