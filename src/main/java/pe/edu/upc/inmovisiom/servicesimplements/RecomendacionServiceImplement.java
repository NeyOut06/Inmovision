package pe.edu.upc.inmovisiom.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.inmovisiom.dtos.ReporteRecomendacionesPorPropiedadDTO;
import pe.edu.upc.inmovisiom.entities.Recomendacion;
import pe.edu.upc.inmovisiom.repositories.IRecomendacionRepository;
import pe.edu.upc.inmovisiom.servicesinterfaces.IRecomendacionService;

import java.util.List;

@Service
public class RecomendacionServiceImplement implements IRecomendacionService {

    @Autowired
    private IRecomendacionRepository rR;

    @Override
    public void insert(Recomendacion recomendacion) {
        rR.save(recomendacion);
    }

    @Override
    public List<Recomendacion> list() {
        return rR.findAll();
    }

    @Override
    public Recomendacion listId(int id) {
        return rR.findById(id).orElse(new Recomendacion());
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public void update(Recomendacion recomendacion) {
        rR.save(recomendacion);
    }

    @Override
    public List<ReporteRecomendacionesPorPropiedadDTO> reporteRecomendacionesPorPropiedad() {
        return rR.reporteRecomendacionesPorPropiedad();
    }
}
