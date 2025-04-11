package com.bca.mobile_programming.unit_6;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bca.mobile_programming.R;
import com.bca.mobile_programming.unit_1.GeneralUtil;

public class ListViewMain extends AppCompatActivity {

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

        String[] flowerList = res.getStringArray(R.array.flower_names);

        ArrayAdapter<String> flowerAdapter = new ArrayAdapter<>(
                this,
                R.layout.unit_3_spinner_item,
                R.id.spinnerItemText,
                flowerList
        );

        listView.setAdapter(flowerAdapter);

        listView.setOnItemClickListener((list, v, position, id) -> {
            String close = "Okay";
            Adapter listAdapter = list.getAdapter();
            String value = listAdapter.getItem(position).toString();
            String message = value + " at position " + position + " with id " + id;
            GeneralUtil.showMySnack(rootLayout, message, close);
        });
    }
}
