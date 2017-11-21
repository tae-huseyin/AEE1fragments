package com.example.theappexperts.aee.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.theappexperts.aee.OnButtonClicked;
import com.example.theappexperts.aee.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainScreenFragment extends Fragment {

    private Button btnLogin, btnRegister;
    OnButtonClicked onButtonClicked;

    public MainScreenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setRetainInstance(true);
        return inflater.inflate(R.layout.fragment_main_screen, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        onButtonClicked = (OnButtonClicked)getActivity();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        btnLogin = (Button)view.findViewById(R.id.btn_login);
        btnRegister = (Button)view.findViewById(R.id.btn_create);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonClicked.clickedButton(view.getId());
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonClicked.clickedButton(view.getId());
            }
        });

    }

}
