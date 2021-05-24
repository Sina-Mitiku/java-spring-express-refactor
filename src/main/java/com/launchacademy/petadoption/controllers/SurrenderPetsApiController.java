package com.launchacademy.petadoption.controllers;


import com.launchacademy.petadoption.models.SurrenderApplication;
import com.launchacademy.petadoption.services.AdoptablePetService;
import com.launchacademy.petadoption.services.PetTypeService;
import com.launchacademy.petadoption.services.SurrenderApplicationService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class SurrenderPetsApiController {

  private SurrenderApplicationService surrenderApplicationService;

  @Autowired
  public SurrenderPetsApiController(SurrenderApplicationService surrenderApplicationService ) {
    this.surrenderApplicationService = surrenderApplicationService;
  }

  @PostMapping("/surrender")
  public SurrenderApplication addPet(@RequestBody Map<String, String> surrenderApplication) {
    return surrenderApplicationService.saveSurrenderApp(surrenderApplication);
  }
}
