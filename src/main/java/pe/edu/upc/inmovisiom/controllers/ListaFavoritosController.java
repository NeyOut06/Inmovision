package pe.edu.upc.inmovisiom.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.inmovisiom.dtos.ListaFavoritosDTO;
import pe.edu.upc.inmovisiom.entities.ListaFavoritos;
import pe.edu.upc.inmovisiom.servicesinterfaces.IListaFavoritosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/listasfavoritos")
@PreAuthorize("hasAuthority('ADMIN')")
public class ListaFavoritosController {

    @Autowired
    private IListaFavoritosService lS;

    @PostMapping
    public void registrar(@RequestBody ListaFavoritosDTO dto) {
        ModelMapper m = new ModelMapper();
        ListaFavoritos lista = m.map(dto, ListaFavoritos.class);
        lS.insert(lista);
    }

    @GetMapping
    public List<ListaFavoritosDTO> listar() {
        return lS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, ListaFavoritosDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ListaFavoritosDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(lS.listId(id), ListaFavoritosDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody ListaFavoritosDTO dto) {
        ModelMapper m = new ModelMapper();
        ListaFavoritos lista = m.map(dto, ListaFavoritos.class);
        lS.update(lista);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        lS.delete(id);
    }
}
