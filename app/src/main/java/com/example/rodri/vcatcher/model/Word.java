package com.example.rodri.vcatcher.model;

/**
 * Created by rodri on 11/6/2016.
 */

public class Word {

    private long id;
    private String name;
    private String translation;
    private boolean hasImage;

    public Word() {}

    public Word(long id, String name, String translation, boolean hasImage) {
        this.id = id;
        this.name = name;
        this.translation = translation;
        this.hasImage = hasImage;
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

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public boolean getHasImage() {
        return hasImage;
    }

    public void setHasImage(boolean hasImage) {
        this.hasImage = hasImage;
    }
}
