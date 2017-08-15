package com.example.android.tourguide;

/**
 * Group the content resources
 */
public class ContentResource {
    private Integer mTotal;
    private Integer[] mPhotos;
    private Integer mNamesArray;
    private Integer mAddressesArray;
    private Integer mHoursArray;

    public ContentResource(Integer total, Integer[] photos, Integer namesArray, Integer
            addressesArray, Integer hoursArray) {
        this.mTotal = total;
        this.mPhotos = photos;
        this.mNamesArray = namesArray;
        this.mAddressesArray = addressesArray;
        this.mHoursArray = hoursArray;
    }

    public Integer getTotal() {
        return mTotal;
    }

    public Integer[] getPhotos() {
        return mPhotos;
    }

    public Integer getNamesArray() {
        return mNamesArray;
    }

    public Integer getAddressesArray() {
        return mAddressesArray;
    }

    public Integer getHoursArray() {
        return mHoursArray;
    }
}
