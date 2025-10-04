package pe.edu.upc.inmovisiom.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.inmovisiom.dtos.UsuarioDTOInsert;
import pe.edu.upc.inmovisiom.dtos.UsuarioDTOList;
import pe.edu.upc.inmovisiom.entities.Usuario;
import pe.edu.upc.inmovisiom.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService uS;

    @GetMapping
    public List<UsuarioDTOList> list() {
        return uS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y, UsuarioDTOList.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insert(@RequestBody UsuarioDTOInsert uDTO)
    {
        ModelMapper m=new ModelMapper();
        Usuario u=m.map(uDTO, Usuario.class);
        uS.insert(u);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Usuario u = uS.listId(id);
        if (u == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        UsuarioDTOList dto = m.map(u, UsuarioDTOList.class);
        return ResponseEntity.ok(dto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Usuario u = uS.listId(id);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        uS.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody UsuarioDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);

        Usuario existente = uS.listId(u.getIdUser());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + u.getIdUser());
        }

        uS.update(u);
        return ResponseEntity.ok("Registro con ID " + u.getIdUser() + " modificado correctamente.");
    }
}
