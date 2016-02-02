package com.example.christianzam.basketballleagueapp;

import android.content.Context;
import android.widget.ArrayAdapter;

/**
 * Created by christianzam on 12/19/2015.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class LocationsCustomArrayAdapter extends ArrayAdapter<LocationsListItem> {

    Context context;
    List<LocationsListItem> drawerItemList;

    public LocationsCustomArrayAdapter(Context context, List<LocationsListItem> listItems) {
        super(context, R.layout.locations_row_layout, listItems);
        this.context = context;
        this.drawerItemList = listItems;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        DrawerItemHolder drawerHolder;
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            drawerHolder = new DrawerItemHolder();
            view = inflater.inflate(R.layout.locations_row_layout, parent, false);
            drawerHolder.locationTitleView = (TextView) view.findViewById(R.id.location_title);
            drawerHolder.locationAddressView = (TextView) view.findViewById(R.id.location_subtitle);
            drawerHolder.locationDistanceView = (TextView) view.findViewById(R.id.location_distance);
            drawerHolder.locationIconView = (ImageView) view.findViewById(R.id.location_icon);

            view.setTag(drawerHolder);

        } else {
            drawerHolder = (DrawerItemHolder) view.getTag();

        }

        LocationsListItem dItem = this.drawerItemList.get(position);
        drawerHolder.locationIconView.setImageDrawable(view.getResources().getDrawable(R.drawable.ic_action_place));
        drawerHolder.locationTitleView.setText(dItem.getItemName());
        drawerHolder.locationAddressView.setText(dItem.getItemAddress());
        drawerHolder.locationDistanceView.setText(String.valueOf(dItem.getLocationDistance() + "mi"));

        return view;
    }

    private static class DrawerItemHolder {
        TextView locationTitleView;
        TextView locationAddressView;
        TextView locationDistanceView;
        ImageView locationIconView;
    }
}