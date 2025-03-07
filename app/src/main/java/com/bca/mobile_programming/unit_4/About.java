
package com.bca.mobile_programming.unit_4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bca.mobile_programming.R;

import java.util.ArrayList;

public class About extends Activity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.unit_4_about);
        Log.d("myStateLog", "About - onCreate");

        Intent i = getIntent();

        TextView genderText = findViewById(R.id.aboutGenderValue);
        TextView countryText = findViewById(R.id.aboutCountryValue);
        TextView fullNameText = findViewById(R.id.aboutFullNameValue);
        TextView sportsText = findViewById(R.id.aboutSportsValue);
        Button goBackBtn = findViewById(R.id.aboutBackButton);
        Button dialogBtn = findViewById(R.id.aboutDialogButton);

        String gender = i.getStringExtra("gender");
        String country = i.getStringExtra("country");
        String fullName = i.getStringExtra("fullName");
        ArrayList<String> sports = i.getStringArrayListExtra("sports");

        genderText.setText(gender);
        countryText.setText(country);

        if(fullName != null && !fullName.isEmpty()) fullNameText.setText(fullName);
        else fullNameText.setText("Anonymos");

        if(sports != null && !sports.isEmpty()){
            String joinedSports = String.join(" ", sports);
            sportsText.setText(joinedSports);
        } else {
            Toast.makeText(getApplicationContext(), "No sports found", Toast.LENGTH_SHORT).show();
            sportsText.setText("N/A");
        }

    }


    @Override
    protected void onStart(){
        super.onStart();
        Log.d("myStateLog", "About - onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("myStateLog", "About - onResume");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("myStateLog", "About - onRestart");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("myStateLog", "About - onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("myStateLog", "About - onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("myStateLog", "About - onDestroy");
    }
}

