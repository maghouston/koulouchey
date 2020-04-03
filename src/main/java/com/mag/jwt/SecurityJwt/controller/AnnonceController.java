package com.mag.jwt.SecurityJwt.controller;

import com.mag.jwt.SecurityJwt.dto.AnnonceDTO;
import com.mag.jwt.SecurityJwt.model.Annonce;
import com.mag.jwt.SecurityJwt.service.annonce.IAnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/annonce")
public class AnnonceController {
    
    @Autowired
    private IAnnonceService annonceService;

    @PostMapping("/")
    public ResponseEntity<Long> create(@RequestBody  Annonce annonce) {
        
        try{
            Long id = annonceService.createAnnonce(annonce);
            return ResponseEntity.status(200).body(id);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/see")
    public Page<AnnonceDTO> getAnnoncesPaged(@RequestParam("begin")int begin, @RequestParam("offset") int offset){
        Page<AnnonceDTO> annonces = annonceService.findAllPaged(begin,offset);
        return annonces;
    }
}
