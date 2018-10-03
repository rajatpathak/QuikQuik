package com.appentus.quikquik.Activities;

        import android.annotation.SuppressLint;
        import android.app.Activity;
        import android.location.Address;
        import android.location.Criteria;
        import android.location.Geocoder;
        import android.location.Location;
        import android.location.LocationManager;
        import android.os.Bundle;
        import android.support.v4.app.FragmentActivity;
        import android.view.View;
        import android.widget.TextView;

        import com.appentus.quikquik.R;
        import com.google.android.gms.maps.CameraUpdate;
        import com.google.android.gms.maps.CameraUpdateFactory;
        import com.google.android.gms.maps.GoogleMap;
        import com.google.android.gms.maps.OnMapReadyCallback;
        import com.google.android.gms.maps.SupportMapFragment;
        import com.google.android.gms.maps.model.LatLng;

        import java.util.List;
        import java.util.Locale;

        import butterknife.BindView;
        import butterknife.ButterKnife;
        import butterknife.OnClick;

public class MapLocation extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    Activity activity = this;
    @BindView(R.id.tvaddress)
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_location);
        ButterKnife.bind(activity);
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

        LocationManager service = (LocationManager)
                getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String provider = service.getBestProvider(criteria, false);
        Location location = service.getLastKnownLocation(provider);

        if (location != null) {
            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
            Geocoder geocoder;
            List<Address> addresses;
            geocoder = new Geocoder(activity, Locale.getDefault());
            try {
                addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
                String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
                String city = addresses.get(0).getLocality();
                String country = addresses.get(0).getCountryName();
                textView.setText(address + ", " + city + ", " + country);/*
                lat = latLng.latitude + "";
                lang = latLng.longitude + "";*/
                //    DrawMarker.getInstance(DeliveryAddress.this).draw(mMap, latLng, R.drawable.mp_pink_ball_icon, "You");
                CameraUpdate center = CameraUpdateFactory.newLatLng(latLng);
                CameraUpdate zoom = CameraUpdateFactory.zoomTo(11);
                mMap.moveCamera(center);
                mMap.animateCamera(zoom);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        /*mMap.animateCamera(CameraUpdateFactory.newLatLng(new LatLng(googleMap.getMyLocation().getLatitude(),googleMap.getMyLocation().getLatitude())),4000,null);
        mMap.animateCamera(CameraUpdateFactory.zoomTo(11f),2000,null);*/
    }

    @OnClick({R.id.ivback})
    public void submit(View view) {
        switch (view.getId()) {
            case R.id.ivback:
                finish();
                break;
        }
    }
}
