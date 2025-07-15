    package com.bca.mobile_programming.practical;

    import android.content.Intent;
    import android.os.Bundle;
    import android.widget.*;
    import androidx.appcompat.app.AppCompatActivity;

    import com.bca.mobile_programming.R;

    public class que_1_info extends AppCompatActivity {

        EditText Name, Address;
        RadioGroup Gender;
        Spinner Education;
        Button btnSubmit;

        String[] educationOptions = {"SEE", "+2", "Bachelor"};

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.que_1);

            Name = findViewById(R.id.yourName);
            Address = findViewById(R.id.yourAddress);
            Gender = findViewById(R.id.yourGender);
            Education = findViewById(R.id.yourEducation);
            btnSubmit = findViewById(R.id.btnSubmit);

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, educationOptions);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            Education.setAdapter(adapter);

            btnSubmit.setOnClickListener(v -> {
                String name = Name.getText().toString();
                String address = Address.getText().toString();
                int selectedId = Gender.getCheckedRadioButtonId();
                RadioButton selectedRadio = findViewById(selectedId);
                String gender = selectedRadio.getText().toString();
                String education = Education.getSelectedItem().toString();

                Intent intent = new Intent(que_1_info.this, profile.class);
                intent.putExtra("name", name);
                intent.putExtra("address", address);
                intent.putExtra("gender", gender);
                intent.putExtra("education", education);
                startActivity(intent);
            });
        }
    }
