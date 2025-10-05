package pe.edu.upc.inmovisiom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.inmovisiom.entities.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {

    @Modifying
    @Query("delete from Rol r where r.idRol = :id")
    void deleteuserid(@Param("id") Integer id);


    public Usuario findOneByUsername(String username);

    //BUSCAR POR correo
    @Query("select count(u.username) from Usuario u where u.username =:username")
    public int buscarUsername(@Param("username") String nombre);


    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") int user_id);
}
