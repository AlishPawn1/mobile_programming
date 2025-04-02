package com.bca.mobile_programming.unit_4;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bca.mobile_programming.R;
import com.bca.mobile_programming.unit_5.FragmentSwitchActivity;
import com.bca.mobile_programming.unit_5.ImageFragmentActivity;
import com.bca.mobile_programming.unit_5.ListViewMain;

public class Home extends AppCompatActivity {

    private Button dashButton;
    private ViewGroup rootLayout;

    @Override
    protected void onStart() {
        super.onStart();

        //        setting color of status bar

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.light_gray));

        ActionBar bar = getSupportActionBar();

        if(bar != null){
            int color = ContextCompat.getColor(this, R.color.blue_500);
            int textColor = ContextCompat.getColor(this, R.color.white);
            Spannable text = new SpannableString(getResources().getString(R.string.home));

            text.setSpan(new AbsoluteSizeSpan(20, true), 0, text.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            text.setSpan(new ForegroundColorSpan(textColor), 0, text.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            text.setSpan(new LeadingMarginSpan.Standard(20), 0, text.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);

            bar.setTitle(text);
            bar.setElevation(10);
            bar.setBackgroundDrawable(new ColorDrawable(color));
        }
    }

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String close = "Go Away";
        int selectedItem = item.getItemId();

        if(selectedItem == R.id.appOptionsListView){
//            Intent i = new Intent(Home.this, ListViewMain.class);
//            startActivity(i);
            Toast.makeText(this, "List View", Toast.LENGTH_SHORT).show();
            return true;
        } else if(selectedItem == R.id.appOptionsCustomListView){
//            Intent i = new Intent(Home.this, CustomListViewMain.class);
//            startActivity(i);
            Toast.makeText(this, "Custom List View", Toast.LENGTH_SHORT).show();
            return true;
        } else if(selectedItem == R.id.appOptionsGridView){
//            Intent i = new Intent(Home.this, GridView.class);
//            startActivity(i);
            Toast.makeText(this, "Grid View", Toast.LENGTH_SHORT).show();
            return true;
        } else if(selectedItem == R.id.appOptionsRecycleListView){
//            Intent i = new Intent(Home.this, RecycleListView.class);
//            startActivity(i);
            Toast.makeText(this, "Recycle List View", Toast.LENGTH_SHORT).show();
            return true;
        } else if(selectedItem == R.id.appOptionsLogout){
//            Intent i = new Intent(Home.this, Logout.class);
//            startActivity(i);
            Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show();
            return true;
        } else if(selectedItem == R.id.appOptionsSetting){
//            Intent i = new Intent(Home.this, Setting.class);
//            startActivity(i);
            Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
