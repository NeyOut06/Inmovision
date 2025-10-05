package pe.edu.upc.inmovisiom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.inmovisiom.entities.Rol;

public interface IRolRepository extends JpaRepository<Rol,Integer> {

    @Modifying
    @Query(value = "DELETE FROM rol WHERE id_rol = :id", nativeQuery = true)
    void deleteRolById(@Param("id") Integer id);

    @Modifying
    @Query("delete from Rol r where r.usuario.idUser = :idUser")
    void deleteByUsuarioId(@Param("idUser") Integer idUser);
}
