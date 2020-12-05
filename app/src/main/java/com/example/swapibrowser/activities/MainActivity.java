package com.example.swapibrowser.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.swapibrowser.R;
import com.example.swapibrowser.models.person.People;
import com.example.swapibrowser.models.person.Person;
import com.example.swapibrowser.searchers.PersonSearcher;
import com.example.swapibrowser.api.ApiResponseListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final People people = new People();
        people.setPeople(new ArrayList<Person>());

        final PersonSearcher personSearcher = new PersonSearcher();
        final ApiResponseListener<People> listener = new ApiResponseListener<People>() {

            @Override
            public void onResponseReceived(People response) {
                people.getPeople().addAll(response.getPeople());
                if(response.getNext() != null){
                    personSearcher.getAllPeopleByPageHelper(response.getNext().toString(), this);
                } else {
                    doSomethingExample(people);
                }
            }

            @Override
            public void onError(Throwable error) {
                System.out.println(error.getMessage());
            }
        };
        personSearcher.getAllPeople(listener);
    }

    public void doSomethingExample(People o){
        System.out.println(o.getPeople());
    }
}