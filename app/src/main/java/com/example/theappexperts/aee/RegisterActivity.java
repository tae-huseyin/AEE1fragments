package com.example.theappexperts.aee;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.theappexperts.aee.realm.RealmController;
import com.example.theappexperts.aee.realm.RealmLogin;

import io.realm.Realm;

/**
 * Created by TheAppExperts on 18/11/2017.
 */

public class RegisterActivity extends AppCompatActivity {

    Button btnNext;
    EditText etEmail, etPass, etRepass;
    private Realm realm;
    private RealmController realmController;

    public void initializeRealm()
    {
        realmController = new RealmController(Realm.getDefaultInstance());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acc);

        btnNext = (Button)findViewById(R.id.btn_next);
        etEmail = (EditText)findViewById(R.id.etMail);
        etPass = (EditText)findViewById(R.id.etPassword);
        etRepass = (EditText)findViewById(R.id.etRePassword);

        initializeRealm();//starts realm engine
    }

    public void clickButtonEvents(View v){
        if(v.getId() == R.id.btn_next)
        {
            String t1 = etPass.getText().toString();
            String t2 = etRepass.getText().toString();

            if(t1.equals(t2) &&
                    etEmail.getText().toString().contains("@") &&
                    etEmail.getText().toString().contains(".") &&
                    t1.length() >= 8) {
                RealmLogin realmLogin = new RealmLogin(etEmail.getText().toString(),
                        etPass.getText().toString());
                realmController.saveCustomer(realmLogin);
                Toast.makeText(getApplicationContext(), "Adding to login database...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), NextRegisterActivity.class);
                startActivity(intent);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
