package pe.edu.upc.inmovisiom.servicesinterfaces;
import pe.edu.upc.inmovisiom.entities.ImagenPropiedad;
import java.util.List;

public interface IImagenPropiedadService {
    void insert(ImagenPropiedad imagen);
    List<ImagenPropiedad> list();
    ImagenPropiedad listId(int id);
    void delete(int id);
    void update(ImagenPropiedad imagen);
}
