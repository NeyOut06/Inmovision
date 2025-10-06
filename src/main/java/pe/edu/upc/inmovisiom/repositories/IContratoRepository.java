package pe.edu.upc.inmovisiom.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.inmovisiom.entities.Contrato;

import java.util.List;

@Repository
public interface IContratoRepository extends JpaRepository<Contrato, Integer> {
    @Query(value = "SELECT\n" +
            "    d.nombre_distrito AS distrito,\n" +
            "    COUNT(c.id_contrato) AS numero_de_contratos\n" +
            "FROM\n" +
            "    contrato c\n" +
            "JOIN\n" +
            "    propiedad p ON c.id_propiedad = p.id_propiedad\n" +
            "JOIN\n" +
            "    distrito d ON p.id_distrito = d.id_distrito\n" +
            "WHERE\n" +
            "    c.estado = 'activo'\n" +
            "GROUP BY\n" +
            "    d.nombre_distrito\n" +
            "ORDER BY\n" +
            "    numero_de_contratos DESC\n" +
            "LIMIT 5;", nativeQuery = true)
    public List<String[]> distritoTop();

    @Query(value="SELECT c.tipo, AVG(c.monto) FROM Contrato c GROUP BY c.tipo", nativeQuery = true)
    public List<String[]> montoPromedioContrato();
}
