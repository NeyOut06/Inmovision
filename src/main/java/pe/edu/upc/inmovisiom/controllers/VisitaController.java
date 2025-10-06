package pe.edu.upc.inmovisiom.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.inmovisiom.dtos.ReporteVisitasPorPropiedadDTO;
import pe.edu.upc.inmovisiom.dtos.VisitaDTO;
import pe.edu.upc.inmovisiom.entities.Visita;
import pe.edu.upc.inmovisiom.servicesinterfaces.IVisitaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/visitas")
public class VisitaController {

    @Autowired
    private IVisitaService vS;

    @PostMapping
    public void registrar(@RequestBody VisitaDTO dto) {
        ModelMapper m = new ModelMapper();
        Visita v = m.map(dto, Visita.class);
        vS.insert(v);
    }

    @GetMapping
    public List<VisitaDTO> listar() {
        return vS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, VisitaDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public VisitaDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(vS.listId(id), VisitaDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody VisitaDTO dto) {
        ModelMapper m = new ModelMapper();
        Visita v = m.map(dto, Visita.class);
        vS.update(v);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        vS.delete(id);
    }

    @GetMapping("/reportepor-propiedad")
    public ResponseEntity<List<ReporteVisitasPorPropiedadDTO>> reporteVisitasPorPropiedad() {
        List<ReporteVisitasPorPropiedadDTO> lista = vS.reporteVisitasPorPropiedad();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
