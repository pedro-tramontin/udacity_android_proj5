package com.example.android.tourguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import static java.util.Collections.nCopies;

/**
 * Adapter for the ArrayList of Attractions
 */

public class ContentListAdapter extends ArrayAdapter<Attraction> {

    public ContentListAdapter(Activity context, ContentResource contentResouce) {
        super(context, 0);

        addAll(buildAttractionsList(contentResouce));
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.content_list_item, parent, false);
        }

        Attraction currentItem = getItem(position);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.attraction_image);
        imageView.setImageResource(currentItem.getImage());

        TextView descTextView = (TextView) listItemView.findViewById(R.id.attraction_description);
        descTextView.setText(currentItem.getDescription());

        TextView addTextView = (TextView) listItemView.findViewById(R.id.attraction_address);
        addTextView.setText(currentItem.getAddress());

        String hours = currentItem.getHours();
        if (hours != null) {
            TextView hoursTextView = (TextView) listItemView.findViewById(R.id.attraction_hours);
            hoursTextView.setText(hours);

            LinearLayout layoutHours = (LinearLayout) listItemView.findViewById(R.id.layout_hours);
            layoutHours.setVisibility(LinearLayout.VISIBLE);
        }

        return listItemView;
    }

    /**
     * Build an ArrayList of Attraction based on the ContentResource passed as parameter
     *
     * @param contentResouce constains the resources used to build the ArrayList
     * @return ArrayList of Attraction
     */
    protected ArrayList<Attraction> buildAttractionsList(ContentResource contentResouce) {
        ArrayList<Attraction> attractions = new ArrayList<>();

        int total = contentResouce.getTotal();

        Integer[] photos = contentResouce.getPhotos();
        String[] names = getStringsArray(contentResouce.getNamesArray());
        String[] addresses = getStringsArray(contentResouce.getAddressesArray());

        String[] hours;
        if (contentResouce.getHoursArray() != null) {
            hours = getStringsArray(contentResouce.getHoursArray());
        } else {
            hours = Collections.nCopies(total, (String) null).toArray(new String[total]);
        }

        for (int i = 0; i < total; i++) {
            attractions.add(new Attraction(photos[i], names[i], addresses[i], hours[i]));
        }

        return attractions;
    }

    /**
     * Gets the StringArray the resource points to
     *
     * @param resource the string-array resource id
     * @return array of String for the resource id
     */
    private String[] getStringsArray(int resource) {
        return getContext().getResources().getStringArray(resource);
    }
}
