package pe.edu.upc.inmovisiom.dtos;

public class ReporteCalificacionPromedioDTO {
    private Integer idPropiedad;
    private Double  promedioPuntuacion;
    private Long    cantidadCalificaciones;

    public ReporteCalificacionPromedioDTO(Integer idPropiedad, Double promedioPuntuacion, Long cantidadCalificaciones) {
        this.idPropiedad = idPropiedad;
        this.promedioPuntuacion = promedioPuntuacion;
        this.cantidadCalificaciones = cantidadCalificaciones;
    }

    public Integer getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(Integer idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public Double getPromedioPuntuacion() {
        return promedioPuntuacion;
    }

    public void setPromedioPuntuacion(Double promedioPuntuacion) {
        this.promedioPuntuacion = promedioPuntuacion;
    }

    public Long getCantidadCalificaciones() {
        return cantidadCalificaciones;
    }

    public void setCantidadCalificaciones(Long cantidadCalificaciones) {
        this.cantidadCalificaciones = cantidadCalificaciones;
    }
}
