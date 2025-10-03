package pe.edu.upc.inmovisiom.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "rol", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "nombre"})})
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario usuario;

    public Rol() {}

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
