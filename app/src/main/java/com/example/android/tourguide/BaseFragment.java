package com.example.android.tourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

import static android.R.attr.name;
import static android.R.attr.y;

/**
 * The fragment base class with the onCreateView method
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.content_fragment_layout, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.content_list);

        ContentListAdapter itemsAdapter = new ContentListAdapter(getActivity(), getContentResource());
        listView.setAdapter(itemsAdapter);

        return rootView;
    }

    protected abstract ContentResource getContentResource();
}
