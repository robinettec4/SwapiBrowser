package com.example.swapibrowser.adapters.min;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.api.ApiResponseListener;
import com.example.swapibrowser.generators.PersonGenerator;
import com.example.swapibrowser.holders.PersonHolder;
import com.example.swapibrowser.models.person.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinPersonAdapter extends RecyclerView.Adapter<PersonHolder>{
    List<String> list = Collections.emptyList();
    Context context;
    PersonGenerator personGenerator = new PersonGenerator();
    ArrayList<Person> persons = new ArrayList<>();

    public MinPersonAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
        getPersons(list);
    }

    @NonNull
    @Override
    public PersonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_field_layout_min, parent, false);
        return new PersonHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonHolder holder, int position) {
        if(!persons.isEmpty()) {
            holder.personNameMin.setText(persons.get(position).getName());
        }
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public void getPersons(List<String> list){

        ApiResponseListener<Person> personListener = new ApiResponseListener<Person>() {
            @Override
            public void onResponseReceived(Person response) {
                persons.add(response);
                notifyItemInserted(persons.size() - 1);
            }
            @Override
            public void onError(Throwable error) {
                System.out.println(error.getMessage());
            }
        };

        for(String s: list) {
            personGenerator.getByFullUrl(s, personListener);
        }
    }
}
