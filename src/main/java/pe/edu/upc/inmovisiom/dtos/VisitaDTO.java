package pe.edu.upc.inmovisiom.dtos;

import pe.edu.upc.inmovisiom.entities.Propiedad;
import pe.edu.upc.inmovisiom.entities.Usuario;

import java.time.LocalDate;

public class VisitaDTO {
    private Integer idVisita;
    private LocalDate fechaHora;
    private String estado;
    private Usuario usuario;
    private Propiedad propiedad;

    public Integer getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(Integer idVisita) {
        this.idVisita = idVisita;
    }

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
