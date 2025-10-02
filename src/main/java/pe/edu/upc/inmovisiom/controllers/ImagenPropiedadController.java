package pe.edu.upc.inmovisiom.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.inmovisiom.dtos.ImagenPropiedadDTO;
import pe.edu.upc.inmovisiom.entities.ImagenPropiedad;
import pe.edu.upc.inmovisiom.servicesinterfaces.IImagenPropiedadService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/imagenes")
public class ImagenPropiedadController {

    @Autowired
    private IImagenPropiedadService iS;

    @GetMapping
    public List<ImagenPropiedadDTO> listar() {
        return iS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, ImagenPropiedadDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ImagenPropiedadDTO dto) {
        ModelMapper m = new ModelMapper();
        ImagenPropiedad i = m.map(dto, ImagenPropiedad.class);
        iS.insert(i);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        ImagenPropiedad i = iS.listId(id);
        if (i == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        ImagenPropiedadDTO dto = m.map(i, ImagenPropiedadDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        ImagenPropiedad i = iS.listId(id);
        if (i == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        iS.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody ImagenPropiedadDTO dto) {
        ModelMapper m = new ModelMapper();
        ImagenPropiedad i = m.map(dto, ImagenPropiedad.class);

        ImagenPropiedad existente = iS.listId(i.getIdImagen());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + i.getIdImagen());
        }

        iS.update(i);
        return ResponseEntity.ok("Registro con ID " + i.getIdImagen() + " modificado correctamente.");
    }
}
