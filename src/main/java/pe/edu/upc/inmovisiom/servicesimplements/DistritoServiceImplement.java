package pe.edu.upc.inmovisiom.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.inmovisiom.entities.Distrito;
import pe.edu.upc.inmovisiom.repositories.IDistritoRepository;
import pe.edu.upc.inmovisiom.servicesinterfaces.IDistritoService;

import java.util.List;

@Service
public class DistritoServiceImplement implements IDistritoService {
    @Autowired
    private IDistritoRepository dS;

    @Override
    public List<Distrito> list() {return dS.findAll();}

    @Override
    public void insert(Distrito distrito) {dS.save(distrito);}

    @Override
    public Distrito listId(int id) {
        return dS.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        dS.deleteById(id);

    }

    @Override
    public void update(Distrito distrito) {
        dS.save(distrito);

    }

    @Override
    public Distrito listId(Integer id) {
        return dS.findById(id).orElse(null);
    }
}
