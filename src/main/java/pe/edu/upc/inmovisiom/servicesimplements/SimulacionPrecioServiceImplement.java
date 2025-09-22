package pe.edu.upc.inmovisiom.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.inmovisiom.entities.SimulacionPrecio;
import pe.edu.upc.inmovisiom.repositories.ISimulacionPrecioRepository;
import pe.edu.upc.inmovisiom.servicesinterfaces.ISimulacionPrecioService;

import java.util.List;

@Service
public class SimulacionPrecioServiceImplement implements ISimulacionPrecioService {

    @Autowired
    private ISimulacionPrecioRepository sR;

    @Override
    public void insert(SimulacionPrecio simulacionPrecio) {
        sR.save(simulacionPrecio);
    }

    @Override
    public List<SimulacionPrecio> list() {
        return sR.findAll();
    }

    @Override
    public void delete(int idSimulacion) {
        sR.deleteById(idSimulacion);
    }

    @Override
    public void update(SimulacionPrecio simulacionPrecio) {
        sR.save(simulacionPrecio);
    }

    @Override
    public SimulacionPrecio listId(int idSimulacion) {
        return sR.findById(idSimulacion).orElse(new SimulacionPrecio());
    }
}
