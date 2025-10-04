package pe.edu.upc.inmovisiom.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import pe.edu.upc.inmovisiom.entities.Usuario;

public class ComparacionDTO {
    private Integer idComparacion;
    @JsonIgnoreProperties({"roles", "username", "password", "apellido", "telefono fotourl", "fecha_registro", "correo", "telefono", "fotourl","enabled"})
    private Usuario usuario;
    private String propiedades;

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

    public String getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(String propiedades) {
        this.propiedades = propiedades;
    }
}
