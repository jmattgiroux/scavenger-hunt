package com.example.scavengerhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PostGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_game);

        TextView finalScore = findViewById(R.id.finalScoreText);

        finalScore.setText("Final Score: " + Game.score);

        Button restart = findViewById(R.id.goBackToStart);

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //reset score for next game
                Game.score = 0;

                Intent intent = new Intent(PostGame.this, Home.class);
                startActivity(intent);

            }
        });


    }
}