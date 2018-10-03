package com.appentus.quikquik.Activities;

import android.annotation.SuppressLint;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.appentus.quikquik.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setMyLocationButtonEnabled(false);
        mMap.setMyLocationEnabled(true);

        Location location = this.mMap.getMyLocation();
        if (location != null) {
            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
            Geocoder geocoder;
            List<Address> addresses;
            geocoder = new Geocoder(MapsActivity.this, Locale.getDefault());
            try {
                addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
                String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
                String city = addresses.get(0).getLocality();
                String country = addresses.get(0).getCountryName();
             /*   tvaddress.setText(address + ", " + city + ", " + country);
                lat = latLng.latitude + "";
                lang = latLng.longitude + "";*/
                  //  DrawMarker.getInstance(DeliveryAddress.this).draw(mMap, latLng, R.drawable.mp_pink_ball_icon, "You");
                CameraUpdate center = CameraUpdateFactory.newLatLng(latLng);
                CameraUpdate zoom = CameraUpdateFactory.zoomTo(12);
                mMap.moveCamera(center);
                mMap.animateCamera(zoom);
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15.5f), 4000, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
