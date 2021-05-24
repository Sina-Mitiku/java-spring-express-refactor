package com.launchacademy.petadoption.controllers;

import com.launchacademy.petadoption.models.AdoptablePet;
import com.launchacademy.petadoption.models.AdoptionApplication;
import com.launchacademy.petadoption.models.PetType;
import com.launchacademy.petadoption.services.AdoptablePetService;
import com.launchacademy.petadoption.services.AdoptionApplicationService;
import com.launchacademy.petadoption.services.PetTypeService;
import com.launchacademy.petadoption.services.SurrenderApplicationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PetsApiController {

private PetTypeService petService;
private AdoptablePetService adoptablePetService;
private AdoptionApplicationService adoptionApplicationService;
private SurrenderApplicationService surrenderApplicationService;

  @Autowired
  public PetsApiController(PetTypeService perService, AdoptablePetService adoptablePetService,
      AdoptionApplicationService adoptionApplicationService, SurrenderApplicationService surrenderApplicationService) {
    this.petService = perService;
    this.adoptablePetService = adoptablePetService;
    this.adoptionApplicationService = adoptionApplicationService;
    this.surrenderApplicationService = surrenderApplicationService;
  }

  @GetMapping("/pets")
  public List<PetType> getList() {
    return petService.findAll();
  }

  @GetMapping("pets/{type}")
  public List<AdoptablePet> getPetsList(@PathVariable String type) {
    return petService.findByTypeIgnoreCase(type).getAdoptablePets();
  }

  @GetMapping("pets/{type}/{animalId}")
  public AdoptablePet showOnePet(@PathVariable Integer animalId) {
    return adoptablePetService.findById(animalId);
    }

    @PostMapping("/application")
  public ResponseEntity createApplication(@RequestBody AdoptionApplication adoptionApplication) {
      AdoptionApplication newAdoptionApplication = new AdoptionApplication();
      newAdoptionApplication.setName(adoptionApplication.getName());
      newAdoptionApplication.setPhoneNumber(adoptionApplication.getPhoneNumber());
      newAdoptionApplication.setEmail(adoptionApplication.getEmail());
      newAdoptionApplication.setHomeStatus(adoptionApplication.getHomeStatus());
      newAdoptionApplication.setApplicationStatus("pending");
      newAdoptionApplication.setAdoptablePet(adoptablePetService.findById(adoptionApplication.getPetId()));
      return new ResponseEntity(adoptionApplicationService.adopt(newAdoptionApplication), HttpStatus.OK);
    }

  }





