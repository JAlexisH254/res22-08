package com.example.tecsup.chatt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class chat extends AppCompatActivity {
    RecyclerView recyclerView;
    List<String> datos;
    ChatAdapter chatAdapter;
    Button btnEnviar;
    EditText etMensaje;
    Socket socket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        EnlazarView();

        SocketCodigo app = (SocketCodigo) getApplication();
        socket = app.getSocket();
        socket.connect();
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EnviarMensaje();
            }
        });
        datos = new ArrayList<>();
        socket.on("new message", onMessage);
        chatAdapter=  new ChatAdapter(this,R.layout.pantalla,datos);
        recyclerView.setAdapter(chatAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    void EnviarMensaje(){
        String mensaje = etMensaje.getText().toString();
        etMensaje.setText("");
        socket.emit("new message", mensaje);
    }
    void EnlazarView(){
        btnEnviar = findViewById(R.id.bt_enviar);
        etMensaje = findViewById(R.id.et_mensaje);
        recyclerView = findViewById(R.id.rvMensaje);
    }

    private Emitter.Listener onMessage = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject data = (JSONObject) args[0];
                    String message = "";
                    try {
                        message = data.getString("message");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    datos.add(message);
                    chatAdapter.notifyDataSetChanged();
                }
            });
        }
    };
}
