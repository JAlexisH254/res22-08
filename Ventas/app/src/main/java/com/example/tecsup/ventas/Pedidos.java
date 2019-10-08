package com.example.tecsup.ventas;

import java.util.List;

import io.realm.RealmObject;

public class Pedidos extends RealmObject {
    private String fecha;

    private String total;

    private String nroguia;

    private String descuento;

    private String contado;

    private List<Items> items;

    private String rowidcliente;

    public String getFecha ()
    {
        return fecha;
    }

    public void setFecha (String fecha)
    {
        this.fecha = fecha;
    }

    public String getTotal ()
    {
        return total;
    }

    public void setTotal (String total)
    {
        this.total = total;
    }

    public String getNroguia ()
    {
        return nroguia;
    }

    public void setNroguia (String nroguia)
    {
        this.nroguia = nroguia;
    }

    public String getDescuento ()
    {
        return descuento;
    }

    public void setDescuento (String descuento)
    {
        this.descuento = descuento;
    }

    public String getContado ()
    {
        return contado;
    }

    public void setContado (String contado)
    {
        this.contado = contado;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public String getRowidcliente ()
    {
        return rowidcliente;
    }

    public void setRowidcliente (String rowidcliente)
    {
        this.rowidcliente = rowidcliente;
    }

    @Override
    public String toString()
    {
        return fecha+" = "+total;
    }
}


