package com.example.tecsup.retrofit;

import java.util.List;

public class Pokedex {
    int count;
    List<Pokemon> results;

    public Pokedex() {
    }

    public Pokedex(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Pokemon> getResult() {
        return results;
    }

    public void setResult(List<Pokemon> result) {
        this.results = result;
    }
}
