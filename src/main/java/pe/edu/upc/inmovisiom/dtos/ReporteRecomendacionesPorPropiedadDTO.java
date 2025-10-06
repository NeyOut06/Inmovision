package pe.edu.upc.inmovisiom.dtos;

import java.time.LocalDate;

public class ReporteRecomendacionesPorPropiedadDTO {
    private Integer idPropiedad;
    private Long cantidadRecomendaciones;
    private LocalDate ultimaFecha;

    public ReporteRecomendacionesPorPropiedadDTO(Integer idPropiedad,
                                                 Long cantidadRecomendaciones,
                                                 LocalDate ultimaFecha) {
        this.idPropiedad = idPropiedad;
        this.cantidadRecomendaciones = cantidadRecomendaciones;
        this.ultimaFecha = ultimaFecha;
    }

    public Integer getIdPropiedad() { return idPropiedad; }
    public Long getCantidadRecomendaciones() { return cantidadRecomendaciones; }
    public LocalDate getUltimaFecha() { return ultimaFecha; }
}
