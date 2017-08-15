package com.example.android.tourguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Adapter for the menu items
 */

public class DrawerItemAdapter extends ArrayAdapter<DrawerItem> {

    public DrawerItemAdapter(Activity context, ArrayList<DrawerItem> items) {
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.menu_list_item, parent, false);
        }

        DrawerItem currentItem = getItem(position);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.menu_item_icon);
        imageView.setImageResource(currentItem.getImageResourceId());

        TextView itemTextView = (TextView) listItemView.findViewById(R.id.item_title);
        itemTextView.setText(getContext().getString(currentItem.getTextResourceId()));

        return listItemView;
    }
}
