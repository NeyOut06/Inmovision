package pe.edu.upc.inmovisiom.dtos;

public class PromedioMontoPorTipoDTO {
    private String tipo;
    private Double promedioMonto;

    public PromedioMontoPorTipoDTO() {
    }

    public PromedioMontoPorTipoDTO(String tipo, Double promedioMonto) {
        this.tipo = tipo;
        this.promedioMonto = promedioMonto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPromedioMonto() {
        return promedioMonto;
    }

    public void setPromedioMonto(Double promedioMonto) {
        this.promedioMonto = promedioMonto;
    }
}
