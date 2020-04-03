package com.mag.jwt.SecurityJwt.service.annonce.impl;

import com.mag.jwt.SecurityJwt.dto.AdresseDTO;
import com.mag.jwt.SecurityJwt.dto.AnnonceDTO;
import com.mag.jwt.SecurityJwt.dto.UserDTO;
import com.mag.jwt.SecurityJwt.mapper.AnnonceMapper;
import com.mag.jwt.SecurityJwt.model.Annonce;
import com.mag.jwt.SecurityJwt.repository.AnnonceRepository;
import com.mag.jwt.SecurityJwt.service.annonce.IAnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnonceService implements IAnnonceService {

    @Autowired
    private AnnonceRepository annonceRepository;

    @Override
    public Long createAnnonce(Annonce annonce) {
        annonce.setDatePublication(new Date());
        return annonceRepository.save(annonce).getId();
    }

    @Override
    public Page<AnnonceDTO> findAllPaged(int begin, int offset) {
        Pageable pageable = PageRequest.of(begin, offset);
        Page<Annonce> pages = annonceRepository.findAll(pageable);
        List<AnnonceDTO> annonces = pages.getContent().stream().map(AnnonceMapper::map).collect(Collectors.toList());
        Page<AnnonceDTO> result = new PageImpl<AnnonceDTO>(annonces,pageable,pages.getTotalElements());
        return result;
    }

    @Override
    public Page<AnnonceDTO> findByCriteriaPaged(Annonce annonce, int begin, int offset) {
        Pageable pageable = PageRequest.of(begin, offset);
        return null;
    }

    @Override
    public Page<AnnonceDTO> findByLibelleContainingOrderByDatePublicationDesc(String libelle, int begin, int offset) {
        Pageable pageable = PageRequest.of(begin, offset);
        Page<Annonce> pages = annonceRepository.findByLibelleContainingOrderByDatePublicationDesc(libelle,pageable);
        List<AnnonceDTO> annonces = pages.getContent().stream().map(AnnonceMapper::map).collect(Collectors.toList());
        Page<AnnonceDTO> result = new PageImpl<AnnonceDTO>(annonces,pageable,pages.getTotalElements());
        return result;
    }

    @Override
    public Page<AnnonceDTO> findByDatePublicationAfterOrderByDatePublicationDesc(Date publicationDate, int begin, int offset) {
        Pageable pageable = PageRequest.of(begin, offset);
        Page<Annonce> pages = annonceRepository.findByDatePublicationAfterOrderByDatePublicationDesc(publicationDate,pageable);
        List<AnnonceDTO> annonces = pages.getContent().stream().map(AnnonceMapper::map).collect(Collectors.toList());
        Page<AnnonceDTO> result = new PageImpl<AnnonceDTO>(annonces,pageable,pages.getTotalElements());
        return result;
    }



}
