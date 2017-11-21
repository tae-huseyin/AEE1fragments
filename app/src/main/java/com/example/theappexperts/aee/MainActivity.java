package com.example.theappexperts.aee;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.theappexperts.aee.fragment.CustomerListFragment;
import com.example.theappexperts.aee.fragment.LoginScreenFragment;
import com.example.theappexperts.aee.fragment.MainScreenFragment;

public class MainActivity extends AppCompatActivity implements OnButtonClicked{

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        if(savedInstanceState == null)
        {
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, new MainScreenFragment())
                    .commit();
        }
    }

    @Override
    public void clickedButton(int id) {

        switch (id)
        {
            case R.id.btn_login:
                fragmentManager.beginTransaction()
                        .add(R.id.fragment_container, new LoginScreenFragment())
                        .addToBackStack("LoginScreenFragment")
                        .commit();
                break;
            case R.id.btn_create:
                Toast.makeText(getApplicationContext(), "create click", Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_loginpage:
                fragmentManager.beginTransaction()
                        .add(R.id.fragment_container, new CustomerListFragment())
                        .addToBackStack("CustomerListFragment")
                        .commit();
                break;

        }
    }

    /*public void clickButtonEvents(View v){
        if(v.getId() == R.id.btn_create)
        {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        }
        else if (v.getId() == R.id.btn_login)
        {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }*/
}
