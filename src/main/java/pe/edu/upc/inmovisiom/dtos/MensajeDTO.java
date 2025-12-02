package pe.edu.upc.inmovisiom.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import pe.edu.upc.inmovisiom.entities.Usuario;
import pe.edu.upc.inmovisiom.entities.Propiedad;
import java.time.LocalDate;

public class MensajeDTO {

    private Integer idMensaje;
    private String contenido;
    private LocalDate enviadoEn;
    @JsonIgnoreProperties({"roles", "username", "password", "apellido", "telefono fotourl", "fecha_registro", "correo", "telefono", "fotourl","enabled"})
    private Usuario usuario;
    @JsonIgnoreProperties({"usuario", "fechaPublicacion", "habitaciones", "banos"})
    private Propiedad propiedad;

    public Integer getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getEnviadoEn() {
        return enviadoEn;
    }

    public void setEnviadoEn(LocalDate enviadoEn) {
        this.enviadoEn = enviadoEn;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }
}
