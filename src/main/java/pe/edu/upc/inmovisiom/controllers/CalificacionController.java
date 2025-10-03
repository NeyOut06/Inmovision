package pe.edu.upc.inmovisiom.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.inmovisiom.dtos.CalificacionDTO;
import pe.edu.upc.inmovisiom.entities.Calificacion;
import pe.edu.upc.inmovisiom.servicesinterfaces.ICalificacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {

    @Autowired
    private ICalificacionService cS;

    @GetMapping
    public List<CalificacionDTO> listar() {
        return cS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, CalificacionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody CalificacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Calificacion c = m.map(dto, Calificacion.class);
        cS.insert(c);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Calificacion c = cS.listId(id);
        if (c == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe una calificación con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        CalificacionDTO dto = m.map(c, CalificacionDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Calificacion c = cS.listId(id);
        if (c == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una calificación con el ID: " + id);
        }
        cS.delete(id);
        return ResponseEntity.ok("Calificación con ID " + id + " eliminada correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody CalificacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Calificacion c = m.map(dto, Calificacion.class);

        Calificacion existente = cS.listId(c.getIdCalificacion());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe una calificación con el ID: " + c.getIdCalificacion());
        }

        cS.update(c);
        return ResponseEntity.ok("Calificación con ID " + c.getIdCalificacion() + " modificada correctamente.");
    }
}
