package com.example.tecsup.implicitos;

import android.content.Intent;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "DESPIERTA")
                .putExtra(AlarmClock.EXTRA_HOUR, 12)
                .putExtra(AlarmClock.EXTRA_MINUTES, 30);
                if (intent.resolveActivity(getPackageManager())!= null){
                    startActivity(intent);
                }
                capturePhoto();
                */
                avion();
            }
        });
    }

    public void capturePhoto(){
        Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
        if(intent.resolveActivity(getPackageManager()) != null){
          startActivityForResult(intent,1);
        }

    }
    //https://es.ourcodeworld.com/articulos/leer/39/como-abrir-el-menu-de-configuracion-de-android-programaticamente-con-java
    public void avion(){
        Intent intent = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intent,'0');
        }
    }
}
