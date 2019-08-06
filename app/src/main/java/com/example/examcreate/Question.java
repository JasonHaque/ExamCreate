package com.example.examcreate;

import com.google.firebase.firestore.Exclude;

public class Question {
    private String questiontext,optiona,optionb,optionc,optiond,correctoption;
    private String id;
    private int questionnumber;

    public Question(){

    }

    public Question(String questiontext, String optiona, String optionb, String optionc, String optiond, String correctoption,int questionnumber) {
        this.questiontext = questiontext;
        this.optiona = optiona;
        this.optionb = optionb;
        this.optionc = optionc;
        this.optiond = optiond;
        this.correctoption = correctoption;
        this.questionnumber=questionnumber;
    }

    public String getQuestiontext() {
        return questiontext;
    }

    public String getOptiona() {
        return optiona;
    }

    public String getOptionb() {
        return optionb;
    }

    public String getOptionc() {
        return optionc;
    }

    public String getOptiond() {
        return optiond;
    }

    public String getCorrectoption() {
        return correctoption;
    }

    public int getQuestionnumber(){return questionnumber;}

    @Exclude
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
