package com.example.swapibrowser.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.activities.factory.ActivityFactory;
import com.example.swapibrowser.holders.PersonHolder;
import com.example.swapibrowser.models.ISingleModel;
import com.example.swapibrowser.models.person.Person;

import java.util.Collections;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonHolder> {

    List<ISingleModel> list = Collections.emptyList();
    Context context;

    public PersonAdapter(List<ISingleModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public PersonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_recycler_layout, parent, false);
        return new PersonHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonHolder holder, int position) {
        final ActivityFactory activityFactory = new ActivityFactory();
        final Person person = (Person) list.get(position);
        holder.personCardName.setText(context.getString(R.string.name, person.getName()));

        holder.personCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, activityFactory.CreateActivity("people"));
                intent.putExtra("people", person);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
