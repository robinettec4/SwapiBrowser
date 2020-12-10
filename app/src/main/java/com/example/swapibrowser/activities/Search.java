package com.example.swapibrowser.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;

public class Search extends AppCompatActivity {

    RecyclerView searchRecycler;
    EditText inputText;
    private String field;
    private String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchRecycler = findViewById(R.id.search_recycler);
        inputText = findViewById(R.id.input);

        final Spinner searchSpinner = findViewById(R.id.search_spinner);
        searchSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                field = searchSpinner.getSelectedItem().toString().toLowerCase();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void search(View view){
        input = inputText.getText().toString().toLowerCase();
        switch (field){
            case "Person":
                break;
            case "Film":
                break;
            case "Starship":
                break;
            case "Vehicle":
                break;
            case "Species":
                break;
            case "Planet":
                break;
            default:
                break;
        }
    }
}
