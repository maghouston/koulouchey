package com.mag.jwt.SecurityJwt.controller;

import com.mag.jwt.SecurityJwt.model.Categorie;
import com.mag.jwt.SecurityJwt.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/references")
public class CategoryController {

    @Autowired
    private CategorieRepository categorieRepository;

    @GetMapping("/categories")
    public List<Categorie> getCategories() {

       return categorieRepository.findAllOrderByLibelleAsc();
    }
}
