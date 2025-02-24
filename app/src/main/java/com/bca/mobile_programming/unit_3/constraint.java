
package com.bca.mobile_programming.unit_3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.bca.mobile_programming.R;

public class constraint extends Activity {
    @Override
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.unit_3_constraint);

        Button aboutButton = findViewById(R.id.constraintAboutBtn);

        aboutButton.setOnClickListener(view ->{
            Toast.makeText(this, "Button Click", Toast.LENGTH_LONG).show();
        });

        Spinner countrySpinner = findViewById(R.id.constraintCountrySpinner);
        String[] countryList = {"korea", "Netherland", "UK"};

        ArrayAdapter<String> countryAdapter = new ArrayAdapter<>(this, R.layout.unit_3_spinner_item, countryList);
        countrySpinner.setAdapter(countryAdapter);
    }
}
