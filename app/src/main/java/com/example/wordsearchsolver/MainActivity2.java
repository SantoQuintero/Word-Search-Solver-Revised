//background
//https://www.google.com/url?sa=i&url=https%3A%2F%2Fpxhere.com%2Fen%2Fphoto%2F1443671&psig=AOvVaw3p6-ozPo4xDYRJOo2h4xVp&ust=1686288486848000&source=images&cd=vfe&ved=0CA0QjRxqFwoTCPD27uD4sv8CFQAAAAAdAAAAABAD


package com.example.wordsearchsolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    static ArrayList<String> tempAnswers = new ArrayList<String>();
    static String tempProblem = "";
    static WordSearch customWS = new WordSearch();
    int count =0;
    private static boolean returned = false;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EditText wordSearechForCustomTI = (EditText) findViewById(R.id.wordSearchTI);
        EditText answerWordsForCustomTI = (EditText) findViewById(R.id.answerWordsTI);
        Button returnFromCustomBTN = (Button) findViewById(R.id.returnFromCustom);
        Button submitLettersBTN = (Button)findViewById(R.id.submitLetters);
        Button submitAnswersBTN = (Button)findViewById(R.id.submitAnswers);



        submitLettersBTN.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                tempProblem+=String.valueOf(wordSearechForCustomTI.getText());
                wordSearechForCustomTI.setText("");
            }

            //
            //keeeeeeeeeeeeep

            // 163 CB with recusion and ap = 2x
            //0-9 = 1| 10 -24 = 2|25+ = 3
            //
            //keeeeeeeeeeeeeeeep
        });
        returnFromCustomBTN.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                customWS = new WordSearch(tempProblem, tempAnswers);
                returned = true;
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });
        submitAnswersBTN.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                tempAnswers.add(String.valueOf(answerWordsForCustomTI.getText()));
                answerWordsForCustomTI.setText("");
            }
        });
    }

    public static WordSearch getWordSearch()
    {
        return customWS;
    }
    public static boolean getReturned(){return returned;}
}




//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        EditText usernameTI = (EditText) findViewById(R.id.userNameLoginTI);
//
//        Button loginBTN = (Button) findViewById(R.id.login);
//        loginBTN.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                username = String.valueOf(usernameTI.getText());
//                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
//                startActivity(intent);
//            }
//        });
//    }
//    String username;
//
//    private void store(String name)
//    {
//        username = name;
//    }
