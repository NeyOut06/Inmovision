package pe.edu.upc.inmovisiom.dtos;

import pe.edu.upc.inmovisiom.entities.Usuario;
import pe.edu.upc.inmovisiom.entities.Propiedad;

import java.time.LocalDate;

public class RecomendacionDTO {
    private Integer idRecomendacion;
    private String motivo;
    private LocalDate fecha;
    private Usuario usuario;
    private Propiedad propiedad;

    public Integer getIdRecomendacion() {
        return idRecomendacion;
    }

    public void setIdRecomendacion(Integer idRecomendacion) {
        this.idRecomendacion = idRecomendacion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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
