package com.example.christianzam.basketballleagueapp;

import android.app.Fragment;
import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

//import com.google.android.gms.common.api.GoogleApiClient;
//import com.google.android.gms.location.LocationServices;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private Toolbar toolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    private String connectUrl = "http://chrisjavate.com/practiceDB.php";
    private CustomNavDrawerAdapter adapter;
    private List<DrawerItem> dataList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout1);
        mDrawerList = (ListView) findViewById(R.id.left);
        dataList = new ArrayList<DrawerItem>();
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_drawer);
        mTitle = mDrawerTitle = getTitle();
        setItems();
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
                GravityCompat.START);
        // Set the adapter for the list view
        mDrawerList.setAdapter(new CustomNavDrawerAdapter(this, R.layout.drawer_list_item, dataList));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        // enable ActionBar app icon to behave as action to toggle nav drawer
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {


            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()

            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        //Toast.makeText(getApplicationContext(), "Click Not Detected Yet ", Toast.LENGTH_LONG).show();
       FragmentTransaction tf = getSupportFragmentManager().beginTransaction();
        //Add Main Activities main fragment
        android.support.v4.app.Fragment homeFrag = new HomeScreenFragment();
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            // fetch data
            //new ProcessJSON().execute(connectUrl);
            tf.replace(R.id.content_frame, homeFrag);
            tf.addToBackStack(null);
            tf.commit();

        } else {
            // display error
            Log.d("URlreader", "Was not able to connect");
        }


    }

    /* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        //menu.findItem(R.id.action_websearch).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    public void setItems() {
        dataList.add(new DrawerItem("Home", R.drawable.ic_home_white_36dp));
        dataList.add(new DrawerItem("Teams", R.drawable.ic_action_bball));
        dataList.add(new DrawerItem("Schedule", R.drawable.ic_action_event));
        dataList.add(new DrawerItem("Standings", R.drawable.ic_action_view_as_list));
        dataList.add(new DrawerItem("Locations", R.drawable.ic_action_map));
        dataList.add(new DrawerItem("About", R.drawable.ic_action_about));
    }

    private class DrawerItemClickListener implements android.widget.AdapterView.OnItemClickListener {

        private CharSequence mTitle;

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(getApplicationContext(), "Click Detected " + position, Toast.LENGTH_LONG).show();
            selectItem(position);

        }

        /**
         * Swaps fragments in the main content view
         */
        private void selectItem(int position) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            // Create a new fragment and specify the planet to show based on position
            android.support.v4.app.Fragment scheduleFrag = new ScheduleFragment();
            android.support.v4.app.Fragment standingsFrag = new StandingsFragment();
            android.support.v4.app.Fragment locationFrag = new LocationsFragment();
            android.support.v4.app.Fragment leagueFrag = new LeagueFragment();
            android.support.v4.app.Fragment divisionFrag = new DivisionFragment();
            android.support.v4.app.Fragment teamsFrag = new TeamsFragment();
            android.support.v4.app.Fragment homeFrag = new HomeScreenFragment();
            mDrawerList.setItemChecked(position, true);


            if (position == 0) {
                transaction.replace(R.id.content_frame, homeFrag);
                transaction.addToBackStack(null);
                transaction.commit();

            } else if (position == 1) {
                transaction.replace(R.id.content_frame, teamsFrag);
                transaction.addToBackStack(null);
                transaction.commit();

            } else if (position == 2) {
                transaction.replace(R.id.content_frame, scheduleFrag);
                transaction.addToBackStack(null);
                transaction.commit();
                ConnectivityManager connMgr = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {
                    // fetch data
                    new ProcessJSON().execute(connectUrl);

                } else {
                    // display error
                    Log.d("URlreader", "Was not able to connect");
                }

            } else if (position == 3) {
                transaction.replace(R.id.content_frame, standingsFrag);
                transaction.addToBackStack(null);
                transaction.commit();
            } else if (position == 4) {
                transaction.replace(R.id.content_frame, locationFrag);
                transaction.addToBackStack(null);
                transaction.commit();
            }

            // Highlight the selected item, update the title, and close the drawer
            mDrawerLayout.closeDrawer(mDrawerList);

        }


        public void setTitle(CharSequence title) {
            mTitle = title;
            getActionBar().setTitle(mTitle);
            toolbar.setTitle(mTitle);
        }


    }

    private class ProcessJSON extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... strings) {
            String stream = null;
            String urlString = strings[0];
            try {
                //Create instance of object to get Http Data
                HTTPDataHandler hh = new HTTPDataHandler();
                //Storing the output of http data for given url
                stream = hh.GetHTTPData(urlString);
            } catch (Exception e) {
            }
            // Return the data from specified url
            Log.d("URL DATA OUTPUT", stream);
            return stream;
        }

        protected void onPostExecute(String stream) {
            /*
                Important in JSON DATA
                -------------------------
                * Square bracket ([) represents a JSON array
                * Curly bracket ({) represents a JSON object
                * JSON object contains key/value pairs
                * Each key is a String and value may be different data types
             */
            //..........Process JSON DATA................
            if (stream != null) {
                try {
                    // Get the full HTTP Data as JSONObject
                    JSONObject reader = new JSONObject(stream);
                    // Get the JSONObject "coord"...........................
                    JSONObject player = reader.getJSONObject("Players");
                    // Get the value of key "PlayerID" under JSONObject "coord"
                    String playerID = player.getString("PlayerID");
                    // Get the value of key "FirstName" under JSONObject "coord"
                    String playerFirstName = player.getString("FirstName");
                    // Get the value of key "LastName" under JSONObject "coord"
                    String playerLastName = player.getString("LastName");
                    // Get the value of key "Team" under JSONObject "coord"
                    String playerTeam = player.getString("Team");
                    // process other data as this way..............

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } // if statement end
        } // onPostExecute() end
    } // ProcessJSON class end

}
