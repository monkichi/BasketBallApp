package com.example.christianzam.basketballleagueapp;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by christianzam on 12/25/2015.
 */
public class ScheduleListItem {
    String teamName1;
    String teamName2;
    String gameLocation;
    GregorianCalendar gameTime;


    public ScheduleListItem(String itemName, String itemAddress, String gameLoc, GregorianCalendar gameTime2) {
        super();
        teamName1 = itemName;
        teamName2 = itemAddress;
        gameLocation = gameLoc;
        gameTime = gameTime2;

    }

    public String getTeamName1() {
        return teamName1;
    }

    public void setTeamName1(String itemName) {teamName1 = itemName;}

    public String getTeamName2() {
        return teamName2;
    }

    public void setTeamName2(String itemAdd) {
        teamName2 = itemAdd;
    }

    public String getGameLocation() {
        return gameLocation;
    }

    public void setGameLocation(String itemAdd) {
        gameLocation = itemAdd;
    }

    public void setGameTime(GregorianCalendar time) {
        gameTime = time;
    }

    public GregorianCalendar getGameTime() {
        return gameTime;
    }


}
