package com.launchacademy.petadoption.repositories;

import com.launchacademy.petadoption.models.PetType;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeRepository extends CrudRepository<PetType, Integer> {
 PetType findByTypeIgnoreCase(String type);

 PetType findByType(PetType petType);

}
