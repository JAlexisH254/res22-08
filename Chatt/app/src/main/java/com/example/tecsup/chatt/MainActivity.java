package com.example.tecsup.chatt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class MainActivity extends AppCompatActivity {
    EditText usuario;
    Button bt_login;
    Socket socket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EnlazarViews();

        SocketCodigo app = (SocketCodigo) getApplication();
        socket = app.getSocket();
        socket.connect();

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                socket.emit("add user",usuario.getText().toString());
            }
        });
        socket.on("login",onLogin);

    }

    void  EnlazarViews(){
        usuario = findViewById(R.id.usuario);
        bt_login = findViewById(R.id.bt_login);
    }

    private Emitter.Listener onLogin = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject data = (JSONObject) args[0];
                    int cant=0;
                    try {
                        cant = data.getInt("numUsers");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(MainActivity.this, cant+"",Toast.LENGTH_LONG).show();
                }
            });
        }
    };
}
