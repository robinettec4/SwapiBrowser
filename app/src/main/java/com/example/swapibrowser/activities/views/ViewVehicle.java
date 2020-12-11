package com.example.swapibrowser.activities.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swapibrowser.R;
import com.example.swapibrowser.adapters.ItemAdapterMin;
import com.example.swapibrowser.models.vehicle.Vehicle;
import com.example.swapibrowser.utils.PageSaver;

public class ViewVehicle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicle_field_layout);

        TextView vehicleName = findViewById(R.id.vehicle_name);
        TextView vehicleModel = findViewById(R.id.vehicle_model);
        TextView vehicleManufacturer = findViewById(R.id.vehicle_manufacturer);
        TextView vehicleCost = findViewById(R.id.vehicle_cost);
        TextView vehicleLength = findViewById(R.id.vehicle_length);
        TextView vehicleMaxSpeed = findViewById(R.id.vehicle_max_speed);
        TextView vehicleCrew = findViewById(R.id.vehicle_crew);
        TextView vehiclePassengers = findViewById(R.id.vehicle_passengers);
        TextView vehicleCargo = findViewById(R.id.vehicle_cargo);
        TextView vehicleConsumables = findViewById(R.id.vehicle_consumables);
        TextView vehicleClass = findViewById(R.id.vehicle_class);
        TextView vehicleCreated = findViewById(R.id.vehicle_created);
        TextView vehicleEdited = findViewById(R.id.vehicle_edited);

        RecyclerView vehiclePilots = findViewById(R.id.vehicle_people_recycler);
        RecyclerView vehicleFilms = findViewById(R.id.vehicle_films_recycler);

        Intent intent = getIntent();
        Vehicle vehicle = (Vehicle) intent.getSerializableExtra("vehicles");

        ItemAdapterMin minFilmAdapter = new ItemAdapterMin(vehicle.getFilms(), ViewVehicle.this, "films");
        ItemAdapterMin minPersonAdapter = new ItemAdapterMin(vehicle.getPilots(), ViewVehicle.this, "people");

        vehicleName.setText(getString(R.string.name,  vehicle.getName()));
        vehicleModel.setText(getString(R.string.model, vehicle.getModel()));
        vehicleManufacturer.setText(getString(R.string.manufacturer, vehicle.getManufacturer()));
        vehicleCost.setText(getString(R.string.cost, vehicle.getCostInCredits()));
        vehicleLength.setText(getString(R.string.length, vehicle.getLength()));
        vehicleMaxSpeed.setText(getString(R.string.max_speed, vehicle.getMaxAtmospheringSpeed()));
        vehicleCrew.setText(getString(R.string.crew, vehicle.getCrew()));
        vehiclePassengers.setText(getString(R.string.passengers, vehicle.getPassengers()));
        vehicleCargo.setText(getString(R.string.cargo, vehicle.getCargoCapacity()));
        vehicleConsumables.setText(getString(R.string.consumables, vehicle.getConsumables()));
        vehicleClass.setText(getString(R.string.s_class, vehicle.getVehicleClass()));
        vehicleEdited.setText(getString(R.string.edited, vehicle.getEdited()));
        vehicleCreated.setText(getString(R.string.created, vehicle.getCreated()));

        vehicleFilms.setAdapter(minFilmAdapter);
        vehiclePilots.setAdapter(minPersonAdapter);

        vehicleFilms.setLayoutManager(new LinearLayoutManager(ViewVehicle.this));
        vehiclePilots.setLayoutManager(new LinearLayoutManager(ViewVehicle.this));
    }

    public void saveFavorite(View view) {
        PageSaver saver = new PageSaver();
        saver.saveFavorite(this);
    }
}
