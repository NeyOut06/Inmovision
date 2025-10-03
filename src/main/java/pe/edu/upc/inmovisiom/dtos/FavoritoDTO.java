package pe.edu.upc.inmovisiom.dtos;

import pe.edu.upc.inmovisiom.entities.ListaFavoritos;
import pe.edu.upc.inmovisiom.entities.Propiedad;
import pe.edu.upc.inmovisiom.entities.Usuario;

import java.time.LocalDate;

public class FavoritoDTO {

    private int idFavorito;
    private LocalDate fechaAgregado;
    private Usuario usuario;
    private Propiedad propiedad;
    private ListaFavoritos listaFavoritos;

    public int getIdFavorito() {
        return idFavorito;
    }

    public void setIdFavorito(int idFavorito) {
        this.idFavorito = idFavorito;
    }

    public LocalDate getFechaAgregado() {
        return fechaAgregado;
    }

    public void setFechaAgregado(LocalDate fechaAgregado) {
        this.fechaAgregado = fechaAgregado;
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

    public ListaFavoritos getListaFavoritos() {
        return listaFavoritos;
    }

    public void setListaFavoritos(ListaFavoritos listaFavoritos) {
        this.listaFavoritos = listaFavoritos;
    }
}
