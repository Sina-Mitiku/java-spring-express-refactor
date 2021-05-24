package com.launchacademy.petadoption.services;


import com.launchacademy.petadoption.models.SurrenderApplication;
import com.launchacademy.petadoption.repositories.PetTypeRepository;
import com.launchacademy.petadoption.repositories.SurrenderApplicationRepository;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SurrenderApplicationService {
  private SurrenderApplicationRepository surrenderApplicationRepo;
  private PetTypeRepository petTypeRepository;

  @Autowired
  public SurrenderApplicationService(
      SurrenderApplicationRepository surrenderApplicationRepo, PetTypeRepository petTypeRepository) {
    this.surrenderApplicationRepo = surrenderApplicationRepo;
    this.petTypeRepository = petTypeRepository;
  }

  public SurrenderApplication addPet(SurrenderApplication surrenderApplication) {
    return surrenderApplicationRepo.save(surrenderApplication);
  }

  public SurrenderApplication saveSurrenderApp(Map<String, String> surrenderApplication) {
    SurrenderApplication newSurrenderApplication = new SurrenderApplication();
    newSurrenderApplication.setName(surrenderApplication.get("name"));
    newSurrenderApplication.setPhoneNumber(surrenderApplication.get("phoneNumber"));
    newSurrenderApplication.setEmail(surrenderApplication.get("email"));
    newSurrenderApplication.setPetName(surrenderApplication.get("petName"));
    newSurrenderApplication.setPetAge(Integer.parseInt(surrenderApplication.get("petAge")));
    newSurrenderApplication.setPetType(petTypeRepository.findByTypeIgnoreCase(surrenderApplication.get("petType")));
    newSurrenderApplication.setPetImageUrl(surrenderApplication.get("petImageUrl"));
    newSurrenderApplication.setApplicationStatus("pending");
    newSurrenderApplication.setVaccinationStatus(Boolean.parseBoolean(surrenderApplication.get("vaccinationStatus")));
    return surrenderApplicationRepo.save(newSurrenderApplication);
  }
}
