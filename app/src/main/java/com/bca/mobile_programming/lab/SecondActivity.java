package com.bca.mobile_programming.lab;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bca.mobile_programming.R;

public class SecondActivity extends AppCompatActivity {
    TextView displayName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        displayName = findViewById(R.id.displayName);

        String name = getIntent().getStringExtra("username");
        displayName.setText("Welcome, " + name + "!");
    }
}
