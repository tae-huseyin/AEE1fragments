package com.example.theappexperts.aee.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.theappexperts.aee.CustomerListActivity;
import com.example.theappexperts.aee.OnButtonClicked;
import com.example.theappexperts.aee.R;
import com.example.theappexperts.aee.realm.RealmController;
import com.example.theappexperts.aee.realm.RealmLogin;

import java.util.ArrayList;

import io.realm.Realm;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginScreenFragment extends Fragment {

    Button btnLogin;
    EditText etUser, etPass;

    RealmController realmController;
    ArrayList<RealmLogin> realmLogins;

    OnButtonClicked onButtonClicked;

    public LoginScreenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setRetainInstance(true);
        return inflater.inflate(R.layout.fragment_login_screen, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        onButtonClicked = (OnButtonClicked)getActivity();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        btnLogin = (Button)view.findViewById(R.id.btn_loginpage);
        etUser = (EditText)view.findViewById(R.id.etEmail);
        etPass = (EditText)view.findViewById(R.id.etPass);

        realmController = new RealmController(Realm.getDefaultInstance());
        realmLogins = realmController.getLoginList();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (RealmLogin tmp : realmLogins) {
                    if(tmp.getmMail().equals(etUser.getText().toString()))
                    {
                        if(tmp.getmPass().equals(etPass.getText().toString()))
                        {
                            onButtonClicked.clickedButton(view.getId());
                        }
                    }
                }
            }
        });

    }

}
