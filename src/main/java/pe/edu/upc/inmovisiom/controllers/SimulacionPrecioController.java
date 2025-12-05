package pe.edu.upc.inmovisiom.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.inmovisiom.dtos.SimulacionPrecioDTO;
import pe.edu.upc.inmovisiom.entities.SimulacionPrecio;
import pe.edu.upc.inmovisiom.servicesinterfaces.ISimulacionPrecioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/simulacionprecios")
@PreAuthorize("hasAnyAuthority('ADMIN','PROPIETARIO','CLIENTE')")
public class SimulacionPrecioController {

    @Autowired
    private ISimulacionPrecioService sS;

    @GetMapping
    public List<SimulacionPrecioDTO> listar() {
        return sS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, SimulacionPrecioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody SimulacionPrecioDTO dto) {
        ModelMapper m = new ModelMapper();
        SimulacionPrecio s = m.map(dto, SimulacionPrecio.class);
        sS.insert(s);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        SimulacionPrecio s = sS.listId(id);
        if (s == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        SimulacionPrecioDTO dto = m.map(s, SimulacionPrecioDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        SimulacionPrecio s = sS.listId(id);
        if (s == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        sS.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody SimulacionPrecioDTO dto) {
        ModelMapper m = new ModelMapper();
        SimulacionPrecio s = m.map(dto, SimulacionPrecio.class);

        SimulacionPrecio existente = sS.listId(s.getIdSimulacion());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + s.getIdSimulacion());
        }

        sS.update(s);
        return ResponseEntity.ok("Registro con ID " + s.getIdSimulacion() + " modificado correctamente.");
    }
}
