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
import java.util.List;
import java.util.concurrent.ExecutionException;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String baseUrl = "https://swapi.dev/api/";
    String url;

    private EditText searchText;
    private String topic;

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

        //clear view before populating it
        removeView();

        try {
            result = getRequest.execute(request).get();
            Log.d("Value", "result = " + result);
        } catch (ExecutionException e) {
            e.printStackTrace();
            result = null;
        } catch (InterruptedException e) {
            e.printStackTrace();
            result = null;
        }

        Log.d("Value", "result = " + result);

        JSONObject jsonResult;
        if(result != null) {
            try {
                jsonResult = new JSONObject(result);
                for (String key : iterate(jsonResult.keys())) {
                    String data = jsonResult.getString(key);
                    inflateView(key, data, i);
                    i++;
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else{
            removeView();
            inflateError(search);
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
        //TODO: CHECK IF DATA HAS A LINK, IF IT DOES FOLLOW THE LINK FOR THE NAME OF THE PAGE
        data = cleanString(data);
        name = cleanString(name);
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

    public String cleanString(String clean){
        clean = clean.replaceAll("\\\\","");
        clean = clean.replaceAll("\"","");
        clean = clean.replaceAll("\\[", "");
        clean = clean.replaceAll("\\]", "");
        clean = clean.replaceAll("_", " ");
        return clean;
    }
    /* commented so it still works before full implementation
    private void initializeData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://swapi.dev/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService service = retrofit.create(ApiService.class);
        Call<List<Data>> call = service.getData(topic, search);

        //TODO: DO THE CALL STUFF
        call.enqueue(new Callback<List<Data>>(){

            @Override
            public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {

            }

            @Override
            public void onFailure(Call<List<Data>> call, Throwable t) {

            }
        });
    }
     */
}