package pe.edu.upc.inmovisiom.dtos;

import pe.edu.upc.inmovisiom.entities.Usuario;

public class RolDTO {
    private int idRol;
    private String nombre;
    private Usuario usuario;


    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
