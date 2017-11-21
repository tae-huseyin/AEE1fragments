package com.example.theappexperts.aee.realm;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by TheAppExperts on 19/11/2017.
 */

public class RealmController {
    Realm realm;

    public RealmController(Realm realm){this.realm = realm;}

    public void saveCustomer(final RealmLogin realmLogin){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(realmLogin);
            }
        });
    }

    public void saveCustomer(final RealmCustomer realmCustomer){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(realmCustomer);
            }
        });
    }

    //list of all custoemrs return
    public ArrayList<RealmCustomer> getCustomerList(){
        ArrayList<RealmCustomer> customers = new ArrayList<>();

        RealmResults<RealmCustomer> realmCustomerRealmResults = realm.where(RealmCustomer.class).findAll();

        for (RealmCustomer realmCustomer: realmCustomerRealmResults){
            customers.add(realmCustomer);
        }

        return customers;
    }

    public ArrayList<RealmLogin> getLoginList(){
        ArrayList<RealmLogin> logins = new ArrayList<>();

        RealmResults<RealmLogin> realmLoginRealmResults = realm.where(RealmLogin.class).findAll();

        for (RealmLogin realmLogin: realmLoginRealmResults){
            logins.add(realmLogin);
        }

        return logins;
    }

}
