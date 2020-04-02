package com.mag.jwt.SecurityJwt.controller;

import com.mag.jwt.SecurityJwt.model.ImageAnnonce;
import com.mag.jwt.SecurityJwt.service.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/")
    public ResponseEntity<String> uplaodImage(@RequestParam("imageFile") MultipartFile file,@RequestParam("idAnnonce")Long idAnnonce) throws IOException {
        String path = imageService.saveImage(file, idAnnonce);
        return ResponseEntity.status(HttpStatus.OK).body(path);
    }

    @GetMapping(path = { "/{imageId}" })
    public ImageAnnonce getImage(@PathVariable("imageId") Long imageId) throws IOException {
        final ImageAnnonce retrievedImage = imageService.getImageById(imageId);
        retrievedImage.setPicByte(decompressBytes(retrievedImage.getPicByte()));
        return retrievedImage;
    }
    // compress the image bytes before storing it in the database
    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }
    // uncompress the image bytes before returning it to the angular application
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }
}
