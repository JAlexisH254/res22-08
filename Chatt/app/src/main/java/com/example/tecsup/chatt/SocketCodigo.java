package com.example.tecsup.chatt;

import android.app.Application;

import io.socket.client.IO;
import io.socket.client.Socket;

public class SocketCodigo extends Application {
    io.socket.client.Socket miSocket;
    {
        try {
            miSocket = IO.socket("http://172.23.8.98:3000/");
        }catch (Exception e){

        }
    }

    public Socket getSocket(){
        return  miSocket;
    }
}
