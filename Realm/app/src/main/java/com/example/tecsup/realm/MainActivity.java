package com.example.tecsup.realm;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*SharedPreferences preferencias = getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);
        String s = preferencias.getString("Usuario","Anonimo");
        Toast.makeText(this,s, Toast.LENGTH_SHORT).show();

        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("Usuario","Santiago");
        editor.apply();*/

        Dog d = new Dog("Firulais",10);
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        //realm.copyToRealm(d);
        Person p = realm.createObject(Person.class,2);
        p.setName("Cesar Milan");
        p.dogs.add(d);
        realm.commitTransaction();

        RealmResults<Dog> puppies = realm.where(Dog.class).findAll();
        Toast.makeText(this,puppies.size()+"",Toast.LENGTH_SHORT).show();

        puppies.addChangeListener(new RealmChangeListener<RealmResults<Dog>>() {
            @Override
            public void onChange(RealmResults<Dog> dogs) {
                
            }
        });

        realm.beginTransaction();
        puppies.get(0).deleteFromRealm();
        realm.commitTransaction();
    }
}
