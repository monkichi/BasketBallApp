package com.example.christianzam.basketballleagueapp;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by christianzam on 12/24/2015.
 */
public class TeamsCustomArrayAdapter extends ArrayAdapter<TeamsItem> {
    Context context;
    List<TeamsItem> drawerItemList;
    int layoutResID;

    public TeamsCustomArrayAdapter(Context context, int layoutResourceID,
                                   List<TeamsItem> listItems) {
        super(context, R.layout.teams_row_layout, listItems);
        this.context = context;
        this.drawerItemList = listItems;
        this.layoutResID = layoutResourceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DrawerItemHolder drawerHolder;
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            drawerHolder = new DrawerItemHolder();
            view = inflater.inflate(R.layout.teams_row_layout, parent, false);
            // drawerHolder.teamGameTimeView = (TextView) view.findViewById(R.id.team_game_time);
            drawerHolder.icon = (ImageView) view.findViewById(R.id.team_icon);
            drawerHolder.teamNameView = (TextView) view.findViewById(R.id.team_name);
            drawerHolder.teamLeagueView = (TextView) view.findViewById(R.id.team_league);
            drawerHolder.teamDivisionView = (TextView) view.findViewById(R.id.team_division);
            drawerHolder.teamWinsView = (TextView) view.findViewById(R.id.team_wins);
            drawerHolder.teamLossesView = (TextView) view.findViewById(R.id.team_losses);
            drawerHolder.captainNameView = (TextView) view.findViewById(R.id.captain_name);


            view.setTag(drawerHolder);

        } else {
            drawerHolder = (DrawerItemHolder) view.getTag();
        }

        TeamsItem dItem = (TeamsItem) this.drawerItemList.get(position);
        drawerHolder.icon.setImageDrawable(view.getResources().getDrawable(R.drawable.ic_action_bball));
        drawerHolder.teamNameView.setText(dItem.getTeamName() + " ");
        Log.i("jfkdjf;", dItem.getTeamName());
        drawerHolder.captainNameView.setText(dItem.getCaptainName() + " ");
        Log.i("jfkdjf;", dItem.getCaptainName());
        drawerHolder.teamLeagueView.setText(dItem.getTeamLeague() + " ");
        Log.i("jfkdjf;", dItem.getTeamLeague());
        drawerHolder.teamDivisionView.setText(dItem.getTeamDivision() + " ");
        Log.i("jfkdjf;", dItem.getTeamDivision());
        drawerHolder.teamWinsView.setText(String.valueOf(dItem.getTeamWins()) + " ");
        Log.i("jfkdjf;", String.valueOf(dItem.getTeamWins()));
        drawerHolder.teamLossesView.setText(String.valueOf(dItem.getTeamLosses()) + " ");
        Log.i("jfkdjf;", String.valueOf(dItem.getTeamLosses()));
        //drawerHolder.teamGameTimeView.setText(dItem.getTeamGameTime().toString());


        return view;
    }

    private static class DrawerItemHolder {
        TextView teamNameView;
        TextView captainNameView;
        TextView teamDivisionView;
        TextView teamWinsView;
        TextView teamLossesView;
        // TextView teamGameTimeView;
        TextView teamLeagueView;
        ImageView icon;
    }
}
