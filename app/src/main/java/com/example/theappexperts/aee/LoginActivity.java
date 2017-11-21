package com.example.theappexperts.aee;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.theappexperts.aee.realm.RealmController;
import com.example.theappexperts.aee.realm.RealmLogin;

import java.util.ArrayList;

import io.realm.Realm;

/**
 * Created by TheAppExperts on 18/11/2017.
 */

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText etUser, etPass;

    RealmController realmController;
    ArrayList<RealmLogin> realmLogins;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button)findViewById(R.id.btn_login);
        etUser = (EditText)findViewById(R.id.etEmail);
        etPass = (EditText)findViewById(R.id.etPass);

        realmController = new RealmController(Realm.getDefaultInstance());
        realmLogins = realmController.getLoginList();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (RealmLogin tmp : realmLogins) {
                    if(tmp.getmMail().equals(etUser.getText().toString()))
                    {
                        if(tmp.getmPass().equals(etPass.getText().toString()))
                        {
                            Intent intent = new Intent(getApplicationContext(), CustomerListActivity.class);
                            startActivity(intent);
                        }
                    }
                }

            }
        });

    }

}
