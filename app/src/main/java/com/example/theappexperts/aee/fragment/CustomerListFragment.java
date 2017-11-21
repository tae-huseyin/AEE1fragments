package com.example.theappexperts.aee.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.theappexperts.aee.CustomerAdapter;
import com.example.theappexperts.aee.R;
import com.example.theappexperts.aee.realm.RealmController;
import com.example.theappexperts.aee.realm.RealmCustomer;

import java.util.ArrayList;

import io.realm.Realm;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerListFragment extends Fragment {

    RealmController realmController;
    ArrayList<RealmCustomer> realmCustomers;
    private RecyclerView recyclerView;

    public CustomerListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        realmController = new RealmController(Realm.getDefaultInstance());
        realmCustomers = realmController.getCustomerList();

        recyclerView = (RecyclerView)view.findViewById(R.id.rvCustomer);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new CustomerAdapter(realmCustomers, R.layout.row_customer, getContext()));
    }

}
