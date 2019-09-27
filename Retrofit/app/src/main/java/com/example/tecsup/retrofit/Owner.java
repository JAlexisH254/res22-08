package com.example.tecsup.retrofit;

public class Owner {
    String login;
    int id;

    public Owner() {
    }

    public Owner(String login, int id) {
        this.login = login;
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
