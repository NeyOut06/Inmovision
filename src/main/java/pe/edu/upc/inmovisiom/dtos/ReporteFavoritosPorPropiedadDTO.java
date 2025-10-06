package pe.edu.upc.inmovisiom.dtos;

import java.time.LocalDate;

public class ReporteFavoritosPorPropiedadDTO {
    private Integer idPropiedad;
    private Long    cantidadFavoritos;
    private LocalDate ultimaFecha;

    public ReporteFavoritosPorPropiedadDTO(Integer idPropiedad, Long cantidadFavoritos, LocalDate ultimaFecha) {
        this.idPropiedad = idPropiedad;
        this.cantidadFavoritos = cantidadFavoritos;
        this.ultimaFecha = ultimaFecha;
    }

    public Integer getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(Integer idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public Long getCantidadFavoritos() {
        return cantidadFavoritos;
    }

    public void setCantidadFavoritos(Long cantidadFavoritos) {
        this.cantidadFavoritos = cantidadFavoritos;
    }

    public LocalDate getUltimaFecha() {
        return ultimaFecha;
    }

    public void setUltimaFecha(LocalDate ultimaFecha) {
        this.ultimaFecha = ultimaFecha;
    }
}
