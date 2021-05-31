package com.launchacademy.petadoption.repositories;

import com.launchacademy.petadoption.models.AdoptablePet;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptablePetRepository extends CrudRepository<AdoptablePet, Integer> {

  @Query("select a from AdoptablePet a where a.typeId = :petTypeId")
  List<AdoptablePet> findByPetTypeId(@Param("petTypeId") Integer petTypeId);

  @Query("select a from AdoptablePet a where a.typeId = :petTypeId and a.id = :animalId")
  public AdoptablePet findByAnimalId(@Param("petTypeId") Integer petTypeId, @Param("animalId") Integer animalId);
}
