package pe.edu.upc.inmovisiom.servicesimplements;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Usuario> list() {
        return uS.findAll();
    }

    @Override
    public void insert(Usuario usuario) {

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
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
        Usuario existente = uS.findById(usuario.getIdUser()).orElseThrow();

        existente.setNombre(usuario.getNombre());
        existente.setApellido(usuario.getApellido());
        existente.setCorreo(usuario.getCorreo());
        existente.setTelefono(usuario.getTelefono());
        existente.setFotourl(usuario.getFotourl());
        existente.setEnabled(usuario.getEnabled());

        if (usuario.getRoles() == null || usuario.getRoles().isEmpty()) {
            usuario.setRoles(existente.getRoles());
        }

        uS.save(existente);
    }

    @Override
    public Usuario listId(Integer id) {
        return uS.findById(id).orElse(null);
    }


}
