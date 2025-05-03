package com.msa.despliegues.repository;

import com.msa.despliegues.repository.model.Despliegue;
import java.util.List;
import java.util.UUID;

public interface IDespliegueRepository {

  List<Despliegue> getAll();

  Despliegue getById(UUID id);

  List<Despliegue> getByProyectoId(UUID proyectoId);

  List<Despliegue> getByMaquinaId(UUID maquinaId);

  Despliegue save(Despliegue despliegue);

  void deleteById(UUID id);
}
