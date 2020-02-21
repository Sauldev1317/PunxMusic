package dev.saul1317.punxmusic.Model;

public class Instrumento {

    private String id;
    private long numero_modelo;
    private String nombre;
    private String Descripcion;
    private long precio;
    private long descuento;
    private long Inventario;
    private long numero_ventas;
    private long numero_vistas;
    private String url_imagen;
    private String url_video;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getNumero_modelo() {
        return numero_modelo;
    }

    public void setNumero_modelo(long numero_modelo) {
        this.numero_modelo = numero_modelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public long getDescuento() {
        return descuento;
    }

    public void setDescuento(long descuento) {
        this.descuento = descuento;
    }

    public long getInventario() {
        return Inventario;
    }

    public void setInventario(long inventario) {
        Inventario = inventario;
    }

    public long getNumero_ventas() {
        return numero_ventas;
    }

    public void setNumero_ventas(long numero_ventas) {
        this.numero_ventas = numero_ventas;
    }

    public long getNumero_vistas() {
        return numero_vistas;
    }

    public void setNumero_vistas(long numero_vistas) {
        this.numero_vistas = numero_vistas;
    }

    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }

    public String getUrl_video() {
        return url_video;
    }

    public void setUrl_video(String url_video) {
        this.url_video = url_video;
    }

    @Override
    public String toString() {
        return "Instrumento{" +
                "id='" + id + '\'' +
                ", numero_modelo=" + numero_modelo +
                ", nombre='" + nombre + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                ", precio=" + precio +
                ", descuento=" + descuento +
                ", Inventario=" + Inventario +
                ", numero_ventas=" + numero_ventas +
                ", numero_vistas=" + numero_vistas +
                ", url_imagen='" + url_imagen + '\'' +
                ", url_video='" + url_video + '\'' +
                '}';
    }
}
