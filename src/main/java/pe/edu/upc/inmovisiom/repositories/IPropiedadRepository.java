package pe.edu.upc.inmovisiom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.inmovisiom.dtos.ReportePropiedadesPorDistritoDTO;
import pe.edu.upc.inmovisiom.entities.Propiedad;

import java.util.List;

public interface IPropiedadRepository extends JpaRepository<Propiedad,Integer> {
    @Query("""
    SELECT new pe.edu.upc.inmovisiom.dtos.ReportePropiedadesPorDistritoDTO(
        d.nombreDistrito,
        COUNT(p.idPropiedad)
    )
    FROM Propiedad p
    JOIN p.distrito d
    GROUP BY d.nombreDistrito
    ORDER BY COUNT(p.idPropiedad) DESC
    """)
    List<ReportePropiedadesPorDistritoDTO> reportePropiedadesPorDistrito();
}
