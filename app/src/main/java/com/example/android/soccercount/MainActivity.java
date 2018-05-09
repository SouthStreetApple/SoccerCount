package com.example.android.soccercount;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * Variables for the team scores and fouls.
     */
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int foulTeamA = 0;
    int foulTeamB = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Code that adds goals for Team A.
     */
    public void addOneForTeamA(View view) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
        calculateRelative();
    }


    /**
     * Code that adds goals for Team B.
     */
    public void addOneForTeamB(View view) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
        calculateRelative();
    }

    /**
     * This code resets all the variables and views to ZERO.
     */
    public void resetTeams(View view) {
        scoreTeamA = getResources().getInteger(R.integer.goal_view_a);
        scoreTeamB = getResources().getInteger(R.integer.goal_view_b);
        foulTeamA = getResources().getInteger(R.integer.foul_view_a);
        foulTeamB = getResources().getInteger(R.integer.foul_view_b);
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayDiffTeamA(getResources().getInteger(R.integer.difference_view_a));
        displayDiffTeamB(getResources().getInteger(R.integer.difference_view_b));
        displayFoulTeamA(foulTeamA);
        displayFoulTeamB(foulTeamB);
    }

    /**
     * Code that calculates the +/- of the teams position relative to the
     * other teams score (the difference between scores).
     * Also displays this on the appropriate views.
     */
    private void calculateRelative() {
        int teamADifference;
        int teamBDifference;
        teamADifference = scoreTeamA - scoreTeamB;
        teamBDifference = scoreTeamB - scoreTeamA;
        //Display these differences...
        displayDiffTeamA(teamADifference);
        displayDiffTeamB(teamBDifference);
    }

    /**
     * Displays the Difference (or how much a team is ahead or behind,
     * for Team A
     */
    public void displayDiffTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_diff);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the Difference (or how much a team is ahead or behind,
     * for Team A
     */
    public void displayDiffTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_diff);
        scoreView.setText(String.valueOf(score));
    }


    /**
     * Add Foul for Team A
     */
    public void addOneFoulTeamA(View view) {
        foulTeamA = foulTeamA + 1;
        displayFoulTeamA(foulTeamA);
    }

    /**
     * Add Foul for Team B
     */
    public void addOneFoulTeamB(View view) {
        foulTeamB = foulTeamB + 1;
        displayFoulTeamB(foulTeamB);
    }

    /**
     * Display Foul for Team A
     */
    public void displayFoulTeamA(int foul) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_foul);
        scoreView.setText(String.valueOf(foul));
    }

    /**
     * Display Foul for Team B
     */
    public void displayFoulTeamB(int foul) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_foul);
        scoreView.setText(String.valueOf(foul));
    }
}
