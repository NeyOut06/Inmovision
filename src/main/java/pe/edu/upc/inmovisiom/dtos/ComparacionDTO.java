package pe.edu.upc.inmovisiom.dtos;

import pe.edu.upc.inmovisiom.entities.Usuario;

public class ComparacionDTO {
    private int idComparacion;
    private Usuario usuario;
    private String propiedades;

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
