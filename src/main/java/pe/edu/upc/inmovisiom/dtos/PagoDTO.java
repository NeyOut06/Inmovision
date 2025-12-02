package pe.edu.upc.inmovisiom.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import pe.edu.upc.inmovisiom.entities.Contrato;
import pe.edu.upc.inmovisiom.entities.Usuario;

import java.time.LocalDate;

public class PagoDTO {
    private Integer idPago;
    private LocalDate fechaPago;
    private double monto;
    private String metodoPago;
    private String estado;
    private Contrato contrato;
    @JsonIgnoreProperties({"roles", "username", "password", "apellido", "telefono fotourl", "fecha_registro", "correo", "telefono", "fotourl","enabled"})
    private Usuario usuario;

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}