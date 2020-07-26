package com.semicode.blooodbank.data.model;

public class Slider {
    int photo;
    String text;


    public Slider() {
    }

    public Slider(int photo, String text) {
        this.photo = photo;
        this.text = text;
    }

    public int getPhoto() {
        return photo;
    }

    public String getText() {
        return text;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public void setText(String text) {
        this.text = text;
    }
}
