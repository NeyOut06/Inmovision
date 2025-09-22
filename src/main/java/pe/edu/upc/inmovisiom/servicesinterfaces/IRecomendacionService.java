package pe.edu.upc.inmovisiom.servicesinterfaces;

import pe.edu.upc.inmovisiom.entities.Recomendacion;

import java.util.List;

public interface IRecomendacionService {
    void insert(Recomendacion recomendacion);
    List<Recomendacion> list();
    Recomendacion listId(int id);
    void delete(int id);
    void update(Recomendacion recomendacion);
}
