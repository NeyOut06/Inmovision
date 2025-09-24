package pe.edu.upc.inmovisiom.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.inmovisiom.entities.Favorito;
import pe.edu.upc.inmovisiom.repositories.IFavoritoRepository;
import pe.edu.upc.inmovisiom.servicesinterfaces.IFavoritoService;

import java.util.List;

@Service
public class FavoritoServiceImplement implements IFavoritoService {

    @Autowired
    private IFavoritoRepository fR;

    @Override
    public void insert(Favorito favorito) {
        fR.save(favorito);
    }

    @Override
    public List<Favorito> list() {
        return fR.findAll();
    }

    @Override
    public Favorito listId(int id) {
        return fR.findById(id).orElse(new Favorito());
    }

    @Override
    public void delete(int id) {
        fR.deleteById(id);
    }

    @Override
    public void update(Favorito favorito) {
        fR.save(favorito);
    }
}
