package pe.edu.upc.inmovisiom.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.inmovisiom.dtos.FavoritoDTO;
import pe.edu.upc.inmovisiom.entities.Favorito;
import pe.edu.upc.inmovisiom.servicesinterfaces.IFavoritoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/favoritos")
public class FavoritoController {

    @Autowired
    private IFavoritoService fS;

    @PostMapping
    public void registrar(@RequestBody FavoritoDTO dto) {
        ModelMapper m = new ModelMapper();
        Favorito favorito = m.map(dto, Favorito.class);
        fS.insert(favorito);
    }

    @GetMapping
    public List<FavoritoDTO> listar() {
        return fS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, FavoritoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public FavoritoDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        FavoritoDTO dto = m.map(fS.listId(id), FavoritoDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody FavoritoDTO dto) {
        ModelMapper m = new ModelMapper();
        Favorito favorito = m.map(dto, Favorito.class);
        fS.update(favorito);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        fS.delete(id);
    }
}
