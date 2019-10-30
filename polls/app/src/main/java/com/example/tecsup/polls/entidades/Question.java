package com.example.tecsup.polls.entidades;

import java.util.List;

public class Question {
    public int id;
    public String question_text;
    public String pud_date;
    public List<Choice> choices;

    public Question() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_rest) {
        this.question_text = question_rest;
    }

    public String getPud_date() {
        return pud_date;
    }

    public void setPud_date(String pud_date) {
        this.pud_date = pud_date;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
}
