package msa_proyectos.dtos;

import java.util.UUID;
import lombok.Builder;
import lombok.Data;
import msa_proyectos.entities.TipoMaquina;

@Data
@Builder
public class MaquinaDTO {
  private UUID id;
  private String nombre;
  private String ubicacion;
  private TipoMaquina tipo;
}
