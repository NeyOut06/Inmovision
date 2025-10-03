package pe.edu.upc.inmovisiom.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.inmovisiom.entities.Mensaje;

public interface IMensajeRepository extends JpaRepository<Mensaje, Integer> {
}
