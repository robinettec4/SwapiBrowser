package com.example.swapibrowser.adapters.min;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.api.ApiResponseListener;
import com.example.swapibrowser.generators.FilmGenerator;
import com.example.swapibrowser.holders.FilmHolder;
import com.example.swapibrowser.models.film.Film;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinFilmAdapter extends RecyclerView.Adapter<FilmHolder> {

    List<String> list = Collections.emptyList();
    Context context;
    ArrayList<Film> films = new ArrayList<>();
    FilmGenerator filmGenerator = new FilmGenerator();

    public MinFilmAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
        getFilms(list);
    }

    @NonNull
    @Override
    public FilmHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_field_layout_min, parent, false);
        return new FilmHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmHolder holder, int position) {
        if(!films.isEmpty()) {
            holder.filmName.setText(films.get(position).getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public void getFilms(List<String> list){

        ApiResponseListener<Film> filmListener = new ApiResponseListener<Film>() {
            @Override
            public void onResponseReceived(Film response) {
                films.add(response);
                notifyItemInserted(films.size() - 1);
            }
            @Override
            public void onError(Throwable error) {
                System.out.println(error.getMessage());
            }
        };

        for(String s: list){
            filmGenerator.getByFullUrl(s, filmListener);
        }
    }
}
