package pe.edu.upc.inmovisiom.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Distrito")
public class Distrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDistrito;

    @Column(name = "nombreDistrito",length = 50, nullable = false)
    private String nombreDistrito;

    @Column(name = "provinciaDistrito",length = 50, nullable = false)
    private String provinciaDistrito;

    @Column(name = "departamentoDistrito",length = 50, nullable = false)
    private String departamentoDistrito;



    public Distrito(){
    }

    public Distrito(Integer idDistrito, String nombreDistrito, String provinciaDistrito, String departamentoDistrito) {
        this.idDistrito = idDistrito;
        this.nombreDistrito = nombreDistrito;
        this.provinciaDistrito = provinciaDistrito;
        this.departamentoDistrito = departamentoDistrito;
    }

    public Integer getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(Integer idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getNombreDistrito() {
        return nombreDistrito;
    }

    public void setNombreDistrito(String nombreDistrito) {
        this.nombreDistrito = nombreDistrito;
    }

    public String getProvinciaDistrito() {
        return provinciaDistrito;
    }

    public void setProvinciaDistrito(String provinciaDistrito) {
        this.provinciaDistrito = provinciaDistrito;
    }

    public String getDepartamentoDistrito() {
        return departamentoDistrito;
    }

    public void setDepartamentoDistrito(String departamentoDistrito) {
        this.departamentoDistrito = departamentoDistrito;
    }
}
