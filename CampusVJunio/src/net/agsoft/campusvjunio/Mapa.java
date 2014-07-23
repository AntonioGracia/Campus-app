package net.agsoft.campusvjunio;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Mapa extends Activity {
 GoogleMap map;
 @SuppressLint("NewApi")
 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_mapa);

  map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
    .getMap();

  map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

  
  map.setMyLocationEnabled(true);
  
  map.addMarker(new MarkerOptions()
  .position(new LatLng(39.455661, -0.354795))
  .title("Campus Party Valencia"));
  
  map.addMarker(new MarkerOptions()
  .position(new LatLng(40.464449, -3.616583))
  .title("GamerGy"));
  
  map.addMarker(new MarkerOptions()
  .position(new LatLng(28.454653, -16.257914))
  .title("Tenerife Lan party"));
  
  LatLng pos = new LatLng(41.6516912, -0.8949809);
  CameraPosition camPos = new CameraPosition.Builder()
          .target(pos)   
          .zoom(4)       
          .build();
  
  CameraUpdate camera = CameraUpdateFactory.newCameraPosition(camPos);
  
  map.animateCamera(camera);
  
  
 }
}