package com.msa.despliegues.service;

import com.msa.despliegues.dto.GenericResponse;
import com.msa.despliegues.repository.model.Despliegue;
import java.util.UUID;

public interface IDespliegueService {

  GenericResponse<Object> getAll();

  GenericResponse<Object> getById(UUID id);

  GenericResponse<Object> getByProyectoId(UUID proyectoId);

  GenericResponse<Object> getByMaquinaId(UUID maquinaId);

  GenericResponse<Object> createDespliegue(Despliegue despliegue);

  GenericResponse<Object> updateDespliegue(UUID id, Despliegue despliegue);

  GenericResponse<Object> deleteDespliegue(UUID id);
}
