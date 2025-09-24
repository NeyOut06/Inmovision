package pe.edu.upc.inmovisiom.servicesimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.inmovisiom.entities.ImagenPropiedad;
import pe.edu.upc.inmovisiom.repositories.IImagenPropiedadRepository;
import pe.edu.upc.inmovisiom.servicesinterfaces.IImagenPropiedadService;

import java.util.List;

@Service
public class ImagenPropiedadServiceImplement implements IImagenPropiedadService {

    @Autowired
    private IImagenPropiedadRepository iR;

    @Override
    public void insert(ImagenPropiedad imagen) {
        iR.save(imagen);
    }

    @Override
    public List<ImagenPropiedad> list() {
        return iR.findAll();
    }

    @Override
    public ImagenPropiedad listId(int id) {
        return iR.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        iR.deleteById(id);
    }

    @Override
    public void update(ImagenPropiedad imagen) {
        iR.save(imagen);
    }
}
