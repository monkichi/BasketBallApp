package com.example.christianzam.basketballleagueapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


public class ScheduleFragment extends ListFragment {

    List<ScheduleListItem> scheduleListItems;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_schedule, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        scheduleListItems = new ArrayList<ScheduleListItem>();
        setScheduleListItems();
        setListAdapter(new ScheduleCustomArrayAdapter(getActivity(), scheduleListItems));
    }



    private void setScheduleListItems(){
        GregorianCalendar gameTimeTest = new GregorianCalendar(2015,30,3,12,30,0);
        scheduleListItems.add(new ScheduleListItem("Los Angeles", "Oklahoma", "Granada Hills High School", gameTimeTest));


    }
}
