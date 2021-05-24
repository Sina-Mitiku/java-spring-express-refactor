package com.launchacademy.petadoption.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="adoptable_pets")
public class AdoptablePet {
  @Id
  @SequenceGenerator(name="adoptable_pets_generator", sequenceName = "adoptable_pets_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="adoptable_pets_generator")
  @Column(name="id", nullable = false, unique = true)
  private Integer id;

  @Column(name="name", nullable=false)
  private String name;

  @Column(name="img_url", nullable=false)
  private String imgUrl;

  @Column(name="age", nullable=false)
  private int age;

  @Column(name="vaccination_status", nullable=false)
  private Boolean vaccinationStatus;

  @Column(name="adoption_story", nullable=false)
  private String adoptionStory;

  @Column(name="adoption_status", nullable=false)
  private String  adoptionStatus;

  @Column(name="type_id", updatable = false, insertable = false)
  private int typeId;

  @ManyToOne
  @JoinColumn(name="type_id")
  private PetType petType;

  public void setPetType(PetType petType) {
    this.petType = petType;
  }

  @OneToMany(fetch= FetchType.LAZY, mappedBy = "adoptablePet")
  @JsonIgnoreProperties("adoptablePet")
  private List<AdoptionApplication> adoptionApplications = new ArrayList<>();
}

