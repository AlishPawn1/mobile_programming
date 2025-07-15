package com.bca.mobile_programming.lab;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.bca.mobile_programming.R;

public class MainActivity extends AppCompatActivity {

    EditText nameInput;
    Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LIFECYCLE", "onCreate");

        nameInput = findViewById(R.id.nameInput);
        sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("username", name);
                startActivity(intent);
            }
        });
    }

    @Override protected void onStart() { super.onStart(); Log.d("LIFECYCLE", "onStart"); }
    @Override protected void onResume() { super.onResume(); Log.d("LIFECYCLE", "onResume"); }
    @Override protected void onPause() { super.onPause(); Log.d("LIFECYCLE", "onPause"); }
    @Override protected void onStop() { super.onStop(); Log.d("LIFECYCLE", "onStop"); }
    @Override protected void onDestroy() { super.onDestroy(); Log.d("LIFECYCLE", "onDestroy"); }
    @Override protected void onRestart() { super.onRestart(); Log.d("LIFECYCLE", "onRestart"); }
}
