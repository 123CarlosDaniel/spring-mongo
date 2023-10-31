package com.cdcm.example.repository;

import com.cdcm.example.collection.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
    List<Person> findByFirstNameStartsWith(String firstName);

//    List<Person> findByAgeBetween(Integer min, Integer max);
//  fields filtra
    @Query(value = "{'age': {$gt: ?0, $lt: ?1}}", fields = "{addresses:0}")
    List<Person> findPersonByAgeBetween(Integer min, Integer max);
}
