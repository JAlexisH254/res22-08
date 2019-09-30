package com.example.tienda3;

public class Categoria {
    int id;
    String descripcion;
    String imagen_banner;
    String imagen_cuadrada;
    int cant_hijos;
    int padre;
    int nivel;

    public Categoria() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen_banner() {
        return imagen_banner;
    }

    public void setImagen_banner(String imagen_banner) {
        this.imagen_banner = imagen_banner;
    }

    public String getImagen_cuadrada() {
        return imagen_cuadrada;
    }

    public void setImagen_cuadrada(String imagen_cuadrada) {
        this.imagen_cuadrada = imagen_cuadrada;
    }

    public int getCant_hijos() {
        return cant_hijos;
    }

    public void setCant_hijos(int cant_hijos) {
        this.cant_hijos = cant_hijos;
    }

    public int getPadre() {
        return padre;
    }

    public void setPadre(int padre) {
        this.padre = padre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
