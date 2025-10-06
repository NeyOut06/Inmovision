package pe.edu.upc.inmovisiom.servicesinterfaces;

import pe.edu.upc.inmovisiom.dtos.MensajeXUsuarioDTO;
import pe.edu.upc.inmovisiom.entities.Mensaje;

import java.time.LocalDate;
import java.util.List;

public interface IMensajeService {
    List<Mensaje> list();
    void insert(Mensaje mensaje);
    Mensaje listId(int id);
    void delete(int id);
    void update(Mensaje mensaje);
    Mensaje listId(Integer id);
    List<MensajeXUsuarioDTO> mensajesPorUsuario(LocalDate inicio, LocalDate fin);
}
