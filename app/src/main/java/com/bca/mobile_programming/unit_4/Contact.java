package com.bca.mobile_programming.unit_4;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.bca.mobile_programming.R;

public class Contact extends Activity {
    @Override
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.unit_2_hello);

        Button aboutButton = findViewById(R.id.unit2helloCancelBtn);
        Button signupButton = findViewById(R.id.unit2helloSubmitBtn);
        EditText fullNameInput = findViewById(R.id.helloFullNameInput);
    }
}
