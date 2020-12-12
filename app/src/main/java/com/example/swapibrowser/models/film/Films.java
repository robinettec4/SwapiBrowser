package com.example.swapibrowser.models.film;

import java.util.List;

import com.example.swapibrowser.models.IModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Films implements IModel<Film> {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("next")
    @Expose
    private Object next;
    @SerializedName("previous")
    @Expose
    private Object previous;
    @SerializedName("results")
    @Expose
    private List<Film> films = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Object getNext() {
        return next;
    }

    public void setNext(Object next) {
        this.next = next;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public List<Film> getResults() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

}
