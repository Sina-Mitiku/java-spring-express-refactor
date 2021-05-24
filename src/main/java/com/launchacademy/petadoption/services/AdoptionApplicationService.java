package com.launchacademy.petadoption.services;

import com.launchacademy.petadoption.models.AdoptablePet;
import com.launchacademy.petadoption.models.AdoptionApplication;
import com.launchacademy.petadoption.repositories.AdoptablePetRepository;
import com.launchacademy.petadoption.repositories.AdoptionApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AdoptionApplicationService {
  private AdoptionApplicationRepository adoptionApplicationRepo;
  private AdoptablePetRepository adoptablePetRepo;

  @Autowired
  public AdoptionApplicationService(
      AdoptionApplicationRepository adoptionApplicationRepo, AdoptablePetRepository adoptablePetRepo) {
    this.adoptionApplicationRepo = adoptionApplicationRepo;
    this.adoptablePetRepo = adoptablePetRepo;
  }

  public AdoptionApplication adopt(AdoptionApplication adoptionApplication) {
    return adoptionApplicationRepo.save(adoptionApplication);
  }

}
