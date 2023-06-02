package com.example.wordsearchsolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView whoseSearch = (TextView)findViewById(R.id.ownerSearch);
        whoseSearch.setText(MainActivity.getUsername() + "'s Word Search!");
        TextView problemTV = (TextView)findViewById(R.id.wordSearchTA);
        ArrayList<String>  starterWSAnswers= new ArrayList<String>();
        starterWSAnswers.add("frost");
        starterWSAnswers.add("ice");
        starterWSAnswers.add("cold");
        starterWSAnswers.add("coat");
        starterWSAnswers.add("snow");
        starterWSAnswers.add("winter");
        starterWSAnswers.add("scarf");
        starterWSAnswers.add("igloo");

        //WordSearch starterWS = new WordSearch("csmfsnow.ocbrcsmh.aaqoobvk.treslfei.wfotdqsz.lwkyqice.vqwigloo.hwintern", starterWSAnswers);
        WordSearch starterWS = new WordSearch("csm.fds.dfn", starterWSAnswers);

        problemTV.setText(starterWS.toString());
       if(MainActivity2.getReturned())
       {
           problemTV.setText(MainActivity2.getWordSearch().toString());
       }

        Button customBTN = (Button) findViewById(R.id.custom);

        customBTN.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(intent);
            }
        });

    }
}