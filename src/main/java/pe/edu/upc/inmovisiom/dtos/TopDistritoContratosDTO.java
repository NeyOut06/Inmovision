package pe.edu.upc.inmovisiom.dtos;

public class TopDistritoContratosDTO {
    private String distrito;
    private int numeroDeContratos;

    public TopDistritoContratosDTO() {
    }

    public TopDistritoContratosDTO(String distrito, int numeroDeContratos) {
        this.distrito = distrito;
        this.numeroDeContratos = numeroDeContratos;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public int getNumeroDeContratos() {
        return numeroDeContratos;
    }

    public void setNumeroDeContratos(int numeroDeContratos) {
        this.numeroDeContratos = numeroDeContratos;
    }
}
