package pe.edu.upc.inmovisiom.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.inmovisiom.entities.UsuarioRol;
import pe.edu.upc.inmovisiom.repositories.IUsuarioRolRepository;
import pe.edu.upc.inmovisiom.servicesinterfaces.IUsuarioRolService;

import java.util.List;

@Service
public class UsuarioRolServiceImplement implements IUsuarioRolService {

    @Autowired
    private IUsuarioRolRepository urR;

    @Override
    public void insert(UsuarioRol usuarioRol) {
        urR.save(usuarioRol);
    }

    @Override
    public List<UsuarioRol> list() {
        return urR.findAll();
    }

    @Override
    public UsuarioRol listId(int id) {
        return urR.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        urR.deleteById(id);
    }

    @Override
    public void update(UsuarioRol usuarioRol) {
        urR.save(usuarioRol);
    }
}
