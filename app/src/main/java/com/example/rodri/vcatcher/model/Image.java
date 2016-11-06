package com.example.rodri.vcatcher.model;

/**
 * Created by rodri on 11/6/2016.
 */

public class Image {

    private long id;
    private String path;
    private int size;

    public Image() {}

    public Image(long id, String path, int size) {
        this.id = id;
        this.path = path;
        this.size = size;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
