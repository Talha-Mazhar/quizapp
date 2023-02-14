package com.example.quizapp;

public class Quiz {
        // variables for our coursename,
        // description, tracks and duration, id.
        private String mcqdesc;
        private String selected;
        private String correct;
        private String resultCase;
        private int id;

        // creating getter and setter methods
        public String getmcqdesc() {
            return mcqdesc;
        }

        public void setmcqdesc(String mcqdesc) {
            this.mcqdesc = mcqdesc;
        }

        public String getSelected() {
            return selected;
        }

        public void setSelected(String selected) {
            this.selected = selected;
        }

        public String getResultCase() {
            return resultCase;
        }

        public void setResultCase(String resultCase) {
            this.resultCase = resultCase;
        }
        public String getCorrect() {
            return correct;
        }

        public void setCorrect(String correct) {
            this.correct = correct;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        // constructor
        public Quiz(int id, String mcqdesc, String selected, String correct, String resultCase) {
            this.id=id;
            this.mcqdesc = mcqdesc;
            this.selected = selected;
            this.correct = correct;
            this.resultCase = resultCase;
        }
    }
