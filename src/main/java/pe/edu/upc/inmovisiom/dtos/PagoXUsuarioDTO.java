package pe.edu.upc.inmovisiom.dtos;

public class PagoXUsuarioDTO {
    private Integer idUser;
    private String nombre;
    private String apellido;
    private double cantidadpagos;
    private double montototal;

    public PagoXUsuarioDTO(Integer idUser, String nombre, String apellido, double cantidadpagos, double montototal) {
        this.idUser = idUser;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cantidadpagos = cantidadpagos;
        this.montototal = montototal;
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

    public double getCantidadpagos() {
        return cantidadpagos;
    }

    public void setCantidadpagos(double cantidadpagos) {
        this.cantidadpagos = cantidadpagos;
    }

    public double getMontototal() {
        return montototal;
    }

    public void setMontototal(double montototal) {
        this.montototal = montototal;
    }
}
