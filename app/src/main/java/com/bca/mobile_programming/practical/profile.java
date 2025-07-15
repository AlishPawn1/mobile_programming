package com.bca.mobile_programming.practical;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.bca.mobile_programming.R;

public class profile extends AppCompatActivity {

    TextView Profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.que_1_profile);

        Profile = findViewById(R.id.Profile);

        String name = getIntent().getStringExtra("name");
        String address = getIntent().getStringExtra("address");
        String gender = getIntent().getStringExtra("gender");
        String education = getIntent().getStringExtra("education");

        String profile = "Name: " + name + "\nAddress: " + address + "\nGender: " + gender + "\nEducation: " + education;
        Profile.setText(profile);
    }
}
