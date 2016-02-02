package com.example.christianzam.basketballleagueapp;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by christianzamu on 11/3/2015.
 */
public class LeagueFragment extends ListFragment {
    public LeagueFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.league_row_layout));
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Log.i("FragmentList", "Item clicked: " + id);
        super.onListItemClick(l, v, position, id);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
