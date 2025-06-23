package com.msa.historiasUsu_Resp.repository.jpa;

import com.msa.historiasUsu_Resp.repository.model.Responsable;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsableRepository extends JpaRepository<Responsable, UUID> {}
