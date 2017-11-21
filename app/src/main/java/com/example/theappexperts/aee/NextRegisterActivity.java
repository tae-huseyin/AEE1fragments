package com.example.theappexperts.aee;

import android.content.Context;
import android.content.Intent;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.codetroopers.betterpickers.datepicker.DatePickerBuilder;
import com.codetroopers.betterpickers.datepicker.DatePickerDialogFragment;
import com.example.theappexperts.aee.realm.RealmController;
import com.example.theappexperts.aee.realm.RealmCustomer;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import io.realm.Realm;

/**
 * Created by TheAppExperts on 19/11/2017.
 */

public class NextRegisterActivity extends AppCompatActivity implements DatePickerDialogFragment.DatePickerDialogHandler{

    Spinner sp;
    ImageView dp;
    EditText etName, etUser, etDob, etAddress;
    Button btnCreate;
    RadioButton rgGender1, rgGender2;

    private Realm realm;
    private RealmController realmController;
    byte[] storeByte;

    static final int REQUEST_IMAGE_CAPTURE = 1;

    public void initializeRealm()
    {
        realmController = new RealmController(Realm.getDefaultInstance());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_next);

        dp = (ImageView) findViewById(R.id.ivDP);
        sp = (Spinner) findViewById(R.id.spinner);
        etName = (EditText) findViewById(R.id.etName);
        etUser = (EditText) findViewById(R.id.etUsername);
        etDob = (EditText) findViewById(R.id.etDOB);
        etAddress = (EditText) findViewById(R.id.etAddress);
        btnCreate = (Button) findViewById(R.id.btn_complete);
        rgGender1 = (RadioButton) findViewById(R.id.rbtnMale);
        rgGender2 = (RadioButton) findViewById(R.id.rbtnFemale);

        initializeRealm();//starts realm engine

        //start of spinner
        String[] listOfCountry = {"United Kingdom", "France", "Germany", "Holland",
                "Italy", "Poland", "Spain", "Denmark", "Sweden"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, listOfCountry);

        sp.setAdapter(adapter);
        //end of spinner

        //start of display pic
        dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFeatureAvailable(getApplicationContext(), PackageManager.FEATURE_CAMERA)) {
                    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                    }
                }
            }
        });
        //end of display pic

        //start of date picker
        etDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerBuilder dpb = new DatePickerBuilder()
                        .setFragmentManager(getSupportFragmentManager())
                        .setStyleResId(R.style.BetterPickersDialogFragment);
                dpb.show();
            }
        });
        //end of date picker

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gender = "";

                if(rgGender1.isChecked())
                {
                    gender = "Male";
                }
                else if(rgGender2.isChecked())
                {
                    gender = "Female";
                }

                RealmCustomer realmCustomer = new RealmCustomer(etName.getText().toString(),
                        etUser.getText().toString(),
                        etDob.getText().toString(),
                        sp.getSelectedItem().toString(),
                        gender,
                        etAddress.getText().toString(),
                        storeByte);
                realmController.saveCustomer(realmCustomer);
                Toast.makeText(getApplicationContext(), "Adding to database...", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), CustomerListActivity.class);
                startActivity(intent);
            }
        });

    }

    public final static boolean isFeatureAvailable(Context context, String feature) {
        final PackageManager packageManager = context.getPackageManager();
        final FeatureInfo[] featuresList = packageManager.getSystemAvailableFeatures();
        for (FeatureInfo f : featuresList) {
            if (f.name != null && f.name.equals(feature)) {
                return true;
            }
        }

        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
            convertBitmapToArray(imageBitmap);
            dp.setImageBitmap(imageBitmap);
        }
    }

    public void convertBitmapToArray(Bitmap bitmap)
    {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        storeByte = stream.toByteArray();
    }

    @Override
    public void onDialogDateSet(int reference, int year, int monthOfYear, int dayOfMonth) {
        etDob.setText(getString(R.string.date_picker_result_value, dayOfMonth, monthOfYear+1, year));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
