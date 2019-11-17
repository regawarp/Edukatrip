package com.edukatrip.edukatrip.model;

public class Places {
    private String Name;
    private String Location;
    private int Price;
    private String Description;
    private int Image;

    public Places(String name, String location, int price, String description, int image) {
        Name = name;
        Location = location;
        Price = price;
        Description = description;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
