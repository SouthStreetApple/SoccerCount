package com.example.android.soccercount;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*
    int threePoint = 3;
    int twoPoint = 2;
    int freeThrow = 1;
    int totalShots = 0;
    int fouls = 0;
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

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     *
     * Code that adds goals or fouls when buttons are pressed.
     */
    public void addOneForTeamA(View view) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
        calculateRelative();
    }



    public void addOneForTeamB(View view) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
        calculateRelative();
    }

    public void resetTeams(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        foulTeamA = 0;
        foulTeamB =0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayDiffTeamA(0);
        displayDiffTeamB(0);
        displayFoulTeamA(foulTeamA);
        displayFoulTeamB(foulTeamB);
    }

    /**
     * Code that calculates the +/- of the teams position relative to the other teams score.
     */
    private void calculateRelative(){
        int teamADifference;
        int teamBDifference;
        teamADifference = scoreTeamA-scoreTeamB;
        teamBDifference = scoreTeamB-scoreTeamA;
        //Display these differences...
        displayDiffTeamA(teamADifference);
        displayDiffTeamB(teamBDifference);
    }
    public void displayDiffTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_diff);
        scoreView.setText(String.valueOf(score));
    }
    public void displayDiffTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_diff);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Calculate fouls
     */
    public void addOneFoulTeamA(View view) {
        foulTeamA = foulTeamA + 1;
        displayFoulTeamA(foulTeamA);
    }
    public void addOneFoulTeamB(View view) {
        foulTeamB = foulTeamB + 1;
        displayFoulTeamB(foulTeamB);
    }
    public void displayFoulTeamA(int foul) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_foul);
        scoreView.setText(String.valueOf(foul));
    }

    public void displayFoulTeamB(int foul) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_foul);
        scoreView.setText(String.valueOf(foul));
    }
}
