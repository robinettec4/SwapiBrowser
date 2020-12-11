package com.example.swapibrowser.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

import com.example.swapibrowser.R;
import com.example.swapibrowser.utils.PageSaver;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int NOTIFICATION_ID = 0;
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";
    private NotificationManager mNotificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();
        addNotification();

        TabLayout tabs = findViewById(R.id.menu_tabs);
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) { new TabsHelper(tab.getPosition(), MainActivity.this); }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }
            @Override
            public void onTabReselected(TabLayout.Tab tab) { new TabsHelper(tab.getPosition(), MainActivity.this); }
        });
    }

    private void addNotification() {
        Intent notifyIntent = new Intent(this, AlarmReceiver.class);
        final PendingIntent notifyPendingIntent = PendingIntent.getBroadcast(this, NOTIFICATION_ID, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        final AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        long intervalMillis = AlarmManager.INTERVAL_DAY;
        long triggerTime = SystemClock.elapsedRealtime() + intervalMillis;

        if (alarmManager != null) {
            alarmManager.setInexactRepeating
                    (AlarmManager.ELAPSED_REALTIME_WAKEUP,
                            triggerTime, intervalMillis,
                            notifyPendingIntent);
        }
    }

    public void createNotificationChannel() {
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID, "Daily Page", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Gives you a daily notification that takes you to random page you might be interested in");
            mNotificationManager.createNotificationChannel(notificationChannel);
        }
    }
}