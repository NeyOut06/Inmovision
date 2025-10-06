package pe.edu.upc.inmovisiom.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.inmovisiom.dtos.MensajeXUsuarioDTO;
import pe.edu.upc.inmovisiom.entities.Mensaje;
import pe.edu.upc.inmovisiom.repositories.IMensajeRepository;
import pe.edu.upc.inmovisiom.servicesinterfaces.IMensajeService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MensajeServiceImplement implements IMensajeService {

    @Autowired
    private IMensajeRepository mR;

    @Override
    public List<Mensaje> list() {
        return mR.findAll();
    }

    @Override
    public void insert(Mensaje mensaje) {
        mR.save(mensaje);
    }

    @Override
    public Mensaje listId(int id) {
        return mR.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        mR.deleteById(id);
    }

    @Override
    public void update(Mensaje mensaje) {
        mR.save(mensaje);
    }

    @Override
    public Mensaje listId(Integer id) {
        return mR.findById(id).orElse(null);
    }

    @Override
    public List<MensajeXUsuarioDTO> mensajesPorUsuario(LocalDate inicio, LocalDate fin) {
        return mR.cantidadMensajesxUsuario(inicio, fin);

    }
}
