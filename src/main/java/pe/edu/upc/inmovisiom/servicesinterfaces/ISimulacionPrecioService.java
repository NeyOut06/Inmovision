package pe.edu.upc.inmovisiom.servicesinterfaces;

import pe.edu.upc.inmovisiom.entities.SimulacionPrecio;

import java.util.List;

public interface ISimulacionPrecioService {
    public void insert(SimulacionPrecio simulacionPrecio);
    public List<SimulacionPrecio> list();
    public void delete(int idSimulacion);
    public void update(SimulacionPrecio simulacionPrecio);
    public SimulacionPrecio listId(int idSimulacion);
}
