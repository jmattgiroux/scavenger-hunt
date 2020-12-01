package com.example.scavengerhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class ScenarioSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scenario_selection);


        Button school = findViewById(R.id.schoolButton);
        Button home = findViewById(R.id.homeButton);
        Button outside = findViewById(R.id.outsideButton);
        Button back = findViewById(R.id.goBackHomeButton);


        school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //https://stackoverflow.com/questions/12288629/how-do-i-get-a-variable-in-another-activity
                // Game.choice is a public static variable, hence we can change it from here.
                Game.choice = "school.txt";
                //https://www.geeksforgeeks.org/android-creating-multiple-screen-app/
                Intent intent = new Intent(ScenarioSelection.this, Game.class);

                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Game.choice = "home.txt";
                //https://www.geeksforgeeks.org/android-creating-multiple-screen-app/
                Intent intent = new Intent(ScenarioSelection.this, Game.class);

                startActivity(intent);
            }
        });

        outside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //https://www.geeksforgeeks.org/android-creating-multiple-screen-app/

                Game.choice = "outside.txt";
                Intent intent = new Intent(ScenarioSelection.this, Game.class);

                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //https://www.geeksforgeeks.org/android-creating-multiple-screen-app/

                Game.choice = "outside.txt";
                Intent intent = new Intent(ScenarioSelection.this, Home.class);

                startActivity(intent);
            }
        });

    }


}