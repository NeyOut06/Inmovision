package pe.edu.upc.inmovisiom.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "comparacion")
public class Comparacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComparacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    @JsonIgnoreProperties({"roles", "username", "password", "apellido", "telefono fotourl", "fecha_registro", "correo", "telefono", "fotourl","enabled"})
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idPropiedad1", nullable = false)
    @JsonIgnoreProperties({"usuario", "fechaPublicacion", "habitaciones", "banos","estado","metrosCuadrados","destacada","latitud", "longitud", "urlVr" , "notas" , "imagenes" , "urlImagen"})
    private Propiedad propiedad1;

    @ManyToOne
    @JoinColumn(name = "idPropiedad2", nullable = false)
    @JsonIgnoreProperties({"usuario", "fechaPublicacion", "habitaciones", "banos","estado","metrosCuadrados","destacada","latitud", "longitud", "urlVr" , "notas" , "imagenes" , "urlImagen"})
    private Propiedad propiedad2;

    public Comparacion() {}

    public Integer getIdComparacion() {
        return idComparacion;
    }

    public void setIdComparacion(Integer idComparacion) {
        this.idComparacion = idComparacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Propiedad getPropiedad1() {
        return propiedad1;
    }

    public void setPropiedad1(Propiedad propiedad1) {
        this.propiedad1 = propiedad1;
    }

    public Propiedad getPropiedad2() {
        return propiedad2;
    }

    public void setPropiedad2(Propiedad propiedad2) {
        this.propiedad2 = propiedad2;
    }
}
