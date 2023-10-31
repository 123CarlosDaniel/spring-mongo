package com.cdcm.example.repository;

import com.cdcm.example.collection.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhotoRepository extends MongoRepository<Photo, String> {
}
