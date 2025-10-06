package pe.edu.upc.inmovisiom.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.inmovisiom.dtos.MensajeDTO;
import pe.edu.upc.inmovisiom.dtos.MensajeXUsuarioDTO;
import pe.edu.upc.inmovisiom.entities.Mensaje;
import pe.edu.upc.inmovisiom.servicesinterfaces.IMensajeService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mensajes")
public class MensajeController {

    @Autowired
    private IMensajeService mS;

    @GetMapping
    public List<MensajeDTO> listar() {
        return mS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, MensajeDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody MensajeDTO dto) {
        ModelMapper m = new ModelMapper();
        Mensaje mensaje = m.map(dto, Mensaje.class);
        mS.insert(mensaje);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Mensaje mensaje = mS.listId(id);
        if (mensaje == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        MensajeDTO dto = m.map(mensaje, MensajeDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Mensaje mensaje = mS.listId(id);
        if (mensaje == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        mS.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody MensajeDTO dto) {
        ModelMapper m = new ModelMapper();
        Mensaje mensaje = m.map(dto, Mensaje.class);

        Mensaje existente = mS.listId(mensaje.getIdMensaje());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + mensaje.getIdMensaje());
        }

        mS.update(mensaje);
        return ResponseEntity.ok("Registro con ID " + mensaje.getIdMensaje() + " modificado correctamente.");
    }

    @GetMapping("/por-usuario")
    public List<MensajeXUsuarioDTO> mensajesPorUsuario(
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fin) {

        return mS.mensajesPorUsuario(inicio, fin);
    }
}