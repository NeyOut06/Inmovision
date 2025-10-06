// ReportePropiedadesPorDistritoDTO.java
package pe.edu.upc.inmovisiom.dtos;

public class ReportePropiedadesPorDistritoDTO {
    private String distrito;
    private Long   cantidadPropiedades;

    public ReportePropiedadesPorDistritoDTO(String distrito, Long cantidadPropiedades) {
        this.distrito = distrito;
        this.cantidadPropiedades = cantidadPropiedades;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public Long getCantidadPropiedades() {
        return cantidadPropiedades;
    }

    public void setCantidadPropiedades(Long cantidadPropiedades) {
        this.cantidadPropiedades = cantidadPropiedades;
    }
}
