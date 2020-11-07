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

import android.util.Log;
import java.util.concurrent.ExecutionException;

import android.view.View;
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

    private TextView name;
    private TextView height;
    private TextView mass;
    private TextView hairColor;
    private TextView skinColor;
    private TextView eyeColor;
    private TextView birthYear;
    private TextView gender;
    private TextView homeworld;
    private EditText searchText;
    private String topic = "films";
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        if (spinner != null){
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.topicArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if(spinner != null){
            spinner.setAdapter(adapter);
        }
        //TODO: PROGRAMATICALLY DETERMINE THE JSON HEADERS AND POPULATE THEM BASED ON THE FIELDS OF EACH TOPIC
        name = findViewById(R.id.name);
        height = findViewById(R.id.height);
        mass = findViewById(R.id.mass);
        hairColor = findViewById(R.id.hairColor);
        skinColor = findViewById(R.id.skinColor);
        eyeColor = findViewById(R.id.eyeColor);
        birthYear = findViewById(R.id.birthYear);
        gender = findViewById(R.id.gender);
        homeworld = findViewById(R.id.homeworld);
        searchText = findViewById(R.id.searchNumber);
    }

    public void searchResult(View view) {
        String result;
        String request;
        String search = searchText.getText().toString();

        request = baseUrl + topic + "/" + search + "/";
        Log.d("Value", "Search = " + request + "/");
        HttpGetRequest getRequest = new HttpGetRequest();

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
            name.setText(jsonResult.getString("name"));
            height.setText(jsonResult.getString("height"));
            mass.setText(jsonResult.getString("mass"));
            hairColor.setText(jsonResult.getString("hair_color"));
            skinColor.setText(jsonResult.getString("skin_color"));
            eyeColor.setText(jsonResult.getString("eye_color"));
            birthYear.setText(jsonResult.getString("birth_year"));
            gender.setText(jsonResult.getString("gender"));
            homeworld.setText(jsonResult.getString("homeworld"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    //change topic based on the selected drop down option
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id){
        String spinnerLabel = adapterView.getItemAtPosition(pos).toString();
        topic = spinnerLabel;
        Log.d("topic", "topic = " + topic);
        displayToast(spinnerLabel);
    }
    public void onNothingSelected(AdapterView<?> adapterView){

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}