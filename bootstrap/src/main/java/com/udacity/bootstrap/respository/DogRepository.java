package com.udacity.bootstrap.respository;

import com.udacity.bootstrap.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {
    @Query("select Breed from Dog")
    List<String> retrieveDogBreed();

    @Query("select Breed from Dog where id = id")
    String retrieveDogBreedById(Long id);

    @Query("select Name from Dog")
    List<String> retrieveDogNames();
}
