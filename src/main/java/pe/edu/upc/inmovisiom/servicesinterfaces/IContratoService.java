package pe.edu.upc.inmovisiom.servicesinterfaces;

import pe.edu.upc.inmovisiom.entities.Contrato;

import java.util.List;

public interface IContratoService {
    void insert(Contrato contrato);
    List<Contrato> list();
    Contrato listId(int id);
    void delete(int id);
    void update(Contrato contrato);
    public List<String[]> distritoTop();
    public List<String[]> montoPromedioContrato();
}
