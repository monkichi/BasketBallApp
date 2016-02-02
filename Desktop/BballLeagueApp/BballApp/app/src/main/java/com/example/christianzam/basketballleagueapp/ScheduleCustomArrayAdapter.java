package com.example.christianzam.basketballleagueapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;

/**
 * Created by christianzam on 1/30/2016.
 */
public class ScheduleCustomArrayAdapter extends ArrayAdapter<ScheduleListItem> {
    Context context;
    List<ScheduleListItem> drawerItemList;

    public ScheduleCustomArrayAdapter(Context context, List<ScheduleListItem> listItems) {
        super(context, R.layout.schedule_row_layout, listItems);
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
            view = inflater.inflate(R.layout.schedule_row_layout, parent, false);
            drawerHolder.gameDateView = (TextView) view.findViewById(R.id.game_date);
            drawerHolder.gameTimeView = (TextView) view.findViewById(R.id.game_time);
            drawerHolder.teamName1View = (TextView) view.findViewById(R.id.team_name1);
            drawerHolder.teamName2View = (TextView) view.findViewById(R.id.team_name2);
            drawerHolder.gameLocationView = (TextView) view.findViewById(R.id.game_location);
            view.setTag(drawerHolder);

        } else {
            drawerHolder = (DrawerItemHolder) view.getTag();

        }

        ScheduleListItem dItem = this.drawerItemList.get(position);
        String months[] = {
                "Jan", "Feb", "Mar", "Apr",
                "May", "Jun", "Jul", "Aug",
                "Sep", "Oct", "Nov", "Dec"};
        // Display Date information
        String monthString = months[dItem.getGameTime().get(Calendar.MONTH)] + " ";
        String monthDayString =  dItem.getGameTime().get(Calendar.DATE) + " ";
        String yearSting =  String.valueOf(dItem.getGameTime().get(Calendar.YEAR)+ " ");

        //Display Time information
        String timeHourString =  dItem.getGameTime().get(Calendar.HOUR) + ":" ;
        String timeMinuteString = dItem.getGameTime().get(Calendar.MINUTE) + " ";

        drawerHolder.gameTimeView.setText(timeHourString + timeMinuteString);
        drawerHolder.gameDateView.setText(monthString + monthDayString + yearSting);
        drawerHolder.teamName1View.setText(dItem.getTeamName1() + " " +" vs " );
        drawerHolder.teamName2View.setText(dItem.getTeamName2());
        drawerHolder.gameLocationView.setText("@ "+dItem.getGameLocation());

        return view;
    }

    private static class DrawerItemHolder {
        TextView gameTimeView;
        TextView teamName1View;
        TextView teamName2View;
        TextView gameDateView;
        TextView gameLocationView;
    }
}
