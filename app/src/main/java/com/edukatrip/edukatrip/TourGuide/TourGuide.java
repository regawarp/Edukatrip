package com.edukatrip.edukatrip.TourGuide;

public class TourGuide {
    private int gambar;
    private String nama;
    private String bio;
    private int bintang;

    public TourGuide(int gambar, String nama, String bio, int bintang) {
        this.gambar = gambar;
        this.nama = nama;
        this.bio = bio;
        this.bintang = bintang;
    }

    public TourGuide() {
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getBintang() {
        return bintang;
    }

    public void setBintang(int bintang) {
        this.bintang = bintang;
    }
}
