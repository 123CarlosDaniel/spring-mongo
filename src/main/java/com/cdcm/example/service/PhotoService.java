package com.cdcm.example.service;

import com.cdcm.example.collection.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PhotoService {
    String addPhoto(String originalFilename, MultipartFile image) throws IOException;

    Photo getPhoto(String id);
}
