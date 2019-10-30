package com.example.tecsup.polls.entidades;

public class Choice {
    public int question;
    public  String Choice_text;
    public  int Votes;

    public Choice(int question, String choice_text, int votes) {
        this.question = question;
        Choice_text = choice_text;
        Votes = votes;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public String getChoice_text() {
        return Choice_text;
    }

    public void setChoice_text(String choice_text) {
        Choice_text = choice_text;
    }

    public int getVotes() {
        return Votes;
    }

    public void setVotes(int votes) {
        Votes = votes;
    }
}
