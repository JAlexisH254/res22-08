package com.example.tecsup.retrofit;

public class Pokemon {
    String name;
    int id;
    int order;
    int base_experience;

    public Pokemon() {
    }

    public Pokemon(String name, int id, int order, int base_experience) {
        this.name = name;
        this.id = id;
        this.order = order;
        this.base_experience = base_experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(int base_experience) {
        this.base_experience = base_experience;
    }
}
