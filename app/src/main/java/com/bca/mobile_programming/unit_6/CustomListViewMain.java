package com.bca.mobile_programming.unit_6;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bca.mobile_programming.R;
import com.bca.mobile_programming.unit_1.GeneralUtil;

public class CustomListViewMain extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();

        ActionBar bar = getSupportActionBar();
        if (bar != null) bar.hide();
    }

    @Override
    protected void onCreate(@Nullable Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.unit_6_list_view_main);

        Resources res = getResources();

        ListView listView = findViewById(R.id.listViewMainList);
        ViewGroup rootLayout = findViewById(R.id.listViewMainRoot);

        String[] titleList = res.getStringArray(R.array.flower_names);
        String[] descriptionList = res.getStringArray(R.array.custom_description_list);
        int[] imagesList = {
                R.drawable.rose,
                R.drawable.lily,
                R.drawable.tulip,
                R.drawable.daisy,
                R.drawable.orchid,
                R.drawable.sunflower,
                R.drawable.marigold,
                R.drawable.lavender,
                R.drawable.peony,
                R.drawable.ch
        };

        CustomListItem customAdapter = new CustomListItem(this, titleList, descriptionList, imagesList);

        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener((list, v, position, id) -> {
            String close = "Okay";
            Adapter listAdapter = list.getAdapter();
            String value = listAdapter.getItem(position).toString();
            String message = value + " at position " + (position + 1) + " with id " + id;
            GeneralUtil.showMySnack(rootLayout, message, close);
        });
    }
}
