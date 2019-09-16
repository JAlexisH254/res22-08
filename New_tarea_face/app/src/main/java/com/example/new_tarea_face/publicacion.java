package com.example.new_tarea_face;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class publicacion {
    Drawable foto;
    String nombre;
    String fecha;
    String publicacion;
    Drawable imagen;

    public publicacion(Drawable foto, String nombre, String fecha, String publicacion, Drawable imagen) {
        this.foto = foto;
        this.nombre = nombre;
        this.fecha = fecha;
        this.publicacion = publicacion;
        this.imagen = imagen;
    }

    public Drawable getFoto() {
        return foto;
    }

    public void setFoto(Drawable foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(String publicacion) {
        this.publicacion = publicacion;
    }

    public Drawable getImagen() {
        return imagen;
    }

    public void setImagen(Drawable imagen) {
        this.imagen = imagen;
    }
}
