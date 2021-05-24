package com.launchacademy.petadoption.services;

import com.launchacademy.petadoption.controllers.PetsApiController;

import com.launchacademy.petadoption.models.AdoptablePet;
import com.launchacademy.petadoption.models.PetType;
import com.launchacademy.petadoption.repositories.AdoptablePetRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class AdoptablePetService {
  AdoptablePetRepository adoptablePetRepo;

  @Autowired
  public AdoptablePetService(
      AdoptablePetRepository adoptablePetRepo) {
    this.adoptablePetRepo = adoptablePetRepo;
  }

  @NoArgsConstructor
  private class PetNotFoundException extends RuntimeException {};

  @ControllerAdvice
  private class PetNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(PetNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String petNotFoundHandler(PetNotFoundException ex) {
      return ex.getMessage();
    }
  }

  public AdoptablePet findById(Integer id) {
    return this.adoptablePetRepo.findById(id).orElseThrow(() -> new PetNotFoundException());
  }

}
