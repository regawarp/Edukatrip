package com.edukatrip.edukatrip.model;

import com.google.firebase.firestore.GeoPoint;

import java.util.ArrayList;

public class Package {
    private String packageId;
    private String packageTitle;
    private int totalPrice;
    private GeoPoint packageLocation;
    private ArrayList<String> packagePictures; // Sementara tipenya int dulu karena pake resource local
//    packageDuration : number
//    packageFacilities : Array
//    packageTimeline : Array
//    packageReviews : Array
//    packageDate : String

    public Package() {
    }

    public Package(String packageId, String packageTitle, int totalPrice, ArrayList<String> packagePictures) {
        this.packageId = packageId;
        this.packageTitle = packageTitle;
        this.totalPrice = totalPrice;
        this.packagePictures = packagePictures;
    }

    public String getPackageId() {
        return packageId;
    }

    public String getPackageTitle() {
        return packageTitle;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
