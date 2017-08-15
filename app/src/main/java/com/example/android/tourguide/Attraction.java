package com.example.android.tourguide;

/**
 * Class to store the attraction information
 */
public class Attraction {
    private Integer mImage;
    private String mDescription;
    private String mAddress;
    private String mHours;

    public Attraction(Integer mImage, String mDescription, String mAddress, String mHours) {
        this.mImage = mImage;
        this.mDescription = mDescription;
        this.mAddress = mAddress;
        this.mHours = mHours;
    }

    public Integer getImage() {
        return mImage;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getAddress() {
        return mAddress;
    }

    public String getHours() {
        return mHours;
    }
}
