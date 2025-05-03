package com.msa.despliegues.repository.jpa;

import com.msa.despliegues.repository.model.Despliegue;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespliegueJpaRepository extends JpaRepository<Despliegue, UUID> {

  List<Despliegue> findByProyectoId(UUID proyectoId);

  List<Despliegue> findByMaquinaId(UUID maquinaId);
}
