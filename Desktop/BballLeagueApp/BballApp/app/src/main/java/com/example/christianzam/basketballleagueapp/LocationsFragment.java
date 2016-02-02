package com.example.christianzam.basketballleagueapp;

import android.app.Fragment;
import android.app.ListFragment;

/**
 * Created by christianzam on 12/21/2015.
 */

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

//import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by christianzam on 12/19/2015.
 */
public class LocationsFragment extends android.support.v4.app.ListFragment {

    List<LocationsListItem> locationItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }
        return inflater.inflate(R.layout.fragment_locations, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        locationItems = new ArrayList<LocationsListItem>();
        setlocationItems();
        setListAdapter(new LocationsCustomArrayAdapter(this.getActivity(), locationItems));

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        // String item = (String) getListAdapter().getItem(position);
        //Fragment locationMapFrag = new LocationsMapFragment();
        Toast.makeText(this.getActivity().getApplicationContext(), position + " selected", Toast.LENGTH_LONG).show();
        this.getListView().setItemChecked(position, true);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        if (position == 0) {
          //  LatLng location = new LatLng(20, 10);
            android.support.v4.app.Fragment locationMapFrag = new LocationsMapFragment();
            transaction.add(locationMapFrag, "Hi");
            transaction.addToBackStack(null);
            transaction.commit();
        } else if (position == 1) {

        }

    }

    private void setlocationItems() {
        locationItems.add(new LocationsListItem("Granada High School", "1325 Roscoe Blvd", 6.0));
        locationItems.add(new LocationsListItem("Granada High School", "1325 Roscoe Blvd", 4.7));
        locationItems.add(new LocationsListItem("Granada High School", "1325 Roscoe Blvd", 5.0));
        locationItems.add(new LocationsListItem("Granada High School", "1325 Roscoe Blvd", 1.0));
        locationItems.add(new LocationsListItem("Granada High School", "1325 Roscoe Blvd", 3.0));
    }
}
