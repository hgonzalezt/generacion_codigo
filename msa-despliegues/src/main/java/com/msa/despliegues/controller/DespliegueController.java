package com.msa.despliegues.controller;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import com.msa.despliegues.dto.GenericResponse;
import com.msa.despliegues.repository.model.Despliegue;
import com.msa.despliegues.service.IDespliegueService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/despliegues")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class DespliegueController {

  IDespliegueService service;

  @GetMapping
  public ResponseEntity<GenericResponse<Object>> getAll() {
    return ResponseEntity.ok(service.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<GenericResponse<Object>> getById(@PathVariable UUID id) {
    return ResponseEntity.ok(service.getById(id));
  }

  @GetMapping("/proyectos/{proyectoId}")
  public ResponseEntity<GenericResponse<Object>> getByProyectoId(@PathVariable UUID proyectoId) {
    return ResponseEntity.ok(service.getByProyectoId(proyectoId));
  }

  @GetMapping("/maquinas/{maquinaId}")
  public ResponseEntity<GenericResponse<Object>> getByMaquinaId(@PathVariable UUID maquinaId) {
    return ResponseEntity.ok(service.getByMaquinaId(maquinaId));
  }

  @PostMapping
  public ResponseEntity<GenericResponse<Object>> createDespliegue(
      @RequestBody Despliegue despliegue) {
    GenericResponse<Object> response = service.createDespliegue(despliegue);
    if (response.getMessage().contains("exitosamente")) {
      return ResponseEntity.status(CREATED).body(response);
    }

    return ResponseEntity.badRequest().body(response);
  }

  @PutMapping("/{id}")
  public ResponseEntity<GenericResponse<Object>> updateDespliegue(
      @PathVariable UUID id, @RequestBody Despliegue despliegueDetails) {
    GenericResponse<Object> response = service.updateDespliegue(id, despliegueDetails);

    if (response.getMessage().contains("exitosamente")) {
      return ResponseEntity.ok(response);
    } else if (response.getMessage().contains("no encontrado")) {
      return ResponseEntity.status(NOT_FOUND).body(response);
    }

    return ResponseEntity.badRequest().body(response);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<GenericResponse<Object>> deleteDespliegue(@PathVariable UUID id) {
    GenericResponse<Object> response = service.deleteDespliegue(id);

    if (response.getMessage().contains("exitosamente")) {
      return ResponseEntity.status(NO_CONTENT).build();
    } else if (response.getMessage().contains("no encontrado")) {
      return ResponseEntity.status(NOT_FOUND).body(response);
    }

    return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(response);
  }
}
