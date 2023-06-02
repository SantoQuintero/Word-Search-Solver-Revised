package com.example.wordsearchsolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private static String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText usernameTI = (EditText) findViewById(R.id.userNameLoginTI);

        Button loginBTN = (Button) findViewById(R.id.login);
        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = String.valueOf(usernameTI.getText());
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
            }
        });
    }
//
        public static String getUsername()
        {
            return username;
        }











       // configureButton();


    }
//
//    private void configureButton()
//    {
//        Button firstButton = (Button)findViewById(R.id.button);
//        firstButton.setOnClickListener(new View.OnClickListener())
//    {
//        @Override
//        public void onClick(View v)
//        {
//                finish();
//        }
//    });
//    }