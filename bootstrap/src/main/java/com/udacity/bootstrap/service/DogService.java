package com.udacity.bootstrap.service;

import com.udacity.bootstrap.entity.Dog;
import com.udacity.bootstrap.respository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {
    @Autowired
    private DogRepository dogRepository;

    public List<String> retrieveDogBreed() {
        return dogRepository.retrieveDogBreed();
    }

    public String retrieveDogBreedById(Long id) {
        return dogRepository.retrieveDogBreedById(id);
    }

    public List<String> retrieveDogNames() {
        return dogRepository.retrieveDogNames();
    }

}
