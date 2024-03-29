package com.example.tecsup.retrofit;

class Repo {
    String name;
    String full_name;
    Owner owner;

    public Repo() {
    }

    public Repo(String name, String full_name) {
        this.name = name;
        this.full_name = full_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
