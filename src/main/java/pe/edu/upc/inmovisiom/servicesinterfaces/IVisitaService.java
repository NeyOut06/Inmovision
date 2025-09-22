package pe.edu.upc.inmovisiom.servicesinterfaces;

import pe.edu.upc.inmovisiom.entities.Visita;

import java.util.List;

public interface IVisitaService {
    void insert(Visita visita);
    List<Visita> list();
    Visita listId(int id);
    void delete(int id);
    void update(Visita visita);
}
