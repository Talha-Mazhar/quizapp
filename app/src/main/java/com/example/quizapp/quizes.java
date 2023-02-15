package com.example.quizapp;

public class quizes {

    private String username;
    private int id;

    // creating getter and setter methods
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // constructor
    public quizes(int id, String userame) {
        this.id = id;
        this.username = username;
    }

    public quizes() {
        this.id = 0;
        this.username = "";
    }
}
