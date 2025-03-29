package com.bca.mobile_programming.unit_4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bca.mobile_programming.R;
import com.bca.mobile_programming.unit_5.FragmentSwitchActivity;
import com.bca.mobile_programming.unit_5.ImageFragmentActivity;

public class Home extends Activity {
    @Override
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.unit_4_home);

        Button activityButton = findViewById(R.id.homeActivityButton);
        Button dialogButton = findViewById(R.id.homeDialogButton);
        Button fragmentButtonImage = findViewById(R.id.homeFragmentButtonImage);
        Button fragmentButtonSwitcher = findViewById(R.id.homeFragmentButtonSwitcher);

        fragmentButtonSwitcher.setOnClickListener(v -> {
            Intent i = new Intent(Home.this, FragmentSwitchActivity.class);
            startActivity(i);
        });

        fragmentButtonImage.setOnClickListener(v -> {
            Intent i = new Intent(Home.this, ImageFragmentActivity.class);
            startActivity(i);
        });

        dialogButton.setOnClickListener(v-> {
            Toast.makeText(getApplicationContext(), "Dialog button is click", Toast.LENGTH_SHORT).show();
        });
    }
}
