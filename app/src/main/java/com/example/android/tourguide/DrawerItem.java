package com.example.android.tourguide;

import android.support.annotation.NonNull;

/**
 * Drawer item data
 */

public class DrawerItem {
    private Integer mImageResourceId;
    private Integer mTextResourceId;

    public DrawerItem(Integer imageResourceId, Integer textResourceId) {
        this.mImageResourceId = imageResourceId;
        this.mTextResourceId = textResourceId;
    }

    public Integer getImageResourceId() {
        return mImageResourceId;
    }

    public Integer getTextResourceId() {
        return mTextResourceId;
    }
}
