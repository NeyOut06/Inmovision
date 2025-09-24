package pe.edu.upc.inmovisiom.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.inmovisiom.entities.Comparacion;
import pe.edu.upc.inmovisiom.repositories.IComparacionRepository;
import pe.edu.upc.inmovisiom.servicesinterfaces.IComparacionService;

import java.util.List;

@Service
public class ComparacionServiceImplement implements IComparacionService {

    @Autowired
    private IComparacionRepository cR;

    @Override
    public void insert(Comparacion comparacion) {
        cR.save(comparacion);
    }

    @Override
    public List<Comparacion> list() {
        return cR.findAll();
    }

    @Override
    public Comparacion listId(int id) {
        return cR.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public void update(Comparacion comparacion) {
        cR.save(comparacion);
    }
}
