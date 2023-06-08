package com.example.wordsearchsolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


//note: due to the order the classes were created in, this is the "3rd" screen with an id of 2.
public class MainActivity2 extends AppCompatActivity
{
    private static ArrayList<String> tempAnswers = new ArrayList<String>();
    private static String tempProblem = "";
    private static WordSearch customWS = new WordSearch();
    private static boolean returned = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EditText wordSearechForCustomTI = (EditText) findViewById(R.id.wordSearchTI);
        EditText answerWordsForCustomTI = (EditText) findViewById(R.id.answerWordsTI);
        Button returnFromCustomBTN = (Button) findViewById(R.id.returnFromCustom);
        Button submitLettersBTN = (Button)findViewById(R.id.submitLetters);
        Button submitAnswersBTN = (Button)findViewById(R.id.submitAnswers);

        //Adds the letters to a wordsearch string
        submitLettersBTN.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                tempProblem+=String.valueOf(wordSearechForCustomTI.getText());
                wordSearechForCustomTI.setText("");
            }//end of void
        });

        //Adds the words to a answer ArrayList
        submitAnswersBTN.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                tempAnswers.add(String.valueOf(answerWordsForCustomTI.getText()));
                answerWordsForCustomTI.setText("");
            }
        });

        //Returns from the screen
        returnFromCustomBTN.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                customWS = new WordSearch(tempProblem, tempAnswers);
                returned = true;
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }//end of void
        });


    }

    //Gets the word search for the next screen
    public static WordSearch getWordSearch()
    {
        return customWS;
    }//end of getter

    //Is used to check if this screen has been used
    public static boolean getReturned()
    {
        return returned;
    }//end of getter
}//end of class