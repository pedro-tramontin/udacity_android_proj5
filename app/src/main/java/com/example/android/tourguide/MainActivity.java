package com.example.android.tourguide;

import android.support.v4.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle mDrawerToggle;

    @BindView(R.id.app_toolbar)
    Toolbar myToolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.drawer_list)
    ListView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(myToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                myToolbar,
                R.string.open,
                R.string.close);

        mDrawerLayout.addDrawerListener(mDrawerToggle);
        final ArrayList<DrawerItem> drawerItems = new ArrayList<>();
        drawerItems.add(new DrawerItem(R.drawable.ic_nature_black_24dp, R.string.parks));
        drawerItems.add(new DrawerItem(R.drawable.ic_restaurant_black_24dp, R.string.restaurants));
        drawerItems.add(new DrawerItem(R.drawable.museum, R.string.museums));
        drawerItems.add(new DrawerItem(R.drawable.soccer, R.string.teams));

        mDrawerList.setAdapter(new DrawerItemAdapter(this, drawerItems));
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Fragment fragment = new ParksFragment();
                switch (position) {
                    case 1:
                        fragment = new RestaurantsFragment();
                        break;
                    case 2:
                        fragment = new MuseumsFragment();
                        break;
                    case 3:
                        fragment = new TeamsFragment();
                        break;
                }

                showFragment(fragment);

                // update selected item and title, then close the drawer
                mDrawerList.setItemChecked(position, true);
                String itemTitle = getResources().getString(drawerItems.get(position)
                        .getTextResourceId());
                getSupportActionBar().setTitle(itemTitle);
                mDrawerLayout.closeDrawer(Gravity.START);
            }
        });

        // Show the Parks fragment first
        showFragment(new ParksFragment());
    }

    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
