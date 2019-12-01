package com.edukatrip.edukatrip.model;

public class Guide {
    private String guideId;
    private String guideName;
    private String guideBio;
    private boolean guideGender;
    private String guidePhoto;
    //    private ArrayList<> guideReviews;
    private String guideStatus;

    public Guide() {
    }

    public Guide(String guideId, String guideName, String guideBio, boolean guideGender, String guidePhoto, String guideStatus) {
        this.guideId = guideId;
        this.guideName = guideName;
        this.guideBio = guideBio;
        this.guideGender = guideGender;
        this.guidePhoto = guidePhoto;
        this.guideStatus = guideStatus;
    }

    public String getGuideId() {
        return guideId;
    }

    public String getGuideName() {
        return guideName;
    }

    public String getGuideBio() {
        return guideBio;
    }

    public boolean isGuideGender() {
        return guideGender;
    }

    public String getGuidePhoto() {
        return guidePhoto;
    }

    public String getGuideStatus() {
        return guideStatus;
    }
}
