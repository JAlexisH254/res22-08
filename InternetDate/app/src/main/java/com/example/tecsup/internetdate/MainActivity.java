package com.example.tecsup.internetdate;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConnectivityManager c = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = c.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (info == null){
            Toast.makeText(MainActivity.this, "Active wifi",Toast.LENGTH_SHORT).show();
        }
        if (!info.isConnected()){
            Toast.makeText(MainActivity.this, "Error, no tiene internet",Toast.LENGTH_SHORT).show();
        }

        final String BASE_URL =  "https://www.googleapis.com/books/v1/volumes?";
        final String QUERY_PARAM = "q";
        final String MAX_RESULTS = "maxResults";
        final String PRINT_TYPE = "printType";

        Uri builtURI = Uri.parse(BASE_URL).buildUpon()
                .appendQueryParameter(QUERY_PARAM, "pride+prejudice")
                .appendQueryParameter(MAX_RESULTS, "10")
                .appendQueryParameter(PRINT_TYPE, "books")
                .build();
        try{
            URL  requestURL = new URL(builtURI.toString());




        }catch (MalformedURLException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
