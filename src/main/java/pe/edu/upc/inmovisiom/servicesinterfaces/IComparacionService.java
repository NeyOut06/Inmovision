package pe.edu.upc.inmovisiom.servicesinterfaces;

import pe.edu.upc.inmovisiom.entities.Comparacion;

import java.util.List;

public interface IComparacionService {
    void insert(Comparacion comparacion);
    List<Comparacion> list();
    Comparacion listId(int id);
    void delete(int id);
    void update(Comparacion comparacion);
}
