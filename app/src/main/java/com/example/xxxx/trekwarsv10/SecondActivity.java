package com.example.xxxx.trekwarsv10;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Context cont = this;
        //Declaring the button handlers
        Button btnTrek = (Button) findViewById(R.id.btnTrek);
        Button btnStar = (Button) findViewById(R.id.btnStar);
        //Attaching the button handlers to onClickListeners
        btnTrek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTrekClick(v);
            }
        });
        btnStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStarClick(v);
            }
        });
    }

    //Method to handle the click of btnTrek
    public void onTrekClick(View view) {
        //Declaring intent object to take us to FactDisplayActivity
        Intent in = new Intent(view.getContext(), FactDisplayActivity.class);
        String str = "Star Trek";
        //Putting message with the intent
        in.putExtra("1", str);
        //Starting the activity
        startActivity(in);
    }

    //Method to handle the click of btnStar
    public void onStarClick(View view) {
        //Declaring intent object to take us to FactDisplayActivity
        Intent in = new Intent(view.getContext(), FactDisplayActivity.class);
        String str = "Star Wars";
        //Putting message with the intent
        in.putExtra("1", str);
        //Starting the activity
        startActivity(in);
    }
}
