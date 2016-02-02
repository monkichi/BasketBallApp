package com.example.christianzam.basketballleagueapp;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by christianzamu on 11/3/2015.
 */
public class DivisionFragment extends android.support.v4.app.ListFragment {
    public DivisionFragment() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_division, container, false);
    }

}
