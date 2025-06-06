package com.bca.mobile_programming.unit_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bca.mobile_programming.R;

public class Hello extends Activity {

    private static final String TAG = "HelloActivity"; // Log Tag for debugging

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.unit_2_hello);

        // Initializing UI Components
        TextView headingText = findViewById(R.id.helloHeadingText);
        EditText fullNameInput = findViewById(R.id.helloFullNameInput);
        Button submitButton = findViewById(R.id.unit2helloSubmitBtn);
        Button cancelButton = findViewById(R.id.unit2helloCancelBtn);


        // Submit Button Click Listener
        submitButton.setOnClickListener(v -> {
            Log.d(TAG, "Submit button clicked"); // Debug log
            String inputValue = fullNameInput.getText().toString().trim(); // Trim spaces

            if (inputValue.isEmpty()) {
                headingText.setText(R.string.na);
                Log.w(TAG, "Empty input, setting default text");
            } else {
                headingText.setText(inputValue);
                Log.d(TAG, "User entered: " + inputValue);
            }
        });

        // Cancel Button Click Listener
        cancelButton.setOnClickListener(v -> {
            Log.d(TAG, "Cancel button clicked"); // Debug log
            String sendBackData = fullNameInput.getText().toString().trim(); // Trim spaces

            if (sendBackData.isEmpty()) {
                sendBackData = "Default Value";
                Log.w(TAG, "Empty input, sending default value");
            }

            // Sending data back to the previous activity
            Intent i = new Intent();
            i.putExtra("contactData", sendBackData);
            setResult(RESULT_OK, i);
            finish(); // Close the activity
        });
    }

}
