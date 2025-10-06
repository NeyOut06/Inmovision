package pe.edu.upc.inmovisiom.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.inmovisiom.dtos.MensajeXUsuarioDTO;
import pe.edu.upc.inmovisiom.entities.Mensaje;

import java.time.LocalDate;
import java.util.List;

public interface IMensajeRepository extends JpaRepository<Mensaje, Integer> {
    @Query("""
SELECT new pe.edu.upc.inmovisiom.dtos.MensajeXUsuarioDTO(
  u.idUser,
  u.nombre,
  u.apellido,
  COUNT(m.idMensaje),
  MAX(m.enviadoEn)
)
FROM Mensaje m
JOIN m.usuario u
WHERE m.enviadoEn >= COALESCE(:inicio, m.enviadoEn)
  AND m.enviadoEn <= COALESCE(:fin,    m.enviadoEn)
GROUP BY u.idUser, u.nombre, u.apellido
ORDER BY MAX(m.enviadoEn) DESC
""")
    List<MensajeXUsuarioDTO> cantidadMensajesxUsuario(
            @Param("inicio") LocalDate inicio,
            @Param("fin")    LocalDate fin
    );
}
