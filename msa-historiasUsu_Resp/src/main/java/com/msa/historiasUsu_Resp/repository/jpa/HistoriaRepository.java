package com.msa.historiasUsu_Resp.repository.jpa;

import com.msa.historiasUsu_Resp.repository.model.Historia;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriaRepository extends JpaRepository<Historia, UUID> {}
