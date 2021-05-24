package com.launchacademy.petadoption.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="pet_types")
public class PetType {
  @Id
  @SequenceGenerator(name="pet_types_generator", sequenceName="pet_types_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="pet_types_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @Column(name="type", nullable=false)
  private String type;

  @Column(name="img_url", nullable=false)
  private String imgUrl;

  @Column(name="description", nullable=false)
  private String description;

  @OneToMany(fetch= FetchType.LAZY, mappedBy = "petType", cascade = CascadeType.ALL)
  @JsonIgnoreProperties("petType")
  private List<AdoptablePet> adoptablePets = new ArrayList<>();

  @OneToMany(mappedBy = "petType", cascade = CascadeType.ALL)
  @JsonIgnoreProperties("petType")
  private List<SurrenderApplication> surrenderApplications = new ArrayList<>();
}