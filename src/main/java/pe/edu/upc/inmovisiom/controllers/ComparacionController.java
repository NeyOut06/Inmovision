package pe.edu.upc.inmovisiom.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.inmovisiom.dtos.ComparacionDTO;
import pe.edu.upc.inmovisiom.entities.Comparacion;
import pe.edu.upc.inmovisiom.servicesinterfaces.IComparacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comparaciones")
public class ComparacionController {

    @Autowired
    private IComparacionService cS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE')")
    public List<ComparacionDTO> listar() {
        return cS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, ComparacionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE')")
    public void insertar(@RequestBody ComparacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Comparacion c = m.map(dto, Comparacion.class);
        cS.insert(c);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Comparacion c = cS.listId(id);
        if (c == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        ComparacionDTO dto = m.map(c, ComparacionDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE')")
    public ResponseEntity<String> modificar(@RequestBody ComparacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Comparacion c = m.map(dto, Comparacion.class);

        Comparacion existente = cS.listId(c.getIdComparacion());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + c.getIdComparacion());
        }

        cS.update(c);
        return ResponseEntity.ok("Registro con ID " + c.getIdComparacion() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Comparacion c = cS.listId(id);
        if (c == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        cS.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }
}
