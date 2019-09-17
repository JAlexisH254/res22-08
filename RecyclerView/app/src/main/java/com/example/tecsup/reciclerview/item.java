package com.example.tecsup.reciclerview;

public class item {
    String texto;
    String url_imagen;

    public item(String texto, String url_imagen) {
        this.texto = texto;
        this.url_imagen = url_imagen;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }
}
