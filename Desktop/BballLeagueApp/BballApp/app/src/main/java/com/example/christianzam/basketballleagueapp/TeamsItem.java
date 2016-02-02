package com.example.christianzam.basketballleagueapp;

import java.util.Date;

/**
 * Created by christianzam on 12/23/2015.
 */
public class TeamsItem {
    String teamName;
    String captainName;
    String teamDivision;
    String teamLeague;
    int teamWins;
    int teamLosses;
    int teamID;


    public TeamsItem(String teamName1,
                     String captainName1,
                     String teamDivision1, String teamLeague1,
                     int teamWins1,
                     int teamLosses1,
                     int teamID1) {
        super();
        teamName = teamName1;
        captainName = captainName1;
        teamDivision = teamDivision1;
        teamWins = teamWins1;
        teamLosses = teamLosses1;
        teamID = teamID1;
        teamLeague = teamLeague1;

    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String name) {
        teamName = name;
    }

    public String getTeamLeague() {
        return teamLeague;
    }

    public void setTeamLeague(String league) {
        teamLeague = league;
    }

    public String getTeamDivision() {
        return teamDivision;
    }

    public void setTeamDivision(String name) {
        teamDivision = name;
    }

    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String name) {
        captainName = name;
    }

    public int getTeamWins() {
        return teamWins;
    }

    public void setTeamWins(int wins) {
        teamWins = wins;
    }

    public int getTeamLosses() {
        return teamLosses;
    }

    public void setTeamLosses(int num) {
        teamLosses = num;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int num1) {
        teamID = num1;
    }


}
