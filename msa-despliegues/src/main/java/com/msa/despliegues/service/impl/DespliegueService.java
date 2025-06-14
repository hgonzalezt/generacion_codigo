package com.msa.despliegues.service.impl;

import static lombok.AccessLevel.PRIVATE;

import com.msa.despliegues.dto.GenericResponse;
import com.msa.despliegues.repository.IDespliegueRepository;
import com.msa.despliegues.repository.model.Despliegue;
import com.msa.despliegues.service.IDespliegueService;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class DespliegueService implements IDespliegueService {

  IDespliegueRepository repository;

  @Override
  public GenericResponse<Object> getAll() {
    return GenericResponse.builder().data(repository.getAll()).message("OK").build();
  }

  @Override
  public GenericResponse<Object> getById(UUID id) {
    return GenericResponse.builder().data(repository.getById(id)).message("OK").build();
  }

  @Override
  public GenericResponse<Object> getByProyectoId(UUID proyectoId) {
    List<Despliegue> despliegues = repository.getByProyectoId(proyectoId);
    return GenericResponse.builder()
        .data(despliegues)
        .message(
            despliegues.isEmpty()
                ? "No se encontraron despliegues para el proyectoId: " + proyectoId
                : "OK")
        .build();
  }

  @Override
  public GenericResponse<Object> getByMaquinaId(UUID maquinaId) {
    List<Despliegue> despliegues = repository.getByMaquinaId(maquinaId);
    return GenericResponse.builder()
        .data(despliegues)
        .message(
            despliegues.isEmpty()
                ? "No se encontraron despliegues para el maquinaId: " + maquinaId
                : "OK")
        .build();
  }

  @Override
  @Transactional
  public GenericResponse<Object> createDespliegue(Despliegue despliegue) {
    if (despliegue.getProyectoId() == null || despliegue.getMaquinaId() == null) {
      return GenericResponse.builder().message("proyectoId y maquinaId son requeridos").build();
    }

    if (despliegue.getFechaDespliegue() == null) {
      despliegue.setFechaDespliegue(LocalDate.now());
    }
    if (despliegue.getActivo() == null) {
      despliegue.setActivo(true);
    }

    try {
      Despliegue despliegueGuardado = repository.save(despliegue);
      return GenericResponse.builder()
          .data(despliegueGuardado)
          .message("Despliegue creado exitosamente")
          .build();
    } catch (Exception e) {
      return GenericResponse.builder()
          .message("Error al crear el despliegue: " + e.getMessage())
          .build();
    }
  }

  @Override
  @Transactional
  public GenericResponse<Object> updateDespliegue(UUID id, Despliegue despliegueDetails) {
    Despliegue despliegue = repository.getById(id);

    if (despliegue == null) {
      return GenericResponse.builder().message("Despliegue no encontrado con id: " + id).build();
    }

    if (despliegueDetails.getProyectoId() != null) {
      despliegue.setProyectoId(despliegueDetails.getProyectoId());
    }
    if (despliegueDetails.getMaquinaId() != null) {
      despliegue.setMaquinaId(despliegueDetails.getMaquinaId());
    }
    if (despliegueDetails.getFechaDespliegue() != null) {
      despliegue.setFechaDespliegue(despliegueDetails.getFechaDespliegue());
    }
    if (despliegueDetails.getActivo() != null) {
      despliegue.setActivo(despliegueDetails.getActivo());
    }

    try {
      Despliegue despliegueActualizado = repository.save(despliegue);
      return GenericResponse.builder()
          .data(despliegueActualizado)
          .message("Despliegue actualizado exitosamente")
          .build();
    } catch (Exception e) {
      return GenericResponse.builder()
          .message("Error al actualizar el despliegue: " + e.getMessage())
          .build();
    }
  }

  @Override
  @Transactional
  public GenericResponse<Object> deleteDespliegue(UUID id) {
    try {
      if (repository.getById(id) == null) {
        return GenericResponse.builder().message("Despliegue no encontrado con id: " + id).build();
      }

      repository.deleteById(id);
      return GenericResponse.builder()
          .message("Despliegue eliminado exitosamente con id: " + id)
          .build();
    } catch (Exception e) {
      return GenericResponse.builder()
          .message("Error al eliminar el despliegue: " + e.getMessage())
          .build();
    }
  }
}
