package com.example.android.tourguide;


/**
 * The parks fragment content
 */
public class ParksFragment extends BaseFragment {

    private final ContentResource parksResources = initParksContentResources();

    private ContentResource initParksContentResources() {
        Integer[] parksPhotos = {R.drawable.park_ibirapuera, R.drawable.park_villa_lobos, R
                .drawable.park_independencia, R.drawable.park_horto_florestal, R.drawable.park_trianon};

        return new ContentResource(parksPhotos.length, parksPhotos, R
                .array.parks_name_array, R.array.parks_address_array, null);
    }

    @Override
    protected ContentResource getContentResource() {
        return parksResources;
    }
}
