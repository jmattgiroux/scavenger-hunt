package com.example.scavengerhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import android.content.res.AssetManager;

/*
Resources:
https://developer.android.com/reference/android/app/Activity

 */




public class MainActivity extends AppCompatActivity {


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




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //populate words ArrayList
        //need to replace with words from file
        assetManager = getAssets();
        try {
            inputStream = assetManager.open("test.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            readTextFile(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }


        /*
        for (int i = 0; i < 5; i++)
        {
            words.add(" " + i);
        }

         */


        TextView word = (TextView) findViewById(R.id.textView);
        Button newWordButton = findViewById(R.id.newWordButton);


        newWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateWord(word);
            }
        });


    }

    public void updateWord(TextView word){
        newNumber = getRandomNumber(words.size());
        word.setText(words.get(newNumber));
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

}