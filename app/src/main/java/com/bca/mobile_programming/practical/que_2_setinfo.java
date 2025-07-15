package com.bca.mobile_programming.practical;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.bca.mobile_programming.R;

public class que_2_setinfo extends AppCompatActivity {
    EditText nameInput, addressInput;
    RadioGroup genderGroup;
    Spinner educationSpinner;
    Button submitBtn;
    DBHelper user_database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.yourName);
        addressInput = findViewById(R.id.yourAddress);
        genderGroup = findViewById(R.id.yourGender);
        educationSpinner = findViewById(R.id.yourEducation);
        submitBtn = findViewById(R.id.btnSubmit);
        dbHelper = new DBHelper(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                new String[]{"SEE", "+2", "Bachelor"});
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        educationSpinner.setAdapter(adapter);

        submitBtn.setOnClickListener(v -> {
            String name = nameInput.getText().toString();
            String address = addressInput.getText().toString();
            String gender = ((RadioButton) findViewById(genderGroup.getCheckedRadioButtonId())).getText().toString();
            String education = educationSpinner.getSelectedItem().toString();

            if (name.isEmpty() || address.isEmpty()) {
                Toast.makeText(que_2_setinfo.this, "All fields required", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean inserted = dbHelper.insertUser(name, address, gender, education);
            if (inserted) {
                Toast.makeText(que_2_setinfo.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(que_2_setinfo.this, que_2_setinfo.class));
            } else {
                Toast.makeText(que_2_setinfo.this, "Failed to Save", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
