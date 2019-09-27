package com.example.tecsup.notificaciones1;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b;
    NotificationManager notificationManager;
    NotificationReceiver not;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.button);

        not = new NotificationReceiver();
        registerReceiver(not,new IntentFilter("putoelquelolea")); //com.android.Notificaciones1
        CrearCanalDeNotificaciones();


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CrearNotificacion();
            }
        });
    }

    void CrearCanalDeNotificaciones(){
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel("notificacion_1","Codigo notificacion",NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Notificacion codigo");
            //notificationChannel.setVibrationPattern();
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    void CrearNotificacion(){
        Intent updateIntent = new Intent("putoelquelolea");
        PendingIntent updatePendingIntent = PendingIntent.getBroadcast(this,0,updateIntent,PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"notificacion_1")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("pimera notifacion")
                .setContentText("notificacion codigo");
        builder.addAction(new NotificationCompat.Action(R.drawable.ic_launcher_background,"Apretame",updatePendingIntent));
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText("Esto es un texxto de prueba" +
                "Esto es un texxto de prueba"+
                "Esto es un texxto de prueba"+
                "Esto es un texxto de prueba"+
                "Esto es un texxto de prueba").setBigContentTitle("Hola que tal como estas"));
        notificationManager.notify(0,builder.build());
    }

    public  class NotificationReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"Me apreto", Toast.LENGTH_SHORT).show();
            notificationManager.cancel(0);
        }
    }
}
