package pe.edu.upc.inmovisiom.dtos;

import java.time.LocalDate;

public class ReporteVisitasPorPropiedadDTO {
    private Integer idPropiedad;
    private Long totalVisitas;
    private LocalDate ultimaFecha;
    private Long pendientes;
    private Long completadas;
    private Long canceladas;

    public ReporteVisitasPorPropiedadDTO(Integer idPropiedad,
                                         Long totalVisitas,
                                         LocalDate ultimaFecha,
                                         Long pendientes,
                                         Long completadas,
                                         Long canceladas) {
        this.idPropiedad = idPropiedad;
        this.totalVisitas = totalVisitas;
        this.ultimaFecha = ultimaFecha;
        this.pendientes = pendientes;
        this.completadas = completadas;
        this.canceladas = canceladas;
    }

    public Integer getIdPropiedad() { return idPropiedad; }
    public Long getTotalVisitas() { return totalVisitas; }
    public LocalDate getUltimaFecha() { return ultimaFecha; }
    public Long getPendientes() { return pendientes; }
    public Long getCompletadas() { return completadas; }
    public Long getCanceladas() { return canceladas; }
}
