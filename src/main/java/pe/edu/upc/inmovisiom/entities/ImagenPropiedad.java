package pe.edu.upc.inmovisiom.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "imagenes_propiedad")
public class ImagenPropiedad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idImagen;

    @Column(name = "url_imagen", length = 500, nullable = false)
    private String urlImagen;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idPropiedad", nullable = false)
    private Propiedad propiedad;

    public ImagenPropiedad() {}

    public Integer getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }
}
