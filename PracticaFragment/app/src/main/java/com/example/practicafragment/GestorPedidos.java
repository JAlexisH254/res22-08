package com.example.practicafragment;

import java.util.ArrayList;
import java.util.List;

public class GestorPedidos {
    List<Producto> datos;
    MainActivity mainActivity;

    public GestorPedidos(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        datos = new ArrayList<>();
        for (int i = 0;i<5;i++){
            Producto p = new Producto("Productos"+ 1);
            p.mainActivity = mainActivity;
            datos.add(p);
        }
        imprrimirTodosLosPedidos();
    }

    void imprrimirTodosLosPedidos(){
        for (Producto p : datos){
            p.ImprimirPedidos();
        }
    }
}
