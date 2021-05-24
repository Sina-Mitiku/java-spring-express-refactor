package com.launchacademy.petadoption.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="adoption_application")
public class AdoptionApplication {
  @Id
  @SequenceGenerator(name="adoption_application_generator", sequenceName="adoption_application_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="adoption_application_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @Column(name="name", nullable=false)
  private String name;

  @Column(name="phone_number", nullable=false)
  private String phoneNumber;

  @Column(name="email", nullable=false)
  private String email;

  @Column(name="home_status", nullable=false)
  private String homeStatus;

  @Column(name="application_status", nullable=false)
  private String applicationStatus;

  @Column(name="pet_id", updatable = false, insertable = false)
  private int petId;

  @ManyToOne
  @JoinColumn(name="pet_id")
  private AdoptablePet adoptablePet;

  public void setAdoptablePet(AdoptablePet adoptablePet) {
    this.adoptablePet = adoptablePet;
  }
}
