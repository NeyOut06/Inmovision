package pe.edu.upc.inmovisiom.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.inmovisiom.dtos.RecomendacionDTO;
import pe.edu.upc.inmovisiom.entities.Recomendacion;
import pe.edu.upc.inmovisiom.servicesinterfaces.IRecomendacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recomendaciones")
public class RecomendacionController {

    @Autowired
    private IRecomendacionService rS;

    @PostMapping
    public void registrar(@RequestBody RecomendacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Recomendacion r = m.map(dto, Recomendacion.class);
        rS.insert(r);
    }

    @GetMapping
    public List<RecomendacionDTO> listar() {
        return rS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, RecomendacionDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RecomendacionDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(rS.listId(id), RecomendacionDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody RecomendacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Recomendacion r = m.map(dto, Recomendacion.class);
        rS.update(r);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        rS.delete(id);
    }
}
