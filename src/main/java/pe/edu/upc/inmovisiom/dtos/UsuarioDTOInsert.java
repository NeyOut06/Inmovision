package pe.edu.upc.inmovisiom.dtos;

import pe.edu.upc.inmovisiom.entities.Rol;

import java.time.LocalDate;
import java.util.List;

public class UsuarioDTOInsert {
    private int idUser;
    private String nombre;
    private String apellido;
    private String correo;
    private String username;
    private String password;
    private String telefono;
    private String fotourl;
    private LocalDate fecha_registro;
    private Boolean enabled;



    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFotourl() {
        return fotourl;
    }

    public void setFotourl(String fotourl) {
        this.fotourl = fotourl;
    }

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

}
