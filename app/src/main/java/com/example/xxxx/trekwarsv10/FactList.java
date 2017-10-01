package com.example.xxxx.trekwarsv10;


import android.os.Environment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class FactList {
    private String fileToRead; //Stores the name of file to be read
    private int currIndex; //Stores current index of the arrayList object
    //Constructor for FactList
    public FactList(){
        currIndex=0;
    }
    private  ArrayList<Fact> listOfFacts=new ArrayList<Fact>(); //Field to store ArrayList of Fact objects
    //Method to return the first fact object from the list
    public Fact getFirstFact(){
        //Filling listOfFacts with all the Fact objects
        readFromFile();
        return listOfFacts.get(currIndex); //Returning the first element of the ArrayList
    }
    /*
    This method reads the file from the SD Card and fills the listOfFacts with the Fact objects
    */
    public void readFromFile() {
        String[] arr=new String[10000]; //Declaring the string array
        StringBuilder text=new StringBuilder(); //Declaring a StringBuilder object

        try{
            File sdcard=Environment.getExternalStorageDirectory(); //Getting the path of SD Card
            File file=new File(sdcard,getFileToRead()); //Getting the exact file to read("starwarsfile.txt" or "startrekfile.txt")
            BufferedReader reader = new BufferedReader(new FileReader(file)); //Declaring a BufferedReader object
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line); //Appending the line read from the file to the StringBuilder object
                text.append(':');  //Adding ":" character at the end
                arr=text.toString().split(":"); //Splitting the line into two fields seperated by ":" and storing in the array
            }
            /*
            Loop to create a Fact object using the two elements from the array and then adding the object to the arraylist
             */
            for(int i=0;i<=arr.length;i+=2) {
                Fact fact = new Fact(); //Declaring the Fact object
                fact.setFactId(Integer.parseInt(arr[i])); //Setting the factId
                fact.setFactContent(arr[i + 1]); //Setting the factContent
                listOfFacts.add(fact); //Adding the Fact object to the arraylist
                if (i == arr.length - 2) {
                    break;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    /*Method to get the next element in the arraylist(Fact object) relative to the current element
    As long as the next element is within the maximum size of the array, the element will be returned
    If not, then null will be returned
     */
    public Fact getNextFact(){
        currIndex++;
        if(currIndex<listOfFacts.size()) {
            return listOfFacts.get(currIndex);
        }
        else{
            currIndex--;
            return null;
        }
    }
    /*Method to get the previous element in the arraylist(Fact object) relative to the current element
    As long as the index of previous element is more than or equal to zero, the element will be printed
    If not, then null will be returned
     */
    public Fact getPrevFact(){
        currIndex--;
        if(currIndex>=0) {
            return listOfFacts.get(currIndex);
        }
        else{
            currIndex++;
            return null;
        }
    }
    //Method to set the file to be read, either starwarsfile.txt or startrekfile.txt
    public void setFileToRead(String f){
        fileToRead=f;
    }
    //Method to get the file to be read, either starwarsfile.txt or startrekfile.txt
    public String getFileToRead(){
        return fileToRead;
    }
    //Method to set the current index of the arraylist object
    public void setCurrIndex(int index){
        currIndex=index;
    }
    //Method to return the size of the arraylist
    public int getListSize(){
        return listOfFacts.size();
    }
}
