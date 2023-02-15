package com.example.quizapp;

public class SpecialId {
    private int UserID;
    private int special;

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getSpecial() {
        return special;
    }

    public void setSpecial(int special) {
        this.special = special;
    }

    public SpecialId(int UserID, int special) {
        this.UserID= UserID;
        this.special = special;
    }

    public SpecialId() {
        this.UserID = 0;
        this.special = 0;
    }
}
