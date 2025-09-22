package pe.edu.upc.inmovisiom.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.inmovisiom.dtos.UsuarioRolDTO;
import pe.edu.upc.inmovisiom.entities.UsuarioRol;
import pe.edu.upc.inmovisiom.servicesinterfaces.IUsuarioRolService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario-roles")
public class UsuarioRolController {

    @Autowired
    private IUsuarioRolService urS;

    @GetMapping
    public List<UsuarioRolDTO> listar() {
        return urS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, UsuarioRolDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody UsuarioRolDTO dto) {
        ModelMapper m = new ModelMapper();
        UsuarioRol ur = m.map(dto, UsuarioRol.class);
        urS.insert(ur);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        UsuarioRol ur = urS.listId(id);
        if (ur == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        UsuarioRolDTO dto = m.map(ur, UsuarioRolDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody UsuarioRolDTO dto) {
        ModelMapper m = new ModelMapper();
        UsuarioRol ur = m.map(dto, UsuarioRol.class);

        UsuarioRol existente = urS.listId(ur.getIdUsuarioRol());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + ur.getIdUsuarioRol());
        }

        urS.update(ur);
        return ResponseEntity.ok("Registro con ID " + ur.getIdUsuarioRol() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        UsuarioRol ur = urS.listId(id);
        if (ur == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        urS.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }
}
