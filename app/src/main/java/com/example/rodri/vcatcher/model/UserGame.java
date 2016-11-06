package com.example.rodri.vcatcher.model;

/**
 * Created by rodri on 11/6/2016.
 */

public class UserGame {

    private long userId;
    private long gameId;
    private int wins;
    private int losses;

    public UserGame() {}

    public UserGame(long userId, long gameId, int wins, int losses) {
        this.userId = userId;
        this.gameId = gameId;
        this.wins = wins;
        this.losses = losses;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }
}
