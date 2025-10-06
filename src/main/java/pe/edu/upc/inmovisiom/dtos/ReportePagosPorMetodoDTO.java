// ReportePagosPorMetodoDTO.java
package pe.edu.upc.inmovisiom.dtos;

import java.math.BigDecimal;

public class ReportePagosPorMetodoDTO {
    private String metodoPago;
    private Long   cantidadPagos;
    private Double montoTotal;

    public ReportePagosPorMetodoDTO(String metodoPago, Long cantidadPagos, Double montoTotal) {
        this.metodoPago = metodoPago;
        this.cantidadPagos = cantidadPagos;
        this.montoTotal = montoTotal;
    }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

    public Long getCantidadPagos() { return cantidadPagos; }
    public void setCantidadPagos(Long cantidadPagos) { this.cantidadPagos = cantidadPagos; }

    public Double getMontoTotal() { return montoTotal; }
    public void setMontoTotal(Double montoTotal) { this.montoTotal = montoTotal; }
}
