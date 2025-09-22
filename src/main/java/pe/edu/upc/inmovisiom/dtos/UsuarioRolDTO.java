package pe.edu.upc.inmovisiom.dtos;

import pe.edu.upc.inmovisiom.entities.Rol;
import pe.edu.upc.inmovisiom.entities.Usuario;

public class UsuarioRolDTO {
    private int idUsuarioRol;
    private Usuario usuario;
    private Rol rol;

    public int getIdUsuarioRol() {
        return idUsuarioRol;
    }

    public void setIdUsuarioRol(int idUsuarioRol) {
        this.idUsuarioRol = idUsuarioRol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
