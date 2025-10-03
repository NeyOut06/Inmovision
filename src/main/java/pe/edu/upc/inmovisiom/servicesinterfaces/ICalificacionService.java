package pe.edu.upc.inmovisiom.servicesinterfaces;

import pe.edu.upc.inmovisiom.entities.Calificacion;

import java.util.List;

public interface ICalificacionService {
    void insert(Calificacion calificacion);
    List<Calificacion> list();
    Calificacion listId(int id);
    void delete(int id);
    void update(Calificacion calificacion);
}
