package com.mag.jwt.SecurityJwt.mapper;

import com.mag.jwt.SecurityJwt.dto.VenteDTO;
import com.mag.jwt.SecurityJwt.model.Vente;

import java.util.stream.Collectors;

public class VenteMapper {

    public static VenteDTO map(Vente vente){
        if(vente != null){
            VenteDTO venteDTO = new VenteDTO();
            venteDTO.setAcheteur(UserMapper.map(vente.getAcheteur()));
            venteDTO.setAnnonces(vente.getAnnonces().stream()
                                                    .map(AnnonceMapper::map)
                                                    .collect(Collectors.toList()));
            return venteDTO;
        }
        return null;
    }
}
