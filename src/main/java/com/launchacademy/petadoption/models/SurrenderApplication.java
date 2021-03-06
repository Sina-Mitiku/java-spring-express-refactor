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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="pet_surrender_applications")
public class SurrenderApplication {
  @Id
  @SequenceGenerator(name="pet_surrender_applications_generator", sequenceName="pet_surrender_applications_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="pet_surrender_applications_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @NotBlank
  @Column(name="name", nullable=false)
  private String name;

  @NotBlank
  @Pattern(regexp="(^$|[0-9]{10})")
  @Column(name="phone_number", nullable=false)
  private String phoneNumber;

  @NotBlank
  @Email
  @Column(name="email", nullable=false)
  private String email;

  @NotBlank
  @Column(name="pet_name", nullable=false)
  private String petName;

  @NotNull
  @Positive
  @Column(name="pet_age", nullable=false)
  private int petAge;

  @NotBlank
  @URL
  @Column(name="pet_image_url", nullable=false)
  private String petImageUrl;

  @NotNull
  @Column(name="vaccination_status", nullable=false)
  private Boolean vaccinationStatus;

  @Column(name="application_status", nullable=false)
  private String applicationStatus;

  @Column(name="pet_type_id", updatable = false, insertable = false)
  private int petTypeId;

  @ManyToOne
  @JoinColumn(name="pet_type_id")
  private PetType petType;
}
