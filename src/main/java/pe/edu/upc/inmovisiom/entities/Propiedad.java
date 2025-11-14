package pe.edu.upc.inmovisiom.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "propiedad")
public class Propiedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPropiedad;

    @Column(name = "titulo", length = 200, nullable = false)
    private String titulo;

    @Column(name = "descripcion", columnDefinition = "text")
    private String descripcion;

    @Column(name = "precio", nullable = false)
    private double precio;

    @Column(name = "tipo", length = 50)
    private String tipo;

    @Column(name = "categoria", length = 100)
    private String categoria;

    @Column(name = "direccion", length = 200)
    private String direccion;

    @Column(name = "fecha_publicacion")
    private LocalDate fechaPublicacion;

    @Column(name = "estado", length = 50)
    private String estado;

    @Column(name = "metros_cuadrados")
    private int metrosCuadrados;

    @Column(name = "habitaciones")
    private int habitaciones;

    @Column(name = "banos")
    private int banos;

    @Column(name = "destacada")
    private Boolean destacada;

    @Column(name = "latitud", precision = 10, scale = 8)
    private BigDecimal latitud;

    @Column(name = "longitud", precision = 10, scale = 8)
    private BigDecimal longitud;

    @Column(name = "url_vr", length = 500)
    private String urlVr;

    @Column(name = "notas", length = 500)
    private String notas;

    // 🔹 Relación con Usuario (muchas propiedades pueden ser de un usuario)
    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private Usuario usuario;

    // 🔹 Relación con Distrito (muchas propiedades en un distrito)
    @ManyToOne
    @JoinColumn(name = "idDistrito", nullable = false)
    private Distrito distrito;

    @OneToMany(mappedBy = "propiedad",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ImagenPropiedad> imagenes;




    public Propiedad() {
    }

    public Integer getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(Integer idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(int metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    public int getBanos() {
        return banos;
    }

    public void setBanos(int banos) {
        this.banos = banos;
    }

    public Boolean getDestacada() {
        return destacada;
    }

    public void setDestacada(Boolean destacada) {
        this.destacada = destacada;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public String getUrlVr() {
        return urlVr;
    }

    public void setUrlVr(String urlVr) {
        this.urlVr = urlVr;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public List<ImagenPropiedad> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<ImagenPropiedad> imagenes) {
        this.imagenes = imagenes;
    }
}