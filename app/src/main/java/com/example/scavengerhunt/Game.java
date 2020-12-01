package com.example.scavengerhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import android.content.res.AssetManager;

/*
Resources:
https://developer.android.com/reference/android/app/Activity

 */




public class Game extends AppCompatActivity {


    //Because we need to count the number of words (elements) we have remaining,
    //as well as remove words (elements) on the fly, we're using an ArrayList
    //https://www.geeksforgeeks.org/java-util-vector-class-java/
    //https://developer.android.com/reference/java/util/ArrayList

    //Variables for this class

    public ArrayList<String> words = new ArrayList<String>();
    int oldNumber = 0;
    int newNumber = 0;

    //I need to explain why the variables below are declared here and
    // instantiated within onCreate - Jared
    AssetManager assetManager;
    InputStream inputStream;


    //variable controlling which list we're working with.
    public static String choice = "school.txt";

    public static int score = 0;

    public static String previousWord = " ";

    //issue: if txt file chosen is empty, app crashes.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        //populate words ArrayList
        assetManager = getAssets();
        try {
            inputStream = assetManager.open(choice);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            readTextFile(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }





        TextView word = (TextView) findViewById(R.id.textView);
        Button newWordButton = findViewById(R.id.newWordButton);
        Button finish = findViewById(R.id.finishButton);

        Button goBack = findViewById(R.id.goBackToScenarioSelectButton);
        Button pass = findViewById(R.id.passButton);

        updateWord(word);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Game.this, PostGame.class);
                startActivity(intent);
            }
        });

        newWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateWord(word);
                incrementScore();
                //https://developer.android.com/reference/java/util/ArrayList


            }
        });

        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateWord(word);
            }
        });


        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //https://www.geeksforgeeks.org/android-creating-multiple-screen-app/
                Intent intent = new Intent(Game.this, ScenarioSelection.class);

                startActivity(intent);
            }
        });


    }

    public void updateWord(TextView word){
        newNumber = getRandomNumber(words.size());
        word.setText(words.get(newNumber));

        //variable to temporarily hold value of the new word,
        //since we're getting rid of the previous word and then
        //updating what the previous word is.
        //This is to prevent issues with getting the wrong index, since if we
        //just do previousWord = words.get(newNumber) after removing an element,
        //newNumber's spot in the index will probably be a new word at that point.
        String string = words.get(newNumber);
        words.remove(previousWord);
        previousWord = string;

        //if we run out of words, we reload the text file into our words ArrayList
        //Issue: something goes wonky when we go past 100; works fine before then.
        //Issue: occasional repeats 2x in a row, like: 46, scissors, 47, scissors,
        // aside from those repeats that happen only 2x in a row, not sure if other repeats
        // happen.
        if (words.size() < 2)
        {
            try {
                readTextFile(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    static int getRandomNumber(int range){

        //issue: when range is 0, there's an ArithmeticException for dividing by 0

        //generate a random number that's cast to an int
        //https://www.educative.io/edpresso/how-to-generate-random-numbers-in-java
        //https://www.w3schools.com/java/java_math.asp
        int randomNumber = (int)(Math.random() * 1000);

        //reduce random number to within range of number of words using a modulo
        randomNumber %= range;

        return randomNumber;
    }


    //Referenced this source:
    //https://www.tutorialspoint.com/how-to-read-a-simple-text-file-in-android-app
    //https://stackoverflow.com/questions/40729977/unable-to-access-text-file-in-asset-folder
    public void readTextFile(InputStream is) throws IOException {



        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = bufferedReader.readLine()) != null)
        {
            words.add(line);
        }
        bufferedReader.close();

        return;
    }

    public void incrementScore(){
        score++;
        TextView scoreText = findViewById(R.id.scoreTextView);
        scoreText.setText("Score: " + score);
    }



}