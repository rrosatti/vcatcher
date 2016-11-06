package com.example.rodri.vcatcher.model;

/**
 * Created by rodri on 11/6/2016.
 */

public class Game {

    private long id;
    private String name;

    public Game() {}

    public Game(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
