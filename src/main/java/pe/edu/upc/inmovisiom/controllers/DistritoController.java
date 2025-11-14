package pe.edu.upc.inmovisiom.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.inmovisiom.dtos.DistritoDTO;
import pe.edu.upc.inmovisiom.dtos.UsuarioDTOInsert;
import pe.edu.upc.inmovisiom.entities.Distrito;
import pe.edu.upc.inmovisiom.servicesinterfaces.IDistritoService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/distritos")
public class DistritoController {
    @Autowired
    private IDistritoService dS;
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<DistritoDTO> listar(){
        return dS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,DistritoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void insertar(@RequestBody DistritoDTO dto){
        ModelMapper m = new ModelMapper();
        Distrito d=m.map(dto,Distrito.class);
        dS.insert(d);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Distrito u = dS.listId(id);
        if (u == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        DistritoDTO dto = m.map(u, DistritoDTO.class);
        return ResponseEntity.ok(dto);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Distrito u = dS.listId(id);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        dS.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<String> modificar(@RequestBody DistritoDTO dto) {
        ModelMapper m = new ModelMapper();
        Distrito u = m.map(dto, Distrito.class);

        Distrito existente = dS.listId(u.getIdDistrito());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + u.getIdDistrito());
        }

        dS.update(u);
        return ResponseEntity.ok("Registro con ID " + u.getIdDistrito() + " modificado correctamente.");
    }
}
