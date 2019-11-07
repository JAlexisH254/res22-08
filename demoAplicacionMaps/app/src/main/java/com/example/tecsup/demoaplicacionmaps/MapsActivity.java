package com.example.tecsup.demoaplicacionmaps;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
// Check permission
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    1);
        }

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add  marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);

        Location i = ObtenerUbicacion();
        double longitude = i.getLongitude();
        double latitude = i.getLatitude();

        LatLng arequipa = new LatLng(latitude, longitude);
        LatLng arequipa1 = new LatLng(latitude+1, longitude+2);
        LatLng arequipa2 = new LatLng(latitude+3, longitude+1);
        LatLng arequipa3 = new LatLng(latitude+2, longitude+3);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.addMarker(new MarkerOptions().position(arequipa).title("ubicacion arequipa"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(arequipa));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(arequipa, 10));
        mMap.setMyLocationEnabled(true);
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
               // Marker my_marcadot = mMap.addMarker(new MarkerOptions().position(latLng).title("my").snippet("this is my").)
                mMap.addMarker(new MarkerOptions().position(latLng));
            }
        });

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                Toast.makeText(MapsActivity.this,marker.getTag().toString(),Toast.LENGTH_LONG).show();
                return false;
            }
        });
        mMap.addCircle(new CircleOptions().center(arequipa).radius(1));
        mMap.addPolygon(new PolygonOptions().add(arequipa,arequipa1,arequipa2,arequipa3));
    }

    Location ObtenerUbicacion() {
        Criteria criteria = new Criteria();
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // Verificar si se tienen permisos para acceder a nuestra ubicación
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {


            return null;
        }
        //Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        String provider = lm.getBestProvider(criteria, true);
        Location location = lm.getLastKnownLocation(provider);
        return location;
    }

}
