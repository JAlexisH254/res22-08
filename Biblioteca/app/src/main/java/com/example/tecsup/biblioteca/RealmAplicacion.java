package com.example.tecsup.biblioteca;

import android.app.Application;

import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class RealmAplicacion extends Application {
    public static AtomicInteger codlibro;
    public static AtomicInteger  codigoEjemplar;
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(configuration);
        Realm realm = Realm.getDefaultInstance();
        codlibro = obtenerId(realm, Libro.class);
        codigoEjemplar = obtenerId(realm, Ejemplar.class);
        realm.close();
    }

    <T extends RealmObject>AtomicInteger obtenerId(Realm realm,Class<T> object) {
        RealmResults<T> resultados = realm.where(object).findAll();
        if(resultados.size() > 0){
            return new AtomicInteger(resultados.max("id").intValue());
        }else {
            return  new AtomicInteger();
        }
    }
}
