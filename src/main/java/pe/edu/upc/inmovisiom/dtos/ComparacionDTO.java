package pe.edu.upc.inmovisiom.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import pe.edu.upc.inmovisiom.entities.Propiedad;
import pe.edu.upc.inmovisiom.entities.Usuario;

public class ComparacionDTO {
    private Integer idComparacion;
    @JsonIgnoreProperties({"roles", "username", "password", "apellido", "telefono fotourl", "fecha_registro", "correo", "telefono", "fotourl","enabled"})
    private Usuario usuario;
    // Propiedad 1
    @JsonIgnoreProperties({
            "usuario"   // solo evita ciclos
    })
    private Propiedad propiedad1;

    // Propiedad 2
    @JsonIgnoreProperties({
            "usuario"   // solo evita ciclos
    })
    private Propiedad propiedad2;

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