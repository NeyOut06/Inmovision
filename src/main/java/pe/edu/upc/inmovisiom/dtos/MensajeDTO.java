package pe.edu.upc.inmovisiom.dtos;

import pe.edu.upc.inmovisiom.entities.Propiedad;
import pe.edu.upc.inmovisiom.entities.Usuario;

import java.time.LocalDate;

public class MensajeDTO {

    private int idMensaje;
    private String contenido;
    private String enviadoPor;
    private LocalDate enviadoEn;

    private Usuario usuario;
    private Propiedad propiedad;

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getEnviadoPor() {
        return enviadoPor;
    }

    public void setEnviadoPor(String enviadoPor) {
        this.enviadoPor = enviadoPor;
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
