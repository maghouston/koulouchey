package com.mag.jwt.SecurityJwt.service.annonce;

import com.mag.jwt.SecurityJwt.dto.AnnonceDTO;
import com.mag.jwt.SecurityJwt.model.Annonce;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public interface IAnnonceService {

    Long createAnnonce(Annonce annonce);
    Page<AnnonceDTO> findAllPaged(int begin, int offset);
    Page<AnnonceDTO> findByCriteriaPaged(Annonce annonce, int begin, int offset);
    Page<AnnonceDTO> findByLibelleContainingOrderByDatePublicationDesc(String libelle, int begin, int offset);
    Page<AnnonceDTO> findByDatePublicationAfterOrderByDatePublicationDesc(Date publicationDate, int begin, int offset);
}
