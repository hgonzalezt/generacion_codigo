package msa_proyectos.persistence;

import java.util.UUID;
import msa_proyectos.entities.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoRepository extends JpaRepository<Proyecto, UUID> {}
