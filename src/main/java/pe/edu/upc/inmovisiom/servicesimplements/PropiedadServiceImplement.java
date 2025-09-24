package pe.edu.upc.inmovisiom.servicesimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.inmovisiom.entities.Propiedad;
import pe.edu.upc.inmovisiom.repositories.IPropiedadRepository;
import pe.edu.upc.inmovisiom.servicesinterfaces.IPropiedadService;

import java.util.List;

@Service
public class PropiedadServiceImplement implements IPropiedadService {

    @Autowired
    private IPropiedadRepository pS;

    @Override
    public List<Propiedad> list() {
        return pS.findAll();
    }

    @Override
    public void insert(Propiedad propiedad) {
        pS.save(propiedad);

    }

    @Override
    public Propiedad listId(int id) {
        return pS.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        pS.deleteById(id);

    }

    @Override
    public void update(Propiedad propiedad) {
        pS.save(propiedad);

    }

    @Override
    public Propiedad listId(Integer id) {
        return pS.findById(id).orElse(null);
    }
}


