package com.example.swapibrowser.models.vehicle;

import java.io.Serializable;
import java.util.List;

import com.example.swapibrowser.models.IModel;
import com.example.swapibrowser.models.ISingleModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vehicles implements IModel<Vehicle> {

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
    private List<Vehicle> vehicles = null;

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

    public List<Vehicle> getResults() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

}
