package com.mag.jwt.SecurityJwt.repository;

import com.mag.jwt.SecurityJwt.model.ImageAnnonce;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ImageRepository extends JpaRepository<ImageAnnonce, Long> {
    Optional<ImageAnnonce> findByName(String name);
    List<ImageAnnonce> findByIdAnnonce(Long idAnnonce);
}
