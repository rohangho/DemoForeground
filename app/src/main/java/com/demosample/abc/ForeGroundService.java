package com.demosample.abc;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class ForeGroundService extends Service {


    public static final String CHANNEL_ID = "I_am_Forueground";


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String input = intent.getStringExtra("timer");

        final Long[] k = {Long.parseLong(input)};

        final Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle(Long.toString(k[0]))
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentText("dwvcwefc")
                .build();


        createNotificationChannel();
     CountDownTimer countDownTimer = new CountDownTimer(Integer.parseInt(input)*10000,10)
     {

         @Override
         public void onTick(long l) {
            k[0] =l;
             Notification notification = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                     .setContentTitle(Long.toString(k[0]))
                     .setSmallIcon(R.drawable.ic_launcher_background)
                     .setContentText("dwvcwefc")
                     .build();
             startForeground(1, notification);

         }

         @Override
         public void onFinish() {

         }
     };
     countDownTimer.start();

        startForeground(1, notification);
       return START_STICKY;


    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNEL_ID,
                    "ForeChannel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(serviceChannel);
        }
    }
}
