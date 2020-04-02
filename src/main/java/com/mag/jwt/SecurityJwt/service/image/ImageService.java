package com.mag.jwt.SecurityJwt.service.image;

import com.mag.jwt.SecurityJwt.model.ImageAnnonce;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {

    public ImageAnnonce save(ImageAnnonce imageAnnonce);

    public List<ImageAnnonce> getImageByANnonceId(Long annonceId);

    public ImageAnnonce getImageById(Long imageId);

    String saveImage(MultipartFile image, Long idAnnonce);
}
