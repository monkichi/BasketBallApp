package com.example.christianzam.basketballleagueapp;

/**
 * Created by christianzam on 12/19/2015.
 */
public class LocationsListItem {
    String locationName;
    String locationAddress;
    double locationDistance;

    public LocationsListItem(String itemName, String itemAddress, double distance) {
        super();
        locationName = itemName;
        locationAddress = itemAddress;
        locationDistance = distance;

    }

    public String getItemName() {
        return locationName;
    }

    public void setItemName(String itemName) {
        locationName = itemName;
    }

    public String getItemAddress() {
        return locationAddress;
    }

    public void setItemAddress(String itemAdd) {
        locationAddress = itemAdd;
    }

    public double getLocationDistance() {
        return locationDistance;
    }

    public void setLocationDistance(int dist) {
        locationDistance = dist;
    }
}
