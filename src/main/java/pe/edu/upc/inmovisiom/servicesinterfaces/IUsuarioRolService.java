package pe.edu.upc.inmovisiom.servicesinterfaces;

import pe.edu.upc.inmovisiom.entities.UsuarioRol;

import java.util.List;

public interface IUsuarioRolService {
    void insert(UsuarioRol usuarioRol);
    List<UsuarioRol> list();
    UsuarioRol listId(int id);
    void delete(int id);
    void update(UsuarioRol usuarioRol);
}
