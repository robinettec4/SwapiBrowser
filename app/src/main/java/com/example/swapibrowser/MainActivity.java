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
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    //base url, append any query to this
    String baseUrl = "https://swapi.dev/api/";
    //this will hold the full url after the query
    String url;

    //placeholder hardcoded query
    String place = "https://swapi.dev/api/people/1/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.textView);

        //the final result to be placed in the text view
        String result;

        //create HttpGetRequest object
        HttpGetRequest getRequest = new HttpGetRequest();

        //send a request for url "place" and put result into "result"
        try {
            result = getRequest.execute(place).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
            result = null;
        } catch (InterruptedException e) {
            e.printStackTrace();
            result = null;
        }

        Log.d("Value", "result = " + result);

        //display result in textView
        textView.setText(result);
    }
}