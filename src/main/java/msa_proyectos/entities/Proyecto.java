package msa_proyectos.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import java.time.LocalDate;
import java.util.UUID;
import lombok.*;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "proyecto")
public class Proyecto {

  @Id
  @GeneratedValue
  @Column(columnDefinition = "uuid", updatable = false, nullable = false)
  private UUID id;

  private String nombre;

  private String descripcion;

  private LocalDate fechainicio;

  private boolean activo;

  // ✅ Constructor por defecto requerido por JPA/Hibernate
  public Proyecto() {}

  public Proyecto(String nombre, String descripcion, LocalDate fechainicio, boolean activo) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.fechainicio = fechainicio;
    this.activo = activo;
  }
}
