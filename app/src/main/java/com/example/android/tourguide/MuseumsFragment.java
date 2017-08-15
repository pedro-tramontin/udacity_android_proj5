package com.example.android.tourguide;


/**
 * The museums fragment content
 */
public class MuseumsFragment extends BaseFragment {

    private final ContentResource museumsResources = initMuseumsContentResources();

    private ContentResource initMuseumsContentResources() {
        Integer[] museumsPhotos = {R.drawable.museu_pinacoteca, R.drawable.museu_catavento, R
                .drawable.museu_futebol, R.drawable.museu_masp, R.drawable.museu_ohtake};

        return new ContentResource(museumsPhotos.length, museumsPhotos, R
                .array.museums_name_array, R.array.museums_address_array, R.array.museums_hours);
    }

    @Override
    protected ContentResource getContentResource() {
        return museumsResources;
    }
}
