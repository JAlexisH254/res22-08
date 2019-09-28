package com.example.tecsup.retrofit;

public class Pokemon {
    int id;
    String name;
    String url;
    SpritePokemon sprites;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SpritePokemon getSpritePokemon() {
        return sprites;
    }

    public void setSpritePokemon(SpritePokemon spritePokemon) {
        this.sprites = spritePokemon;
    }

    public Pokemon() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
