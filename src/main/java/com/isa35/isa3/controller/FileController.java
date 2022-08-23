package com.isa35.isa3.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping("/uploads")
public class FileController {

    String FILE_PATH_IMAGES = "/home/birdpersson/isa/images/";

    @GetMapping("/{filename}")
    public ResponseEntity<byte[]> getImage(@PathVariable("filename") String filename) throws IOException {
        byte[] image;
        try {
            image = FileUtils.readFileToByteArray(new File(FILE_PATH_IMAGES + filename));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().contentType(MediaType.valueOf(Files.probeContentType(Path.of(FILE_PATH_IMAGES + filename)))).body(image);
    }

}
