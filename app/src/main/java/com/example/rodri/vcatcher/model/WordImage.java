package com.example.rodri.vcatcher.model;

/**
 * Created by rodri on 11/6/2016.
 */

public class WordImage {

    private long wordId;
    private long imageId;

    public WordImage() {}

    public WordImage(long wordId, long imageId) {
        this.wordId = wordId;
        this.imageId = imageId;
    }

    public long getWordId() {
        return wordId;
    }

    public void setWordId(long wordId) {
        this.wordId = wordId;
    }

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }
}
