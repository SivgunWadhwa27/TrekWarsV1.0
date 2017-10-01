package com.example.xxxx.trekwarsv10;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;



public class Fact {
    private int factId; //Field to store the ID number of the fact
    private String factContent; //Field to store the entire content of the fact
    //Setters for factId and factContent
    public void setFactId(int id){
        factId=id;
    }

    public void setFactContent(String cont){
        factContent=cont;
    }
    //Getters for factId and factContent
    public int getFactId(){
        return factId;
    }
    public String getFactContent(){
        return factContent;
    }
}
