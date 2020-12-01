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


        school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //https://www.geeksforgeeks.org/android-creating-multiple-screen-app/
                Intent intent = new Intent(ScenarioSelection.this, Game.class);

                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //https://www.geeksforgeeks.org/android-creating-multiple-screen-app/
                Intent intent = new Intent(ScenarioSelection.this, Game.class);

                startActivity(intent);
            }
        });

        outside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //https://www.geeksforgeeks.org/android-creating-multiple-screen-app/
                Intent intent = new Intent(ScenarioSelection.this, Game.class);

                startActivity(intent);
            }
        });

    }


}