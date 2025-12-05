package pe.edu.upc.inmovisiom.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.inmovisiom.dtos.PagoDTO;
import pe.edu.upc.inmovisiom.dtos.PagoXUsuarioDTO;
import pe.edu.upc.inmovisiom.dtos.ReportePagosPorMetodoDTO;
import pe.edu.upc.inmovisiom.entities.Pago;
import pe.edu.upc.inmovisiom.servicesinterfaces.IPagoService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private IPagoService pS;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public void registrar(@RequestBody PagoDTO dto) {
        ModelMapper m = new ModelMapper();
        Pago p = m.map(dto, Pago.class);
        pS.insert(p);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<PagoDTO> listar() {
        return pS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, PagoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','PROPIETARIO','CLIENTE')")
    public PagoDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(pS.listId(id), PagoDTO.class);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public void modificar(@RequestBody PagoDTO dto) {
        ModelMapper m = new ModelMapper();
        Pago p = m.map(dto, Pago.class);
        pS.update(p);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE')")
    public void eliminar(@PathVariable("id") Integer id) {
        pS.delete(id);
    }

    @GetMapping("/por-usuario")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<PagoXUsuarioDTO> pagosPorUsuario(
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fin) {

        return pS.pagosPorUsuario(inicio, fin);
    }

    @GetMapping("/ReportePagosPorMetodo")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<ReportePagosPorMetodoDTO>> reportePagosPorMetodo() {
        List<ReportePagosPorMetodoDTO> lista = pS.reportePagosPorMetodo();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
