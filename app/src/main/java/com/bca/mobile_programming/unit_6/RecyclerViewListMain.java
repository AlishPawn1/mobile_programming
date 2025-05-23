package com.bca.mobile_programming.unit_6;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bca.mobile_programming.R;

import java.util.ArrayList;

public class RecyclerViewListMain extends AppCompatActivity {
    TypedArray imageList;

    @Override
    protected void onStart() {
        super.onStart();

        ActionBar bar = getSupportActionBar();
        if (bar != null) bar.hide();
    }

    @Override
    protected void onCreate(@Nullable Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.unit_6_recycle_view_main);

        Resources res = getResources();
        RecyclerView recyclerView = findViewById(R.id.recycleViewListMainList);

        ArrayList<AlbumDetail> albumDetails = new ArrayList<>(10);
        imageList = res.obtainTypedArray(R.array.flower_image);
        String[] titleList = res.getStringArray(R.array.flower_names);
        String[] descriptionList = res.getStringArray(R.array.custom_description_list);

        int[] imageIds = new int[imageList.length()];

        //Set image resource id to imageList array
        for (int i=0; i<imageIds.length; i++) imageIds[i] = imageList.getResourceId(i, 0);

        //Generate new AlbumDetail for each title, description and image
        for (int i=0; i<titleList.length;i++)
            albumDetails.add(new AlbumDetail(titleList[i], descriptionList[i], imageIds[i]));

        RecyclerView.LayoutManager layout = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layout);

        CustomRecyclerViewListItem itemList = new CustomRecyclerViewListItem(this, albumDetails);

        recyclerView.setAdapter(itemList);
    }
}