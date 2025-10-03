package pe.edu.upc.inmovisiom.servicesinterfaces;

import pe.edu.upc.inmovisiom.entities.ListaFavoritos;

import java.util.List;

public interface IListaFavoritosService {
    void insert(ListaFavoritos listaFavoritos);
    List<ListaFavoritos> list();
    ListaFavoritos listId(int id);
    void delete(int id);
    void update(ListaFavoritos listaFavoritos);
}