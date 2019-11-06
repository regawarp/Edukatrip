package com.edukatrip.edukatrip.DetailWisata;

public class Reviews {
    private String name = "Dimas";
    private String reviews = "WOW tempatnya bagus sekali, cocok buat liburan asdadadadasdasdasdasdaadas";
    private int rate = 4;

    public Reviews(String name, String reviews, int rate) {
        this.name = name;
        this.reviews = reviews;
        this.rate = rate;
    }

    public Reviews() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
