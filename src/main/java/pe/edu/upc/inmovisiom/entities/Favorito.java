package pe.edu.upc.inmovisiom.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "favorito")
public class Favorito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFavorito;

    @Column(name = "fecha_agregado", nullable = false)
    private LocalDate fechaAgregado;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idPropiedad", nullable = false)
    private Propiedad propiedad;

    @ManyToOne
    @JoinColumn(name = "idLista", nullable = false)
    private ListaFavoritos listaFavoritos;

    public Favorito() {}

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
