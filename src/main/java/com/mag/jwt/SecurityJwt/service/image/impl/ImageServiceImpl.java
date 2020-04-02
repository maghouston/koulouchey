package com.mag.jwt.SecurityJwt.service.image.impl;

import com.mag.jwt.SecurityJwt.model.ImageAnnonce;
import com.mag.jwt.SecurityJwt.repository.ImageRepository;
import com.mag.jwt.SecurityJwt.service.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Value("${images.folder}")
    private String imagesFolder;

    @Override
    public ImageAnnonce save(ImageAnnonce imageAnnonce) {
        return imageRepository.save(imageAnnonce);
    }

    @Override
    public List<ImageAnnonce> getImageByANnonceId(Long annonceId) {
        return imageRepository.findByIdAnnonce(annonceId);
    }

    @Override
    public ImageAnnonce getImageById(Long imageId) {
        return imageRepository.findById(imageId).orElse(null);
    }

    @Override
    public String saveImage(MultipartFile imageFile, Long idAnnonce) {
        String uri = "";
        try {

            File file = new File(imagesFolder+File.separator+idAnnonce);
            if(!file.exists()) {
                file.mkdir();
            }

            Path currentPath = Paths.get(imagesFolder,""+idAnnonce);
            Path absolutePath = currentPath.toAbsolutePath();

            String extension = imageFile.getOriginalFilename().substring(imageFile.getOriginalFilename().lastIndexOf(".") + 1);
            String libelle = file.list().length+1+"."+extension;

            byte[] bytes = imageFile.getBytes();
            Path path = Paths.get(absolutePath+File.separator + libelle);
            Path saved = Files.write(path, bytes);
            uri = idAnnonce+"/"+imageFile.getOriginalFilename();
        }catch (IOException ex) {

        }
        return uri;
    }
}
