package pe.edu.upc.inmovisiom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.inmovisiom.entities.Visita;

@Repository
public interface IVisitaRepository extends JpaRepository<Visita, Integer> {
}
