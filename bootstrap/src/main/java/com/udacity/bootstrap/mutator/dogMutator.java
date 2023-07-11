package com.udacity.bootstrap.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.bootstrap.entity.Dog;
import com.udacity.bootstrap.exception.dogNotFoundException;
import com.udacity.bootstrap.respository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class dogMutator implements GraphQLMutationResolver {
    private DogRepository dogRepository;

    public dogMutator(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Dog newDog(String name, String breed, String origin) {
        Dog newDog = new Dog(name, breed, origin);
        dogRepository.save(newDog);
        return newDog;
    }

    public boolean deleteDog(Long id) {
        Optional<Dog> dogLocations = dogRepository.findById(id);
        if (dogLocations.isPresent()) {
            dogRepository.deleteById(id);
            return true;
        } else {
            throw new dogNotFoundException("dog not found", id);
        }

    }

    public Dog updateDogName(String name, Long id) {
        Optional<Dog> dogLocations = dogRepository.findById(id);
        if (dogLocations.isPresent()) {
            Dog dog = dogLocations.get();
            dog.setName(name);
            dogRepository.save(dog);
            return dog;
        } else {
            throw new dogNotFoundException("dog not found", id);
        }
    }
}
