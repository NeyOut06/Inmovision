package pe.edu.upc.inmovisiom.servicesinterfaces;

import pe.edu.upc.inmovisiom.entities.Mensaje;

import java.util.List;

public interface IMensajeService {
    List<Mensaje> list();
    void insert(Mensaje mensaje);
    Mensaje listId(int id);
    void delete(int id);
    void update(Mensaje mensaje);
    Mensaje listId(Integer id);
}
