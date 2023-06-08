package com.example.wordsearchsolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity
{

    private static String username;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //Creating variables
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText usernameTI = (EditText) findViewById(R.id.userNameLoginTI);
        Button loginBTN = (Button) findViewById(R.id.login);

        //Login Functionality
        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = String.valueOf(usernameTI.getText());
                if(username.equals("Du Best"))
                {
                    username = "Status: Creater... " + username;
                }
                else if(username.equalsIgnoreCase("vvhs"))
                {
                    username = "Status: Admin... " + username;
                }
                else username = "Status: User... " + username;

                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
            }//end of void
        });
    }//end of onCreate

    //Getter for the username to use it in the next screen
        public static String getUsername()
        {
            return username;
        }//end of getUsername
}//end of class