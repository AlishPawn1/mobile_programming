package com.bca.mobile_programming.unit_6;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bca.mobile_programming.R;
import com.bca.mobile_programming.unit_1.GeneralUtil;

import java.util.ArrayList;

public class CustomRecyclerViewListItem extends RecyclerView.Adapter<RecycleItemHolder>{
    Activity ctx;
    ArrayList<AlbumDetail> data;

    public CustomRecyclerViewListItem(Activity context, ArrayList<AlbumDetail> d){
        this.data = d;
        this.ctx = context;
    }

    @NonNull
    @Override
    public RecycleItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(ctx);
        View listItem = layoutInflater.inflate(R.layout.unit_6_custom_list_item, parent, false);
        return new RecycleItemHolder(listItem, R.id.customListItemRoot, R.id.customListItemTitle, R.id.customListItemImage, R.id.customListItemDescription);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleItemHolder holder, int position) {
        AlbumDetail albumDetail = data.get(position);

        holder.titleView.setText(albumDetail.getTitle());
        holder.imageView.setImageResource(albumDetail.getImage());
        holder.descriptionView.setText(albumDetail.getDescription());

        holder.rootView.setOnClickListener(v ->{
            String close = "Begone";
            String message = albumDetail.getTitle();
            GeneralUtil.showMySnack(holder.rootView, message, close);
        });

        holder.imageView.setOnClickListener( v -> Toast.makeText(ctx, String.valueOf(albumDetail.getImage()), Toast.LENGTH_SHORT).show());
    }
}
