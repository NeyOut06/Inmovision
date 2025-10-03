package pe.edu.upc.inmovisiom.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "mensaje")
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMensaje;

    @Column(name = "contenido", columnDefinition = "TEXT", nullable = false)
    private String contenido;

    @Column(name = "enviado_por", length = 20, nullable = false)
    private String enviadoPor; // 'comprador' o 'vendedor'

    @Column(name = "enviado_en", nullable = false)
    private LocalDate enviadoEn;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idPropiedad", nullable = false)
    private Propiedad propiedad;

    public Mensaje() {}

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