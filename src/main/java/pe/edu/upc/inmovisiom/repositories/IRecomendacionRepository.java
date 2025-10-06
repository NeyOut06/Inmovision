package pe.edu.upc.inmovisiom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.inmovisiom.dtos.ReporteRecomendacionesPorPropiedadDTO;
import pe.edu.upc.inmovisiom.entities.Recomendacion;

import java.util.List;

@Repository
public interface IRecomendacionRepository extends JpaRepository<Recomendacion, Integer> {

    @Query("""
    SELECT new pe.edu.upc.inmovisiom.dtos.ReporteRecomendacionesPorPropiedadDTO(
        pr.idPropiedad,
        COUNT(r.idRecomendacion),
        MAX(r.fecha)
    )
    FROM Recomendacion r
    JOIN r.propiedad pr
    GROUP BY pr.idPropiedad
    ORDER BY COUNT(r.idRecomendacion) DESC
    """)
    List<ReporteRecomendacionesPorPropiedadDTO> reporteRecomendacionesPorPropiedad();
}
