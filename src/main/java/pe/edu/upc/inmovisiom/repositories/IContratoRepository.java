package pe.edu.upc.inmovisiom.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.inmovisiom.entities.Contrato;

@Repository
public interface IContratoRepository extends JpaRepository<Contrato, Integer> {
}
