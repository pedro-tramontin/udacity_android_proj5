package com.example.android.tourguide;


/**
 * The teams fragment content
 */
public class TeamsFragment extends BaseFragment {

    private final ContentResource teamsResources = initTeamsContentResources();

    private ContentResource initTeamsContentResources() {
        Integer[] teamsPhotos = {R.drawable.team_sao_paulo, R.drawable.team_corinthians, R
                .drawable.team_palmeiras};

        return new ContentResource(teamsPhotos.length, teamsPhotos, R.array.teams_name_array, R
                .array.teams_address_array, null);
    }

    @Override
    protected ContentResource getContentResource() {
        return teamsResources;
    }
}
