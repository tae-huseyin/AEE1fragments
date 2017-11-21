package com.example.theappexperts.aee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.theappexperts.aee.realm.RealmController;
import com.example.theappexperts.aee.realm.RealmCustomer;

import java.util.ArrayList;

import io.realm.Realm;

/**
 * Created by TheAppExperts on 19/11/2017.
 */

public class CustomerListActivity extends AppCompatActivity {
    RealmController realmController;
    ArrayList<RealmCustomer> realmCustomers;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);

        realmController = new RealmController(Realm.getDefaultInstance());
        realmCustomers = realmController.getCustomerList();

        initializeRecyclerView();

    }

    public void initializeRecyclerView(){
        recyclerView = (RecyclerView)findViewById(R.id.rvCustomer);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new CustomerAdapter(realmCustomers, R.layout.row_customer, getApplicationContext()));
    }
}
