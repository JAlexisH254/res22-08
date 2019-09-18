package com.example.tecsup.recycler_demo2;

public class Album {
    String titulo;
    String fecha_lansamiento;
    String imagen;
    boolean faborito;

    public Album(String titulo, String fecha_lansamiento, String imagen, boolean faborito) {
        this.titulo = titulo;
        this.fecha_lansamiento = fecha_lansamiento;
        this.imagen = imagen;
        this.faborito = faborito;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha_lansamiento() {
        return fecha_lansamiento;
    }

    public void setFecha_lansamiento(String fecha_lansamiento) {
        this.fecha_lansamiento = fecha_lansamiento;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public boolean isFaborito() {
        return faborito;
    }

    public void setFaborito(boolean faborito) {
        this.faborito = faborito;
    }
}
