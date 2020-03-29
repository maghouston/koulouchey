package com.mag.jwt.SecurityJwt.repository;

import com.mag.jwt.SecurityJwt.model.Annonce;
import com.mag.jwt.SecurityJwt.model.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

public interface AnnonceRepository extends PagingAndSortingRepository<Annonce, Long> {

    Page<Annonce> findByLibelleContainingOrderByDatePublicationDesc(String libelle, Pageable pageable);
    Page<Annonce> findByDatePublicationAfterOrderByDatePublicationDesc(Date publicationDate, Pageable pageable);
}
