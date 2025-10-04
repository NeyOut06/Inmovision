package pe.edu.upc.inmovisiom.dtos;

public class DistritoDTO {
    private Integer idDistrito;
    private String nombreDistrito;
    private String provinciaDistrito;
    private String departamentoDistrito;

    public Integer getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(Integer idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getDepartamentoDistrito() {
        return departamentoDistrito;
    }

    public void setDepartamentoDistrito(String departamento) {
        this.departamentoDistrito = departamento;
    }

    public String getProvinciaDistrito() {
        return provinciaDistrito;
    }

    public void setProvinciaDistrito(String provincia) {
        this.provinciaDistrito = provincia;
    }

    public String getNombreDistrito() {
        return nombreDistrito;
    }

    public void setNombreDistrito(String nombre) {
        this.nombreDistrito = nombre;
    }
}
