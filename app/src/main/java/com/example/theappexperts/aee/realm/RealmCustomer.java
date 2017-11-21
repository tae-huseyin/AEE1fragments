package com.example.theappexperts.aee.realm;

import io.realm.RealmObject;

/**
 * Created by TheAppExperts on 19/11/2017.
 */

public class RealmCustomer extends RealmObject {
    String mName;
    String mUser;
    String mDob;
    String mCountry;
    String mGender;
    String mAddress;
    byte[] mDp;

    public RealmCustomer(){}

    public RealmCustomer(String mName, String mUser, String mDob, String mCountry, String mGender, String mAddress, byte[] mDp) {
        this.mName = mName;
        this.mUser = mUser;
        this.mDob = mDob;
        this.mCountry = mCountry;
        this.mGender = mGender;
        this.mAddress = mAddress;
        this.mDp = mDp;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmUser() {
        return mUser;
    }

    public void setmUser(String mUser) {
        this.mUser = mUser;
    }

    public String getmDob() {
        return mDob;
    }

    public void setmDob(String mDob) {
        this.mDob = mDob;
    }

    public String getmCountry() {
        return mCountry;
    }

    public void setmCountry(String mCountry) {
        this.mCountry = mCountry;
    }

    public String getmGender() {
        return mGender;
    }

    public void setmGender(String mGender) {
        this.mGender = mGender;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public byte[] getmDp() {
        return mDp;
    }

    public void setmDp(byte[] mDp) {
        this.mDp = mDp;
    }
}
