package com.bca.mobile_programming.lab;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.bca.mobile_programming.R;

public class lab_2 extends AppCompatActivity {
    EditText nameInput;
    Spinner spinner;
    Button submitButton;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab_2_linear);
        nameInput = findViewById(R.id.nameInput);
        spinner = findViewById(R.id.spinner);
        submitButton = findViewById(R.id.submitButton);
        resultText = findViewById(R.id.resultText);
        String[] options = {"Select Role", "Student", "Developer", "Designer"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, options);
        spinner.setAdapter(adapter);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameInput.getText().toString();
                String role = spinner.getSelectedItem().toString();

                if (name.isEmpty() || role.equals("Select Role")) {
                    Toast.makeText(lab_2.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    resultText.setText("Hello, " + name + "! You selected: " + role);
                }
            }
        });
    }
}
