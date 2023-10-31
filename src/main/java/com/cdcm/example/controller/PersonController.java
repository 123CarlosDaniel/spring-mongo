package com.cdcm.example.controller;

import com.cdcm.example.collection.Person;
import com.cdcm.example.service.PersonService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping
    public String save(@RequestBody Person person) {
        return personService.save(person);
    }
    @GetMapping
    public List<Person> fetchUsersByNameStartsWith(@RequestParam("name") String name) {
        return personService.getUsersByNameStartsWith(name);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        personService.deleteById(id);
    }

    @GetMapping("/age")
    public List<Person> fetchUsersByAge(@RequestParam("min") Integer minAge, @RequestParam("max") Integer maxAge) {
        return personService.getPersonsByAge(minAge, maxAge);
    }

    @GetMapping("/search")
    public Page<Person> searchPerson(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String minAge,
            @RequestParam(required = false) String maxAge,
            @RequestParam(required = false) String city,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "5") Integer size
            ) {
        Pageable pageable = PageRequest.of(page, size);
        return personService.search(name, minAge, maxAge, city, pageable);
    }

    @GetMapping("/oldest")
    public List<Document> getOldest(){
        return personService.getOldestPersonByCity();
    }

    @GetMapping("/population")
    public List<Document> getPopByCity() {
        return personService.getPopByCity();
    }
}
