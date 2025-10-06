package pe.edu.upc.inmovisiom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.inmovisiom.dtos.ReporteCalificacionPromedioDTO;
import pe.edu.upc.inmovisiom.entities.Calificacion;

import java.util.List;

@Repository
public interface ICalificacionRepository extends JpaRepository<Calificacion, Integer> {
    @Query("""
    SELECT new pe.edu.upc.inmovisiom.dtos.ReporteCalificacionPromedioDTO(
        pr.idPropiedad,
        COALESCE(AVG(c.puntuacion), 0),
        COUNT(c.idCalificacion)
    )
    FROM Calificacion c
    JOIN c.propiedad pr
    GROUP BY pr.idPropiedad
    ORDER BY AVG(c.puntuacion) DESC
    """)
    List<ReporteCalificacionPromedioDTO> reporteCalificacionPromedioPorPropiedad();
}
