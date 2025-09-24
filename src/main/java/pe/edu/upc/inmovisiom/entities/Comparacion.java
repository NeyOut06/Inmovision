package pe.edu.upc.inmovisiom.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "comparacion")
public class Comparacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComparacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @Column(name = "propiedades", columnDefinition = "text")
    private String propiedades;

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

    public String getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(String propiedades) {
        this.propiedades = propiedades;
    }
}
