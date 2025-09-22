package pe.edu.upc.inmovisiom.servicesinterfaces;

import pe.edu.upc.inmovisiom.entities.Rol;

import java.util.List;

public interface IRolService {
    void insert(Rol rol);
    List<Rol> list();
    Rol listId(int id);
    void delete(int id);
    void update(Rol rol);
}
