package pe.edu.upc.inmovisiom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.inmovisiom.dtos.PagoXUsuarioDTO;
import pe.edu.upc.inmovisiom.dtos.ReportePagosPorMetodoDTO;
import pe.edu.upc.inmovisiom.entities.Pago;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IPagoRepository extends JpaRepository<Pago, Integer> {
    @Query("""
SELECT new pe.edu.upc.inmovisiom.dtos.PagoXUsuarioDTO(
    u.idUser,
    u.nombre,
    u.apellido,
    COUNT(p.idPago),
    COALESCE(SUM(p.monto), 0)
)
FROM Pago p
JOIN p.usuario u
WHERE p.fechaPago >= COALESCE(:inicio, p.fechaPago)
  AND p.fechaPago <= COALESCE(:fin,    p.fechaPago)
GROUP BY u.idUser, u.nombre, u.apellido
ORDER BY COUNT(p.idPago) DESC
""")
    List<PagoXUsuarioDTO> cantidadPagosxUsuario(
            @Param("inicio") LocalDate inicio,
            @Param("fin")    LocalDate fin
    );

    @Query("""
SELECT new pe.edu.upc.inmovisiom.dtos.ReportePagosPorMetodoDTO(
    p.metodoPago,
    COUNT(p.idPago),
    COALESCE(SUM(p.monto), 0.0)
)
FROM Pago p
GROUP BY p.metodoPago
ORDER BY COALESCE(SUM(p.monto), 0.0) DESC
""")
    List<ReportePagosPorMetodoDTO> reportePagosPorMetodo();
}
