package com.example.rodri.vcatcher.model;

/**
 * Created by rodri on 11/6/2016.
 */

public class WordDetails {

    private long id;
    private long wordId;
    private long lastPracticed; //save time in millis??
    private int strength;
    private int correctTimes;
    private int incorrectTimes;

    public WordDetails() {}

    public WordDetails(long id, long wordId, long lastPracticed, int strength, int correctTimes, int incorrectTimes) {
        this.id = id;
        this.wordId = wordId;
        this.lastPracticed = lastPracticed;
        this.strength = strength;
        this.correctTimes = correctTimes;
        this.incorrectTimes = incorrectTimes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getWordId() {
        return wordId;
    }

    public void setWordId(long wordId) {
        this.wordId = wordId;
    }

    public long getLastPracticed() {
        return lastPracticed;
    }

    public void setLastPracticed(long lastPracticed) {
        this.lastPracticed = lastPracticed;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getCorrectTimes() {
        return correctTimes;
    }

    public void setCorrectTimes(int correctTimes) {
        this.correctTimes = correctTimes;
    }

    public int getIncorrectTimes() {
        return incorrectTimes;
    }

    public void setIncorrectTimes(int incorrectTimes) {
        this.incorrectTimes = incorrectTimes;
    }
}
