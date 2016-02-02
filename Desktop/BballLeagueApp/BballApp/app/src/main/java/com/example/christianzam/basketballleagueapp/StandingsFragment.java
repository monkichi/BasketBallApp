package com.example.christianzam.basketballleagueapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by christianzamu on 10/29/2015.
 */
public class StandingsFragment extends Fragment {

    View standingsView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    //must add false option gives  java.lang.IllegalStateException: The specified child already has a parent. You must call removeView() on the child's parent first.
        View view = inflater.inflate(R.layout.fragment_standings,
                container, false);

        //Create Overall Table layout
        TableLayout table = (TableLayout) view.findViewById(R.id.main_table);
        //Set some settings idk what they do yet
        table.setStretchAllColumns(true);
        table.setShrinkAllColumns(true);
        //Create the main title row for Standings page
        TableRow mainTableRowTitle = new TableRow(getActivity());
        mainTableRowTitle.setGravity(Gravity.CENTER_HORIZONTAL);
        //Create the text view to go on Main table row
        TextView mainTableRowTileView = new TextView(getActivity());
        mainTableRowTileView.setText("Standings");
        mainTableRowTileView.setTextColor(getResources().getColor(R.color.WhiteSmoke));
        mainTableRowTileView.setGravity(Gravity.CENTER_HORIZONTAL);
        //Add the view to the row
        mainTableRowTitle.addView(mainTableRowTileView);
        //Add Main Title Row to table
        table.addView(mainTableRowTitle);

        /*Create row and columns for standings categories*/
       //Create the Row to store all Categorie Text Views
        TableRow standingsCategoriesRow = new TableRow(getActivity());

        String[] standingCategoriesTemp = {"Team", "W-L", "Pct", "GB"};
        for(int i = 0; i < standingCategoriesTemp.length; i++){
            TextView standingsCategoriesRowView = new TextView(getActivity());
            standingsCategoriesRowView.setTextColor(getResources().getColor(R.color.WhiteSmoke));
            standingsCategoriesRowView.setText(standingCategoriesTemp[i] + " ");
            standingsCategoriesRow.setGravity(Gravity.CENTER_HORIZONTAL);
            //Add the textviews to the Categories Row
            standingsCategoriesRow.addView(standingsCategoriesRowView);
            Log.i("Standing Cate Loop","This is the value of loop variable" + " "+ i);
        }
      /* //Add the textviews to the Categories Row
        standingsCategoriesRow.addView(standingsCategoriesRowView);*/

        //Add the Categories Row View the table
        table.addView(standingsCategoriesRow);

        //Dynamically create the the row and columns for the data

        //Loop through the Array of Data



        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
