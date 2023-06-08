package com.example.wordsearchsolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

//note: due to the order the classes were created in, this is the "2nd" screen with an id of 3.
public class MainActivity3 extends AppCompatActivity
{

    private static WordSearch temp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //Creating variables for screen "2", along with the default word search
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Button customBTN = (Button) findViewById(R.id.custom);
        Button solveBTN = (Button) findViewById(R.id.solve);
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
        WordSearch starterWS = new WordSearch("csmfsnow.ocbrcsmh.aaqoobvk.treslfei.wfotdqsz.lwkyqice.vqwigloo.hwintern", starterWSAnswers);
        //WordSearch temp = new WordSearch();
        //temp = starterWS;

        //WordSearch starterWS = new WordSearch("csm.fds.dfn", starterWSAnswers);
//        problemTV.setText(temp.toString());
        problemTV.setText(starterWS.toString());

        //Checks to see if returning from a custom search
        if(MainActivity2.getReturned())
        {
            temp = MainActivity2.getWordSearch();
//            temp.solve();
            problemTV.setText(temp.toString());
        }


        //Going to the custom screen
        customBTN.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(intent);
            }//end of void
        });

        //Going to solve
        solveBTN.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(!MainActivity2.getReturned())
                {
                    starterWS.solve();;
                    problemTV.setText(starterWS.toString());
                }
                else
                {
                    temp.solve();
                    problemTV.setText(temp.toString());
                }
//                temp = MainActivity2.getWordSearch();
//                temp.solve();

            }//end of void
        });
    }//end of onCreate
}//end of class