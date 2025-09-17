package msa_proyectos.persistence;

import java.util.UUID;
import msa_proyectos.entities.Maquina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaquinaRepository extends JpaRepository<Maquina, UUID> {}
