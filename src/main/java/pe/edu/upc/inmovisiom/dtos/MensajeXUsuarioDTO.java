package pe.edu.upc.inmovisiom.dtos;

import java.time.LocalDate;

public class MensajeXUsuarioDTO {
    private Integer idUser;
    private String nombre;
    private String apellido;
    private double cantidadMensajes;

    private LocalDate ultimaFecha;

    public MensajeXUsuarioDTO(Integer idUser, String nombre, String apellido, double cantidadMensajes, LocalDate ultimaFecha) {
        this.idUser = idUser;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cantidadMensajes = cantidadMensajes;
        this.ultimaFecha = ultimaFecha;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
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

    public double getCantidadMensajes() {
        return cantidadMensajes;
    }

    public void setCantidadMensajes(double cantidadMensajes) {
        this.cantidadMensajes = cantidadMensajes;
    }



    public LocalDate getUltimaFecha() {
        return ultimaFecha;
    }

    public void setUltimaFecha(LocalDate ultimaFecha) {
        this.ultimaFecha = ultimaFecha;
    }
}
