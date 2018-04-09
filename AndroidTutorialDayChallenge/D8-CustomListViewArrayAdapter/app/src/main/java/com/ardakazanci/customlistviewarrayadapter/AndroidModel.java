package com.ardakazanci.customlistviewarrayadapter;

public class AndroidModel {

 private String mVersionName;

 private String mVersionNumber;

 private int mImageResourceId;

    /**
     *
     * @param mVersionName : Android Version Name
     * @param mVersionNumber : Android Version Number
     * @param mImageResourceId : Android Version Image Resource Id;
     */
    public AndroidModel(String mVersionName, String mVersionNumber, int mImageResourceId) {
        this.mVersionName = mVersionName;
        this.mVersionNumber = mVersionNumber;
        this.mImageResourceId = mImageResourceId;
    }

    // Getter Methods
    public String getmVersionName() {
        return mVersionName;
    }

    public String getmVersionNumber() {
        return mVersionNumber;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }
}
