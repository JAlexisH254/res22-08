package com.example.tecsup.thread;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import java.util.LinkedList;
import java.util.List;

public class StringListLoader extends AsyncTaskLoader<List<String>> {

    public StringListLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public List<String> loadInBackground() {
        List<String> l = new LinkedList<>();
        l.add("Primero");
        l.add("Segundo");
        return l;
    }

}
