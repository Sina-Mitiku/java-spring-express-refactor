package com.launchacademy.petadoption.services;


import com.launchacademy.petadoption.models.PetType;
import com.launchacademy.petadoption.repositories.PetTypeRepository;
import java.util.List;
import java.util.Optional;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class PetTypeService {

  private PetTypeRepository petTypeRepo;

  @Autowired
  public PetTypeService(PetTypeRepository petTypeRepo) {
    this.petTypeRepo = petTypeRepo;
  }

  @NoArgsConstructor
  private class PetTypeNotFoundException extends RuntimeException {

  }

  @ControllerAdvice
  private class PetTypeNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(PetTypeService.PetTypeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String petNotFoundHandler(PetTypeService.PetTypeNotFoundException ex) {
      return ex.getMessage();
    }
  }

  public List<PetType> findAll() {
    return (List<PetType>) petTypeRepo.findAll();
  }

  public PetType findByType(String type) {
    Optional<PetType> typePet = Optional.ofNullable(petTypeRepo.findByTypeIgnoreCase(type));
    return typePet.orElseThrow(() -> new PetTypeNotFoundException());
  }
}
