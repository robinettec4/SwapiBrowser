/*
NOTES FOR IMPLEMENTATION:

official documentation can be found at swapi.dev

request result comes in JSON format

probably will want a scrollview due to number of lines of data that can be received

may be a good idea to sanitize search input before sending the request


 */

package com.example.swapibrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.ExecutionException;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    //base url, append any query to this
    //will remove '/people/' from the end of the baseUrl to allow for searching of other categories as well
    String baseUrl = "https://swapi.dev/api/people/";
    //this will hold the full url after the query
    String url;

    //placeholder hardcoded query
    String place = "https://swapi.dev/api/people/1/";

    private TextView mTextView;
    private EditText mEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView);
        //change the edit text id to something more reasonable
        mEditText = findViewById(R.id.editTextTextPersonName);

    }

    public void searchResult(View view) {

        //the final result to be placed in the text view
        String result;

        String request;

        String search = mEditText.getText().toString();

        request = baseUrl + search + "/";
        Log.d("Value", "Search = " + request + "/");
        //create HttpGetRequest object
        HttpGetRequest getRequest = new HttpGetRequest();

        //send a request for url "place" and put result into "result"
        try {
            result = getRequest.execute(request).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
            result = null;
        } catch (InterruptedException e) {
            e.printStackTrace();
            result = null;
        }

        Log.d("Value", "result = " + result);

        //display result in textView
        mTextView.setText(result);
    }
}