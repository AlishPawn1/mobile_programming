package com.bca.mobile_programming.unit_2;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.app.Activity;

import com.bca.mobile_programming.R;

public class Hello extends Activity {

    @Override
    protected  void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.unit_2_hello);

        TextView headingText = findViewById(R.id.helloHeadingText);
        EditText fullNameInput = findViewById(R.id.helloFullNameInput);
        Button submitButton = findViewById(R.id.unit2helloSubmitBtn);
        Button cancelButton = findViewById(R.id.unit2helloCancelBtn);

        submitButton.setOnClickListener(v -> {
            Log.d("submit", "submit btn click");
            String inputValue = fullNameInput.getText().toString();

            if(inputValue.isEmpty()){ headingText.setText(R.string.na);}
            else { headingText.setText(inputValue);}
        });

        cancelButton.setOnClickListener(v ->{
            Log.d("Cancel", "cancel btn click");
            String sendBackData = fullNameInput.getText().toString();

            if (sendBackData.isEmpty()) sendBackData = "Default Value";

            Intent i = new Intent();
            i.putExtra("contactData", sendBackData);
            setResult(RESULT_OK, i);
            finish();
        });

    }
}
