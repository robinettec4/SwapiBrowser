/*
    TODO:
        Retrofit Refactor - James
        Random Page Selection - Connor
        Favorite Page Option - James
        Follow Page Option (Push Notif on load) - Connor
        Recently Updated Pages - James
        Recently Created Pages - Connor
        Home Page - Connor, James, Noah
        Random Page Push Notif - Noah
*/

package com.example.swapibrowser.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.models.person.People;
import com.example.swapibrowser.models.person.Person;
import com.example.swapibrowser.searchers.PersonSearcher;
import com.example.swapibrowser.api.ApiResponseListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String topic;

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

        final EditText searchText = findViewById(R.id.searchNumber);

        final People people = new People();
        people.setPeople(new ArrayList<Person>());

        Button clickButton = findViewById(R.id.button);
        clickButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final ApiResponseListener<People> listener = new ApiResponseListener<People>() {

                    @Override
                    public void onResponseReceived(People response) {
                        people.getPeople().addAll(response.getPeople());
                        if(response.getNext() != null){
                            new PersonSearcher().getAllPeoplePageHelper(response.getNext().toString(), this);
                        } else {
                            System.out.println();
                        }
                    }

                    @Override
                    public void onError() {
                        System.out.println();
                    }
                };

                new PersonSearcher().getAllPeople(listener);
            }
        });
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
        topic = adapterView.getItemAtPosition(pos).toString();
        Log.d("topic", "topic = " + topic);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void inflateView(String name, String data, int index){
        LayoutInflater vi = getLayoutInflater();
        View v = vi.inflate(R.layout.field_list, null);
        TextView textView = (TextView) v.findViewById(R.id.text1);

        //TODO: CHECK IF DATA HAS A LINK, IF IT DOES FOLLOW THE LINK FOR THE NAME OF THE PAGE
//        data = cleanString(data);
//        name = cleanString(name);

        String text = name + ": " + data;
        textView.setText(text);
        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.insertPoint);
        insertPoint.addView(v, index);
    }

    public void inflateError(String string){
        LayoutInflater vi = getLayoutInflater();
        View v = vi.inflate(R.layout.field_list, null);
        TextView textView = v.findViewById(R.id.text1);
        String text = "Error, could not find a result for " + topic + " '" + string + "'";
        textView.setText(text);
        ViewGroup insertPoint = findViewById(R.id.insertPoint);
        insertPoint.addView(v, 0);
    }

    public void removeView(){
        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.insertPoint);
        insertPoint.removeAllViews();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}