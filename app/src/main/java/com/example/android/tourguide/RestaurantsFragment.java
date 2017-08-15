package com.example.android.tourguide;


/**
 * The restaurants fragment content
 */
public class RestaurantsFragment extends BaseFragment {

    private final ContentResource restaurantsResources = initRestaurantsContentResources();

    private ContentResource initRestaurantsContentResources() {
        Integer[] restaurantsPhotos = {R.drawable.restaurant_coco, R.drawable.restaurant_taste, R
                .drawable.restaurant_nosu, R.drawable.restaurant_fleming, R.drawable
                .restaurant_ristorantino};

        return new ContentResource(restaurantsPhotos.length, restaurantsPhotos, R
                .array.restaurants_name_array, R.array.restaurants_address_array, R.array
                .restaurants_hours);
    }

    @Override
    protected ContentResource getContentResource() {
        return restaurantsResources;
    }
}
