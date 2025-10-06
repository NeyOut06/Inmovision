package pe.edu.upc.inmovisiom.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.inmovisiom.dtos.ContratoDTO;
import pe.edu.upc.inmovisiom.dtos.PromedioMontoPorTipoDTO;
import pe.edu.upc.inmovisiom.dtos.TopDistritoContratosDTO;
import pe.edu.upc.inmovisiom.entities.Contrato;
import pe.edu.upc.inmovisiom.servicesinterfaces.IContratoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contratos")
public class ContratoController {

    @Autowired
    private IContratoService cS;

    @GetMapping
    public List<ContratoDTO> listar() {
        return cS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, ContratoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ContratoDTO dto) {
        ModelMapper m = new ModelMapper();
        Contrato c = m.map(dto, Contrato.class);
        cS.insert(c);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Contrato c = cS.listId(id);
        if (c == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        ContratoDTO dto = m.map(c, ContratoDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Contrato c = cS.listId(id);
        if (c == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        cS.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody ContratoDTO dto) {
        ModelMapper m = new ModelMapper();
        Contrato c = m.map(dto, Contrato.class);

        Contrato existente = cS.listId(c.getIdContrato());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + c.getIdContrato());
        }

        cS.update(c);
        return ResponseEntity.ok("Registro con ID " + c.getIdContrato() + " modificado correctamente.");
    }

    @GetMapping("/top_distritos")
    public List<TopDistritoContratosDTO> obtenerDistritos(){
        List<TopDistritoContratosDTO> dtoList = new ArrayList<>();
        List<String[]> filaList = cS.distritoTop();
        for(String[] columna:filaList){
            TopDistritoContratosDTO dto = new TopDistritoContratosDTO();
            dto.setDistrito(columna[0]);
            dto.setNumeroDeContratos(Integer.parseInt(columna[1]));
            dtoList.add(dto);
        }
        return dtoList;
    }

    @GetMapping("/monto_promedio")
    public List<PromedioMontoPorTipoDTO> obtenerPromedio(){
        List<PromedioMontoPorTipoDTO> dtoList = new ArrayList<>();
        List<String[]> filaList = cS.distritoTop();
        for(String[] columna:filaList){
            PromedioMontoPorTipoDTO dto = new PromedioMontoPorTipoDTO();
            dto.setTipo(columna[0]);
            dto.setPromedioMonto(Double.parseDouble(columna[1]));
            dtoList.add(dto);
        }
        return dtoList;
    }

}
