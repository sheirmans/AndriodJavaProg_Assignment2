/*
 * CSE41246 - Android Java Fundamentals
 * Fall 2019
 * Assignment #2
 * Szeto, Sheirman
 */

package com.example.assignment2_sheirmanszeto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int minimum = 1;
    private int maximum = 6;

    //widgets
    private TextView resultTextView = null;
    private EditText minEditText = null;
    private EditText maxEditText = null;
    private Button generateButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    // Initialize widgets.
        this.resultTextView = (TextView) findViewById(R.id.editResult);
        this.minEditText = (EditText) findViewById(R.id.editMinimum);
        this.maxEditText = (EditText) findViewById(R.id.editMaximum);

     //generate random number
        this.generateButton = (Button)findViewById(R.id.buttonGenerate);
        this.generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchValuesFromFields();    // Fetch the field values first.
                generateRandomNumber();     // Generate and display random number.
            }
        });
   }

    private void fetchValuesFromFields() {
        // Fetches the values set in the min and max text field. Save to class variables.
        // Convert fetched strings to ints.
        this.minimum =  Integer.parseInt(this.minEditText.getText().toString());
        this.maximum =  Integer.parseInt(this.maxEditText.getText().toString());
    }

    private void generateRandomNumber() {
        //generate random number
        int randomNum = getRandomInt(minimum, maximum); // Get a random int from bounds.
        String randomNumStr = Integer.toString(randomNum);  // Convert number from int to String.

        resultTextView.setText(randomNumStr);               // Set the result text field.
    }

    private int getRandomInt(int min, int max) {
        // Generate a random number between min and max.
        Random rand = new Random();
        return rand.nextInt(max) + min;
    }

}
