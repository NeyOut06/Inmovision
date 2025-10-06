package pe.edu.upc.inmovisiom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.inmovisiom.dtos.ReporteFavoritosPorPropiedadDTO;
import pe.edu.upc.inmovisiom.entities.Favorito;

import java.util.List;

@Repository
public interface IFavoritoRepository extends JpaRepository<Favorito, Integer> {
    @Query("""
    SELECT new pe.edu.upc.inmovisiom.dtos.ReporteFavoritosPorPropiedadDTO(
        pr.idPropiedad,
        COUNT(f.idFavorito),
        MAX(f.fechaAgregado)
    )
    FROM Favorito f
    JOIN f.propiedad pr
    GROUP BY pr.idPropiedad
    ORDER BY COUNT(f.idFavorito) DESC
    """)
    List<ReporteFavoritosPorPropiedadDTO> reporteFavoritosPorPropiedad();
}
