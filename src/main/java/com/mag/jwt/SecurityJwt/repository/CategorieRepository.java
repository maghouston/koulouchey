package com.mag.jwt.SecurityJwt.repository;

import com.mag.jwt.SecurityJwt.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

    @Query("From Categorie order by libelle asc")
    List<Categorie> findAllOrderByLibelleAsc();
}
