package com.bca.mobile_programming.unit_6;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class RecycleItemHolder extends RecyclerView.ViewHolder {
    ViewGroup rootView;
    ImageView imageView;
    TextView titleView, descriptionView;

    public RecycleItemHolder(View v, int r, int t, int i, int d){
        super(v);

        rootView = v.findViewById(r);
        titleView = v.findViewById(t);
        imageView = v.findViewById(i);
        descriptionView = v.findViewById(d);
    }
}
