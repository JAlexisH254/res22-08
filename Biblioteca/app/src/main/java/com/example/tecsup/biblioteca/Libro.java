package com.example.tecsup.biblioteca;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Libro extends RealmObject {
    @PrimaryKey
    int id;
    String titulo;
    int num_Paginas;
    String isbn;
    String autor;
    RealmList<Ejemplar> ejemplares;
    public Libro() {
        ejemplares = new RealmList<>();
    }

    public Libro(String titulo, int num_Paginas, String isbn, String autor) {
        this.id = RealmAplicacion.codlibro.incrementAndGet();
        this.titulo = titulo;
        this.num_Paginas = num_Paginas;
        this.isbn = isbn;
        this.autor = autor;
        ejemplares = new RealmList<>();
    }
}
