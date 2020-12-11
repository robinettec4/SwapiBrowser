package com.example.swapibrowser.models.person;

import java.util.List;

import com.example.swapibrowser.models.IModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class People implements IModel<Person> {

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
    private List<Person> people = null;

    public Integer getCount() { return count; }

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

    public List<Person> getResults() {
        return people;
    }

    public void setResults(List<Person> people) {
        this.people = people;
    }

}
