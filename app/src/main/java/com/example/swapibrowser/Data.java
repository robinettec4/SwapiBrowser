package com.example.swapibrowser;

import java.util.ArrayList;

public class Data {
    private int count;
    private String next;
    private String previous;
    private ArrayList<Results> results;
    //rest of the KEYS

    public Data(){
    }

    public String getId(){ return String.valueOf(count); }
    public String getNext(){ return next; }
    public String getPrevious(){ return previous; }
    public ArrayList<Results> getResults(){ return results; }
    //rest of the getters for the keys
}
