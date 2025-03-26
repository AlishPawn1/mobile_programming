package com.bca.mobile_programming.unit_3;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.bca.mobile_programming.R;
import com.bca.mobile_programming.unit_4.About;
import com.bca.mobile_programming.unit_4.Contact;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class SignUp extends AppCompatActivity {

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.unit_3_signup);

        Button aboutButton = findViewById(R.id.aboutButton);
        Button signupButton = findViewById(R.id.signupButton);
        EditText fullNameInput = findViewById(R.id.signupNameInput);
        RadioGroup genderGroup = findViewById(R.id.constraintCheckBoxGenderContainer);
        Spinner countrySpinner = findViewById(R.id.constraintCountrySpinner);
        TextView signupHeadingText = findViewById(R.id.signupText);
        TextView signupNoAccountText = findViewById(R.id.signupNoAccountText);

        CheckBox footballCheckBox = findViewById(R.id.constraintCheckBoxBootball);
        CheckBox volleyballCheckBox = findViewById(R.id.constraintCheckBoxVolleyball);
        CheckBox basketballCheckBox = findViewById(R.id.constraintCheckBoxbasketBall);
        CheckBox BatmintionCheckBox = findViewById(R.id.constraintCheckBoxBatmintion);

//        to get data back from the destination activity should extend AppCompactActivity

        ActivityResultLauncher<Intent> contactLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result ->{
                    if (result.getResultCode() == Activity.RESULT_OK){
                        Intent data = result.getData();

                        if(data != null){
                            String message = data.getStringExtra("contactData");
                            signupHeadingText.setText(message);
                        }
                    }
                }
        );

        Resources res = getResources();

        Log.d("myStateLog", "SignUp - onCreate");

//        if (aboutButton != null) {
//            aboutButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent i = new Intent(SignUp.this, About.class);
//
//                    i.putExtra("gender", "Male");
//                    i.putExtra("country", "Nepal");
//                    i.putExtra("fullName", "");
//                    i.putStringArrayListExtra("sports", new ArrayList<>(Arrays.asList()));
//
//                    startActivity(i);
//                }
//            });
//        } else {
//            Log.e("SignUp", "aboutButton is null. Check if R.id.aboutButton exists in unit_3_signup.xml");
//        }

        signupButton.setOnClickListener(v -> {
            Intent i = new Intent(SignUp.this, About.class);

            ArrayList<String> selectedSports = new ArrayList<>();
            String fullName = fullNameInput.getText().toString();
            int checkedRadioButtonId = genderGroup.getCheckedRadioButtonId();
            String selectedCountry = countrySpinner.getSelectedItem().toString();
            AtomicReference<String> selectedGender = new AtomicReference<>("Unknown");

            if (checkedRadioButtonId == R.id.constraintRadioMale) {
                selectedGender.set(res.getString(R.string.maleText));
            } else if (checkedRadioButtonId == R.id.constraintRadioFemale) {
                selectedGender.set(res.getString(R.string.female));
            }

            CheckBox[] checkBoxes = {footballCheckBox, volleyballCheckBox, basketballCheckBox, BatmintionCheckBox};
            for (CheckBox checkBox : checkBoxes) {
                if (checkBox.isChecked()) {
                    selectedSports.add(checkBox.getText().toString());
                }
            }

            i.putExtra("gender", selectedGender.get());
            i.putExtra("country", selectedCountry);
            i.putExtra("fullName", fullName);
            i.putStringArrayListExtra("sports", selectedSports);

            startActivity(i);
        });

        aboutButton.setOnClickListener(v -> {
            Intent i = new Intent(SignUp.this, Contact.class);
            contactLauncher.launch(i);
        });

        signupNoAccountText.setOnClickListener(v -> {
            finish();
        });
    }


    @Override
    protected void onStart(){
        super.onStart();
        Log.d("myStateLog", "SignUp - onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("myStateLog", "SignUp - onResume");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("myStateLog", "SignUp - onRestart");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("myStateLog", "SignUp - onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("myStateLog", "SignUp - onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("myStateLog", "SignUp - onDestroy");
    }
}

