package com.example.swapibrowser.activities.factory;

import androidx.appcompat.app.AppCompatActivity;

public interface IActivityFactory {
    Class CreateActivity(String itemType);
}
