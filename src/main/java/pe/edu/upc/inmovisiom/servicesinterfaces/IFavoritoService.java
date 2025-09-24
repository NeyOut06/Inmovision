package pe.edu.upc.inmovisiom.servicesinterfaces;

import pe.edu.upc.inmovisiom.entities.Favorito;
import java.util.List;

public interface IFavoritoService {
    public void insert(Favorito favorito);
    public List<Favorito> list();
    public Favorito listId(int id);
    public void delete(int id);
    public void update(Favorito favorito);
}
