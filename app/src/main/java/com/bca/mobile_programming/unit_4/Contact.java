package com.bca.mobile_programming.unit_4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bca.mobile_programming.R;

public class Contact extends AppCompatActivity {
    @Override
    public void onCreate(Bundle b){
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(b);
        setContentView(R.layout.unit_2_hello);

        this.setFinishOnTouchOutside(false);

        TextView headingText = findViewById(R.id.helloHeadingText);
        Button cancelButton = findViewById(R.id.unit2helloCancelBtn);
        Button submitButton = findViewById(R.id.unit2helloSubmitBtn);
        EditText fullNameInput = findViewById(R.id.helloFullNameInput);

        // Submit Button Click Listener
        submitButton.setOnClickListener(v -> {
            String inputValue = fullNameInput.getText().toString().trim(); // Trim spaces

            if (inputValue.isEmpty()) {
                headingText.setText(R.string.na);
            } else {
                headingText.setText(inputValue);
            }
        });

        // Cancel Button Click Listener
        cancelButton.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Close", Toast.LENGTH_SHORT).show();
            finish();
        });


    }
}
