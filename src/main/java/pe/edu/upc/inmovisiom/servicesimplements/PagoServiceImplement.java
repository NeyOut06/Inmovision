package pe.edu.upc.inmovisiom.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.inmovisiom.dtos.PagoXUsuarioDTO;
import pe.edu.upc.inmovisiom.dtos.ReportePagosPorMetodoDTO;
import pe.edu.upc.inmovisiom.entities.Pago;
import pe.edu.upc.inmovisiom.repositories.IPagoRepository;
import pe.edu.upc.inmovisiom.servicesinterfaces.IPagoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PagoServiceImplement implements IPagoService {

    @Autowired
    private IPagoRepository pR;

    @Override
    public void insert(Pago pago) {
        pR.save(pago);
    }

    @Override
    public List<Pago> list() {
        return pR.findAll();
    }

    @Override
    public Pago listId(int id) {
        return pR.findById(id).orElse(new Pago());
    }

    @Override
    public void delete(int id) {
        pR.deleteById(id);
    }

    @Override
    public void update(Pago pago) {
        pR.save(pago);
    }

    @Override
    public List<PagoXUsuarioDTO> pagosPorUsuario(LocalDate inicio, LocalDate fin) {
        return pR.cantidadPagosxUsuario(inicio, fin);
    }

    @Override
    public List<ReportePagosPorMetodoDTO> reportePagosPorMetodo() {
        return pR.reportePagosPorMetodo();
    }
}
