package com.example.swapibrowser.models.species;

import java.io.Serializable;
import java.util.List;

import com.example.swapibrowser.models.IModel;
import com.example.swapibrowser.models.ISingleModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Species implements IModel<SpeciesResult> {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("next")
    @Expose
    private String next;
    @SerializedName("previous")
    @Expose
    private Object previous;
    @SerializedName("results")
    @Expose
    private List<SpeciesResult> speciesResults = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public List<SpeciesResult> getResults() {
        return speciesResults;
    }

    public void setSpeciesResults(List<SpeciesResult> speciesResults) {
        this.speciesResults = speciesResults;
    }

}
