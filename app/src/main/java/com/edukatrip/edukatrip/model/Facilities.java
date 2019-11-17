package com.edukatrip.edukatrip.model;

public class Facilities {
    private String name;
    private String decription;
    private int Image;

    public Facilities(String name, String decription, int image) {
        this.name = name;
        this.decription = decription;
        Image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
