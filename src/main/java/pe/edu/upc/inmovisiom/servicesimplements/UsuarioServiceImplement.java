package pe.edu.upc.inmovisiom.servicesimplements;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.inmovisiom.entities.Usuario;
import pe.edu.upc.inmovisiom.repositories.IRolRepository;
import pe.edu.upc.inmovisiom.repositories.IUsuarioRepository;
import pe.edu.upc.inmovisiom.servicesinterfaces.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository uS;

    @Autowired
    private IRolRepository rS;

    @Override
    public List<Usuario> list() {
        return uS.findAll();
    }

    @Override
    public void insert(Usuario usuario) {
        uS.save(usuario);
    }

    @Override
    public Usuario listId(int id) {
        return uS.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(int id) {
        rS.deleteByUsuarioId(id); // borra hijos primero
        uS.deleteById(id);
    }

    @Override
    public void update(Usuario usuario) {
        uS.save(usuario);
    }

    @Override
    public Usuario listId(Integer id) {
        return uS.findById(id).orElse(null);
    }


}
