package pe.edu.upc.inmovisiom.servicesimplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.inmovisiom.entities.ListaFavoritos;
import pe.edu.upc.inmovisiom.repositories.IListaFavoritosRepository;
import pe.edu.upc.inmovisiom.servicesinterfaces.IListaFavoritosService;

import java.util.List;

@Service
public class ListaFavoritosServiceImplement implements IListaFavoritosService {

    @Autowired
    private IListaFavoritosRepository lR;

    @Override
    public void insert(ListaFavoritos listaFavoritos) {
        lR.save(listaFavoritos);
    }

    @Override
    public List<ListaFavoritos> list() {
        return lR.findAll();
    }

    @Override
    public ListaFavoritos listId(int id) {
        return lR.findById(id).orElse(new ListaFavoritos());
    }

    @Override
    public void delete(int id) {
        lR.deleteById(id);
    }

    @Override
    public void update(ListaFavoritos listaFavoritos) {
        lR.save(listaFavoritos);
    }
}
