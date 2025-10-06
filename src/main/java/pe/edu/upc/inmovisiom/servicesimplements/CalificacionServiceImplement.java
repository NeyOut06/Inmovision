package pe.edu.upc.inmovisiom.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.inmovisiom.dtos.ReporteCalificacionPromedioDTO;
import pe.edu.upc.inmovisiom.entities.Calificacion;
import pe.edu.upc.inmovisiom.repositories.ICalificacionRepository;
import pe.edu.upc.inmovisiom.servicesinterfaces.ICalificacionService;

import java.util.List;

@Service
public class CalificacionServiceImplement implements ICalificacionService {

    @Autowired
    private ICalificacionRepository cR;

    @Override
    public void insert(Calificacion calificacion) {
        cR.save(calificacion);
    }

    @Override
    public List<Calificacion> list() {
        return cR.findAll();
    }

    @Override
    public Calificacion listId(int id) {
        return cR.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public void update(Calificacion calificacion) {
        cR.save(calificacion);
    }

    @Override
    public List<ReporteCalificacionPromedioDTO> reportePromedioCalificacion() {
        return cR.reporteCalificacionPromedioPorPropiedad();
    }
}
