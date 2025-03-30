package com.bca.mobile_programming.unit_3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.bca.mobile_programming.R;
import com.bca.mobile_programming.unit_4.Home;

public class Login extends Activity {
    @Override
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.unit_3_login);

        TextView signup = findViewById(R.id.signupNoAccountText);
        Button signupButton =findViewById(R.id.signupButton);

        signup.setOnClickListener(v -> {
            Intent i = new Intent(Login.this, SignUp.class);
            startActivity(i);
        });

        signupButton.setOnClickListener(v -> {
            Intent i = new Intent(Login.this, Home.class);
            startActivity(i);
        });
    }
}

