package com.cdcm.example.service;

import com.cdcm.example.collection.Person;
import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {
    String save(Person person);

    List<Person> getUsersByNameStartsWith(String name);

    void deleteById(String id);

    List<Person> getPersonsByAge(Integer minAge, Integer maxAge);

    Page<Person> search(String name, String minAge, String maxAge, String city, Pageable pageable);

    List<Document> getOldestPersonByCity();

    List<Document> getPopByCity();
}
