package com.example.christianzam.basketballleagueapp;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by christianzam on 12/25/2015.
 */
public class HomeScreenFragment extends android.support.v4.app.ListFragment  {
    List<HomeItem> homeItems ;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)  {
        super.onActivityCreated(savedInstanceState);
        homeItems = new ArrayList<HomeItem>();
        setHomeItems();
        setListAdapter(new HomeCustomArrayAdapter(this.getActivity(), R.layout.home_row_layout, homeItems));

    }

    public void setHomeItems(){
       //Had to use try catch for compiler was bugging about malformed url
        try{
            URL imageUrl = new URL("http://cdn3.sportngin.com/attachments/call_to_action/5529/1379/basketball.jpeg");
            URL videoURl = new URL("http://www.ebookfrenzy.com/android_book/movie.mp4");
            homeItems.add(new HomeItem(null, imageUrl, null ));
            homeItems.add(new HomeItem(null, null ,videoURl));
            homeItems.add(new HomeItem(null, imageUrl, null));
            Log.v("Array Size Test"," This is the size of homeItem"+ " "+ homeItems.size());
        }
        catch (MalformedURLException mEx){

        }
    }

}
