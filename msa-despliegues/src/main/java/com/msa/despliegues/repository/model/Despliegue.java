package com.msa.despliegues.repository.model;

import static jakarta.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PRIVATE;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "despliegue")
@FieldDefaults(level = PRIVATE)
public class Despliegue {

  @Id
  @GeneratedValue(strategy = AUTO)
  UUID id;

  UUID proyectoId;
  UUID maquinaId;
  LocalDate fechaDespliegue;
  Boolean activo;
}
