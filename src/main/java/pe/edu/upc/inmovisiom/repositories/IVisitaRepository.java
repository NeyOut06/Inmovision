package pe.edu.upc.inmovisiom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.inmovisiom.dtos.ReporteVisitasPorPropiedadDTO;
import pe.edu.upc.inmovisiom.entities.Visita;

import java.util.List;

@Repository
public interface IVisitaRepository extends JpaRepository<Visita, Integer> {

    @Query("""
    SELECT new pe.edu.upc.inmovisiom.dtos.ReporteVisitasPorPropiedadDTO(
        pr.idPropiedad,
        COUNT(v.idVisita),
        MAX(v.fechaHora),
        SUM(CASE WHEN v.estado = 'Pendiente'  THEN 1L ELSE 0L END),
        SUM(CASE WHEN v.estado = 'Completada' THEN 1L ELSE 0L END),
        SUM(CASE WHEN v.estado = 'Cancelada'  THEN 1L ELSE 0L END)
    )
    FROM Visita v
    JOIN v.propiedad pr
    GROUP BY pr.idPropiedad
    ORDER BY MAX(v.fechaHora) DESC
    """)
    List<ReporteVisitasPorPropiedadDTO> reporteVisitasPorPropiedad();
}
