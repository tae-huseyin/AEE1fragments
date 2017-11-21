package com.example.theappexperts.aee.realm;

import io.realm.RealmObject;

/**
 * Created by TheAppExperts on 19/11/2017.
 */

public class RealmLogin extends RealmObject {
    String mMail;
    String mPass;

    public RealmLogin(){}

    public RealmLogin(String mMail, String mPass) {
        this.mMail = mMail;
        this.mPass = mPass;
    }

    public String getmMail() {
        return mMail;
    }

    public void setmMail(String mMail) {
        this.mMail = mMail;
    }

    public String getmPass() {
        return mPass;
    }

    public void setmPass(String mPass) {
        this.mPass = mPass;
    }
}
