package pe.edu.upc.inmovisiom.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "comparacion")
public class Comparacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComparacion;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idPropiedad1", nullable = false)
    private Propiedad propiedad1;

    @ManyToOne
    @JoinColumn(name = "idPropiedad2", nullable = false)
    private Propiedad propiedad2;

    public Comparacion() {}

    public int getIdComparacion() {
        return idComparacion;
    }

    public void setIdComparacion(int idComparacion) {
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