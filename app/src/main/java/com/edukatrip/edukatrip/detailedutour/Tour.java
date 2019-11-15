package com.edukatrip.edukatrip.detailedutour;

public class Tour {
    private int image,bintang;
    String info,judul,harga,review;

    public int getBintang() {
        return bintang;
    }

    public void setBintang(int bintang) {
        this.bintang = bintang;
    }

    public Tour(int image, String info, String judul, String harga,int bintang, String review) {
        this.image = image;
        this.info = info;
        this.judul = judul;
        this.harga = harga;
        this.bintang = bintang;
        this.review = review;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
