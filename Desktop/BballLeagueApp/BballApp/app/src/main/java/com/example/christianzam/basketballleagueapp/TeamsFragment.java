package com.example.christianzam.basketballleagueapp;

import android.app.ListFragment;
import android.app.SearchManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by christianzam on 12/21/2015.
 */
public class TeamsFragment extends android.support.v4.app.ListFragment implements SearchView.OnCloseListener, SearchView.OnQueryTextListener {
    List<TeamsItem> teamItems;
    SearchView searchView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }
        return inflater.inflate(R.layout.fragment_teams, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //prepare the SearchView
        searchView = (SearchView) getView().findViewById(R.id.search);
        searchView.setQueryHint("Team Name");

        //Sets the default or resting state of the search field. If true, a single search icon is shown by default and
        // expands to show the text field and other buttons when pressed. Also, if the default state is iconified, then it
        // collapses to that state when the close button is pressed. Changes to this property will take effect immediately.
        //The default value is true.
        searchView.setIconifiedByDefault(false);
        searchView.setOnCloseListener(this);
        searchView.setOnQueryTextListener(this);
        //Set up the teamCategories table layout
       // TableLayout teamCategoriesTable = (TableLayout) getView().findViewById(R.id.main_table);
        //TableRow teamCategoriesTableHeadingRow = new TableRow(this.getView().getContext());
        //teamCategoriesTableHeadingRow.setBackgroundColor(Color.GRAY);


        TextView teamNameCategoryView =  (TextView) getView().findViewById(R.id.team_name_title);
        teamNameCategoryView.setText("Team");
        teamNameCategoryView.setTextColor(getResources().getColor(R.color.WhiteSmoke));
        teamNameCategoryView.setPadding(5, 5, 5, 5);
        teamNameCategoryView.setGravity(Gravity.CENTER_HORIZONTAL);
        //teamCategoriesTableHeadingRow.addView(teamNameCategoryView);



        TextView teamCaptainNameCategoryView = (TextView) getView().findViewById(R.id.captain_name_title);
        teamCaptainNameCategoryView.setText("Captain");
        teamCaptainNameCategoryView.setTextColor(getResources().getColor(R.color.WhiteSmoke));
        teamCaptainNameCategoryView.setPadding(5, 5, 5, 5);
        teamCaptainNameCategoryView.setGravity(Gravity.CENTER_HORIZONTAL);
        //teamCategoriesTableHeadingRow.addView(teamCaptainNameCategoryView);

        TextView teamLeagueCategoryView =  (TextView) getView().findViewById(R.id.team_league_title);
        teamLeagueCategoryView.setText("League");
        teamLeagueCategoryView.setTextColor(getResources().getColor(R.color.WhiteSmoke));
        teamLeagueCategoryView.setPadding(5, 5, 5, 5);
        //teamCategoriesTableHeadingRow.addView(teamLeagueCategoryView);

        TextView teamDivisionCategoryView =  (TextView) getView().findViewById(R.id.team_division_title);
        teamDivisionCategoryView.setText("Division");
        teamDivisionCategoryView.setTextColor(getResources().getColor(R.color.WhiteSmoke));
        teamDivisionCategoryView.setPadding(5, 5, 5, 5);
        //teamCategoriesTableHeadingRow.addView(teamDivisionCategoryView);

        TextView teamWinsCategoryView =  (TextView) getView().findViewById(R.id.team_wins_title);
        teamWinsCategoryView.setText("W");
        teamWinsCategoryView.setTextColor(getResources().getColor(R.color.WhiteSmoke));
        teamWinsCategoryView.setPadding(5, 5, 5, 5);
        //teamCategoriesTableHeadingRow.addView(teamWinsCategoryView);

        TextView teamLossesCategoryView =  (TextView) getView().findViewById(R.id.team_losses_title);
        teamLossesCategoryView.setText("L");
        teamNameCategoryView.setTextColor(getResources().getColor(R.color.WhiteSmoke));
        teamNameCategoryView.setPadding(5, 5, 5, 5);
        //teamCategoriesTableHeadingRow.addView(teamLossesCategoryView);



        //teamCategoriesTable.addView(teamCategoriesTableHeadingRow);

        teamItems = new ArrayList<TeamsItem>();
        setTeamItems();
        setListAdapter(new TeamsCustomArrayAdapter(this.getActivity().getApplicationContext(), R.layout.teams_row_layout, teamItems));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String item = (String) getListAdapter().getItem(position);
        Toast.makeText(this.getActivity().getApplicationContext(), item + " selected", Toast.LENGTH_LONG).show();
        this.getListView().setItemChecked(position, true);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if (position == 0) {

        } else if (position == 1) {

        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    public void setTeamItems() {
        teamItems.add(new TeamsItem("Lakers", "John", "Liga Latina", "first", 5, 7, 1));
        teamItems.add(new TeamsItem("Lakers", "John", "Liga Latina", "first", 5, 7, 1));
        teamItems.add(new TeamsItem("Lakers", "John", "Liga Latina", "first", 5, 7, 1));
    }

    @Override
    public boolean onClose() {
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
