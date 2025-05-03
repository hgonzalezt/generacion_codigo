package com.msa.despliegues.repository.impl;

import static lombok.AccessLevel.PRIVATE;

import com.msa.despliegues.repository.IDespliegueRepository;
import com.msa.despliegues.repository.jpa.DespliegueJpaRepository;
import com.msa.despliegues.repository.model.Despliegue;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class DespliegueRepository implements IDespliegueRepository {

  DespliegueJpaRepository repository;

  @Override
  public List<Despliegue> getAll() {
    return repository.findAll();
  }

  @Override
  public Despliegue getById(UUID id) {
    return repository.findById(id).orElse(null);
  }

  @Override
  public List<Despliegue> getByProyectoId(UUID proyectoId) {
    return repository.findByProyectoId(proyectoId);
  }

  @Override
  public List<Despliegue> getByMaquinaId(UUID maquinaId) {
    return repository.findByMaquinaId(maquinaId);
  }

  @Override
  public Despliegue save(Despliegue despliegue) {
    return repository.save(despliegue);
  }

  @Override
  public void deleteById(UUID id) {
    repository.deleteById(id);
  }
}
