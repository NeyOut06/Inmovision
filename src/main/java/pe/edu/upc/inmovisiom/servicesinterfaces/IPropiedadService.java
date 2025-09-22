package pe.edu.upc.inmovisiom.servicesinterfaces;

import pe.edu.upc.inmovisiom.entities.Propiedad;

import java.util.List;

public interface IPropiedadService {

    public List<Propiedad> list();
    public void insert(Propiedad propiedad);
    public Propiedad listId(int id);
    public void delete(int id);
    public void update(Propiedad propiedad);
    Propiedad listId(Integer id);
}
