package com.bca.mobile_programming.unit_4;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bca.mobile_programming.R;
import com.bca.mobile_programming.unit_1.AlertUtil;
import com.bca.mobile_programming.unit_1.GeneralUtil;
import com.bca.mobile_programming.unit_5.FragmentSwitchActivity;
import com.bca.mobile_programming.unit_6.CustomGridViewMain;
import com.bca.mobile_programming.unit_5.ImageFragmentActivity;
import com.bca.mobile_programming.unit_6.CustomListViewMain;
import com.bca.mobile_programming.unit_6.GridViewMain;
import com.bca.mobile_programming.unit_6.ListViewMain;
import com.bca.mobile_programming.unit_6.RecyclerViewListMain;

public class Home extends AppCompatActivity {

    private Button dashButton;
    private ViewGroup rootLayout;

    @Override
    protected void onStart() {
        super.onStart();

        //        setting color of status bar

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.blue_500));

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

        rootLayout = findViewById(R.id.homeRoot);
        dashButton = findViewById(R.id.homeDashButton);
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

//        dialogButton.setOnClickListener(v-> {
//            Toast.makeText(getApplicationContext(), "Dialog button is click", Toast.LENGTH_SHORT).show();
//        });

        activityButton.setOnClickListener(v -> {
            Intent i = new Intent(Home.this, Contact.class);
            startActivity(i);
        });

        dialogButton.setOnClickListener(v -> {
            AlertUtil alert = new AlertUtil(this, rootLayout);
            alert.show(getSupportFragmentManager(), "alert");
        });

        fragmentButtonImage.setOnClickListener(v -> {
            Intent i = new Intent(Home.this, ImageFragmentActivity.class);
            startActivity(i);
        });

        dashButton.setOnClickListener(V ->{
            PopupMenu popup = new PopupMenu(Home.this, V);
            popup.getMenuInflater().inflate(R.menu.popup_options, popup.getMenu());

            popup.setOnMenuItemClickListener(item -> {
                String close = "Bye";
                int selectedItem = item.getItemId();

                if(selectedItem == R.id.popupOptionProfile){
//                    Intent i = new Intent(Home.this, UserProfileMain.class);
//                    startActivity(i);
                    GeneralUtil.showMySnack(rootLayout, "Profile", close);
                    return true;
                } else if(selectedItem == R.id.popupOptionServices){
//                    Intent i = new Intent(Home.this, UserService.class);
//                    startActivity(i);
                    GeneralUtil.showMySnack(rootLayout, "Service", close);
                    return true;
                } else if(selectedItem == R.id.popupOptionProfileService){
//                    Intent i = new Intent(Home.this, UserProfileService.class);
//                    startActivity(i);
                    GeneralUtil.showMySnack(rootLayout, "Profile Service", close);
                    return true;
                } else if(selectedItem == R.id.popupOptionMap){
//                    Intent i = new Intent(Home.this, UserMap.class);
//                    startActivity(i);
                    GeneralUtil.showMySnack(rootLayout, "Map", close);
                    return true;
                }

                return false;
            });

            popup.show();
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
            Intent i = new Intent(Home.this, ListViewMain.class);
            startActivity(i);
            Toast.makeText(this, "List View", Toast.LENGTH_SHORT).show();
            GeneralUtil.showMySnack(rootLayout, "this is list view ",  close);
            return true;
        } else if(selectedItem == R.id.appOptionsCustomListView){
            Intent i = new Intent(Home.this, CustomListViewMain.class);
            startActivity(i);
            Toast.makeText(this, "Custom List View", Toast.LENGTH_SHORT).show();
            return true;
        } else if(selectedItem == R.id.appOptionsGridView){
            Intent i = new Intent(Home.this, GridViewMain.class);
            startActivity(i);
            Toast.makeText(this, "Grid View main", Toast.LENGTH_SHORT).show();
            return true;
        } else if(selectedItem == R.id.appOptionsCustomGridView){
            Intent i = new Intent(Home.this, CustomGridViewMain.class);
            startActivity(i);
            Toast.makeText(this, "Custom Grid View", Toast.LENGTH_SHORT).show();
            return true;
        } else if(selectedItem == R.id.appOptionsRecycleListView){
            Intent i = new Intent(Home.this, RecyclerViewListMain.class);
            startActivity(i);
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

    @Override
    protected void onResume() {
        super.onResume();
        registerForContextMenu(dashButton);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu_options, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        return super.onContextItemSelected(item);
    }
}
