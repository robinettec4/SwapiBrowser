/*
NOTES FOR IMPLEMENTATION:

official documentation can be found at swapi.dev

request result comes in JSON format

probably will want a scrollview due to number of lines of data that can be received

may be a good idea to sanitize search input before sending the request


 */

package com.example.swapibrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import android.util.Log;

import java.util.Iterator;
import java.util.concurrent.ExecutionException;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String baseUrl = "https://swapi.dev/api/";
    String url;

    private EditText searchText;
    private String topic = "films";

    //use iterator to determine fields
    private <T> Iterable<T> iterate(final Iterator<T> i) {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return i;
            }
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.topicArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

        searchText = findViewById(R.id.searchNumber);
    }

    public void searchResult(View view) {
        String result;
        String request;
        String search = searchText.getText().toString();
        int i = 0;

        request = baseUrl + topic + "/" + search + "/";
        Log.d("Value", "Search = " + request);
        HttpGetRequest getRequest = new HttpGetRequest();

        //TODO: THIS DOESN'T WORK
        //IT SHOULD CLEAR THE VIEW BEFORE POPULATING IT WITH INFORMATION SO AS TO CLEAR PREVIOUS INFORMATION
        removeView();

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

        JSONObject jsonResult;
        try {
            jsonResult = new JSONObject(result);
            //TODO: PUSHES PREVIOUS LINES DOWN THE SCREEN EACH TIME IT WRITES NEW DATA, LEAVES IMPORTANT DATA AT THE BOTTOM. NEED TO REVERSE THIS
            for (String key : iterate(jsonResult.keys())) {
                String data = jsonResult.getString(key);
                inflateView(key, data, i);
                i++;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //change topic based on the selected drop down option
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
        String spinnerLabel = adapterView.getItemAtPosition(pos).toString();
        topic = spinnerLabel;
        Log.d("topic", "topic = " + topic);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void inflateView(String name, String data, int index){
        LayoutInflater vi = getLayoutInflater();
        View v = vi.inflate(R.layout.field_list, null);
        TextView textView = (TextView) v.findViewById(R.id.text1);
        //TODO: parse the links within the data to not show up really weird at least. maybe cut out the link and just leave the number at the end? idk
        String text = name + ": " + data;
        textView.setText(text);
        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.insertPoint);
        insertPoint.addView(v, index);
    }

    public void removeView(){
        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.insertPoint);
        insertPoint.removeView(insertPoint);

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}