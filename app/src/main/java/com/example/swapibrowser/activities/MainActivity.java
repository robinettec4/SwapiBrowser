package com.example.swapibrowser.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

import com.example.swapibrowser.R;
import com.example.swapibrowser.models.person.People;
import com.example.swapibrowser.models.person.Person;

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
        addnotification();
    }

    public void goToRandomPageActivity(View view) {
        Intent intent = new Intent(MainActivity.this, RandomPage.class);
        startActivity(intent);
    }

    public void goToRecentlyUpdatedActivity(View view){
        Intent intent = new Intent(MainActivity.this, RecentlyUpdated.class);
        MainActivity.this.startActivity(intent);
    }


    private void addnotification() {
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