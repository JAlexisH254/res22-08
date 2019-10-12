package com.example.tecsup.tiendafragment.Entidades;

public class Categoria {
    int  id;
    String imagen_banner;
    String imagen_cuadrada;

    public Categoria(int id, String imagen_banner, String imagen_cuadrada) {
        this.id = id;
        this.imagen_banner = imagen_banner;
        this.imagen_cuadrada = imagen_cuadrada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
