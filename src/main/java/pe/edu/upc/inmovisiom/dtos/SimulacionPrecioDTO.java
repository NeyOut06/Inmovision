package pe.edu.upc.inmovisiom.dtos;

import pe.edu.upc.inmovisiom.entities.Propiedad;
import pe.edu.upc.inmovisiom.entities.Usuario;

import java.time.LocalDate;

public class SimulacionPrecioDTO {
    private Integer idSimulacion;
    private double montoInicial;
    private int tasaIntereses;
    private int plazoMeses;
    private double cuotaMensual;
    private LocalDate fecha;

    private Usuario usuario;
    private Propiedad propiedad;

    public Integer getIdSimulacion() {
        return idSimulacion;
    }

    public void setIdSimulacion(Integer idSimulacion) {
        this.idSimulacion = idSimulacion;
    }

    public double getMontoInicial() {
        return montoInicial;
    }

    public void setMontoInicial(double montoInicial) {
        this.montoInicial = montoInicial;
    }

    public int getTasaIntereses() {
        return tasaIntereses;
    }

    public void setTasaIntereses(int tasaIntereses) {
        this.tasaIntereses = tasaIntereses;
    }

    public int getPlazoMeses() {
        return plazoMeses;
    }

    public void setPlazoMeses(int plazoMeses) {
        this.plazoMeses = plazoMeses;
    }

    public double getCuotaMensual() {
        return cuotaMensual;
    }

    public void setCuotaMensual(double cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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
