package com.launchacademy.petadoption.services;

import com.launchacademy.petadoption.models.AdoptablePet;
import com.launchacademy.petadoption.models.PetType;
import com.launchacademy.petadoption.repositories.PetTypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetTypeService {
  private PetTypeRepository petTypeRepo;

  @Autowired
  public PetTypeService(PetTypeRepository petTypeRepo) {
    this.petTypeRepo = petTypeRepo;
  }

  public List<PetType> findAll() {
    return (List<PetType>) petTypeRepo.findAll();
  }

public PetType findByTypeIgnoreCase(String type) {
    return petTypeRepo.findByTypeIgnoreCase(type);
}

  public PetType findById(Integer id) {
    return this.petTypeRepo.findById(id).get();
  }

  public PetType findByType(PetType petType) {
    return this.petTypeRepo.findByType(petType);
  }
}
