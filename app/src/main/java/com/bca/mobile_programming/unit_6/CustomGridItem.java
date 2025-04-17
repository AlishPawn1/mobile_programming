package com.bca.mobile_programming.unit_6;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bca.mobile_programming.R;

public class CustomGridItem extends ArrayAdapter<String> {
    int[] image;
    Activity ctx;
    String[] title;
    String[] description;

    public CustomGridItem(Activity Context, String[] title, String[] description, int[] image){
        super(Context, R.layout.unit_6_custom_grid_item,title);

        this.ctx = Context;
        this.title = title;
        this.description= description;
        this.image = image;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View listItem, @NonNull ViewGroup parent) {
        ListItemHolder holder;

        if(listItem == null){
            LayoutInflater inflater = ctx.getLayoutInflater();

            // Inflate the layout
            listItem =  inflater.inflate(R.layout.unit_6_custom_grid_item, parent, false);

            // Creating a new ViewHolder
            holder = new ListItemHolder();

            // Fionf individual views and store in the viewHolder
            holder.title = listItem.findViewById(R.id.customGridItemTitle);
            holder.image = listItem.findViewById(R.id.customGridItemImage);
            holder.description = listItem.findViewById(R.id.customGridItemDescription);

            // Store the viewHolder within the view
            listItem.setTag(holder);
        } else holder = (ListItemHolder) listItem.getTag();

        // set relevant data to the widgets
        holder.title.setText(title[position]);
        holder.image.setImageResource(image[position]);
        holder.description.setText(description[position]);

        return listItem;
    }
}
