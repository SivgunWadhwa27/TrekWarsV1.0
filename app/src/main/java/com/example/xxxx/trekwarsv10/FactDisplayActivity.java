package com.example.xxxx.trekwarsv10;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FactDisplayActivity extends AppCompatActivity {
    FactList list; //Declaring FactList object
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fact_display);
        Context context=this;
        //Declaring all the button handlers
        Button btnNext=(Button)findViewById(R.id.btnNext); //Button for going to next fact
        Button btnPrev=(Button)findViewById(R.id.btnPrev); //Button for going to next fact
        EditText fContTxt=(EditText)findViewById(R.id.multiLine); //Textfield to display the content of the fact
        TextView fIDTxt=(TextView) findViewById(R.id.textView3); //Textfield to display the factId
        TextView headingTxt=(TextView) findViewById(R.id.textView); ////Textfield to display either "Star Wars" or "Star Trek"
        fContTxt.setKeyListener(null); //Making multiLine textfield uneditable
        list=new FactList();
        //Getting extras from previous activity
        Bundle extras=getIntent().getExtras();
        /*
        Getting the string from previous activity- either "Star Wars" or "Star Trek"
         */
        String message=extras.getString("1");
        //If string is "Star Trek" then startrekfile.txt will be read from the SDCARD
        if(message.equals("Star Trek")){
            list.setFileToRead("startrekfile.txt");
        }
        //If string is "Star Wars" then starwarsfile.txt will be read from the SDCARD
        else if(message.equals("Star Wars")){
            list.setFileToRead("starwarsfile.txt");
        }
        //Setting the text field to either "Star Wars" or "Star Trek"
        headingTxt.setText(message);
        Fact fact; //Declaring fact object
        //Getting first fact from the ArrayList and storing it in a fact object
        fact=list.getFirstFact();
        //displaying factId and factContent to the text fields
        fIDTxt.setText(""+fact.getFactId()+" of 50");
        fContTxt.setText(fact.getFactContent());
        //Attaching the onClickListeners to the next and previous buttons
        btnNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onNextClick(v);
            }
        });
        btnPrev.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onPrevClick(v);
            }
        });
    }
    //This method gets the next fact from the arrayList and then displays it
    public void onNextClick(View v){
        EditText fContTxt = (EditText) findViewById(R.id.multiLine);
        fContTxt.setKeyListener(null);
        TextView fIDTxt = (TextView) findViewById(R.id.textView3);
        Fact fact; //Declaring fact object
        fact=list.getNextFact(); //Initializing the fact object to the next fact in the list
        if(fact!=null) {
            fIDTxt.setText("" + fact.getFactId() + " of 50");
            fContTxt.setText(fact.getFactContent());
        }
        else{ //When reaching the end of the arraylist
            list.setCurrIndex(list.getListSize());
            fContTxt.setText("You've reached the end of facts");
            fIDTxt.setText("End");
        }
    }
    //This method gets the previous fact from the arrayList and then displays it
    public void onPrevClick(View v){
        EditText fContTxt = (EditText) findViewById(R.id.multiLine);
        fContTxt.setKeyListener(null);
        TextView fIDTxt = (TextView) findViewById(R.id.textView3);
        Fact fact; //Declaring fact object
        fact=list.getPrevFact(); //Initializing the fact object to the next fact in the list
        if(fact!=null) {
            fIDTxt.setText("" + fact.getFactId() + " of 50");
            fContTxt.setText(fact.getFactContent());
        }
        else{ //When reaching the beginning of the arraylist
            list.setCurrIndex(-1);
            fContTxt.setText("You've reached the beginning of facts");
            fIDTxt.setText("Start");
        }
    }
}
