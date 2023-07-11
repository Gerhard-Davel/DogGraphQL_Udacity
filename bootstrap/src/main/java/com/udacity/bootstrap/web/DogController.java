package com.udacity.bootstrap.web;

import com.udacity.bootstrap.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

//@RestController
@Controller
public class DogController {

    @Autowired
    private DogService dogService;


    @GetMapping("/dog-breed")
    public ResponseEntity<List<String>> retrieveDogBreeds() {
        try {
            List<String> dogBreeds = dogService.retrieveDogBreed();
            return ResponseEntity.ok(dogBreeds);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/dog-breed/{id}")
    public ResponseEntity<List<String>> retrieveDogBreedsByID(@PathVariable Long id) {
        if (id > 5) {
            return ResponseEntity.notFound().build();
        }
        try {
            String dogBreedsID = dogService.retrieveDogBreedById(id);
            return ResponseEntity.ok(Collections.singletonList(dogBreedsID));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("/dog-names")
    public ResponseEntity<List<String>> retrieveDogNames() {
        try {
            List<String> dogNames = dogService.retrieveDogNames();
            return ResponseEntity.ok(dogNames);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
