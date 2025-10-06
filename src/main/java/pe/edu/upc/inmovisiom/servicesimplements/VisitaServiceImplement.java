package pe.edu.upc.inmovisiom.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.inmovisiom.dtos.ReporteVisitasPorPropiedadDTO;
import pe.edu.upc.inmovisiom.entities.Visita;
import pe.edu.upc.inmovisiom.repositories.IVisitaRepository;
import pe.edu.upc.inmovisiom.servicesinterfaces.IVisitaService;

import java.util.List;

@Service
public class VisitaServiceImplement implements IVisitaService {

    @Autowired
    private IVisitaRepository vR;

    @Override
    public void insert(Visita visita) {
        vR.save(visita);
    }

    @Override
    public List<Visita> list() {
        return vR.findAll();
    }

    @Override
    public Visita listId(int id) {
        return vR.findById(id).orElse(new Visita());
    }

    @Override
    public void delete(int id) {
        vR.deleteById(id);
    }

    @Override
    public void update(Visita visita) {
        vR.save(visita);
    }

    @Override
    public List<ReporteVisitasPorPropiedadDTO> reporteVisitasPorPropiedad() {
        return vR.reporteVisitasPorPropiedad();
    }
}
