package pe.edu.upc.inmovisiom.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.inmovisiom.entities.Contrato;
import pe.edu.upc.inmovisiom.repositories.IContratoRepository;
import pe.edu.upc.inmovisiom.servicesinterfaces.IContratoService;

import java.util.List;

@Service
public class ContratoServiceImplement implements IContratoService {

    @Autowired
    private IContratoRepository cR;

    @Override
    public void insert(Contrato contrato) {
        cR.save(contrato);
    }

    @Override
    public List<Contrato> list() {
        return cR.findAll();
    }

    @Override
    public Contrato listId(int id) {
        return cR.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public void update(Contrato contrato) {
        cR.save(contrato);
    }
}
