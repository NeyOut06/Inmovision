package pe.edu.upc.inmovisiom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.inmovisiom.entities.Propiedad;

public interface IPropiedadRepository extends JpaRepository<Propiedad,Integer> {
}
