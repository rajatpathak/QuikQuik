package com.appentus.quikquik.Activities;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.appentus.quikquik.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AllowLocationActivity extends AppCompatActivity {
    Activity activity = this;
    private static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allow_location);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnallow)
    public void onViewClicked(View view) {
        if (checkAndRequestPermissions()) {
            finish();
            startActivity(new Intent(activity, WelcomeActivity.class));
        }
    }

    private void showDialogOK(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", okListener)
                .create()
                .show();
    }

    private boolean checkAndRequestPermissions() {
        int ACCESS_NETWORK_STATE = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NETWORK_STATE);
        int ACCESS_FINE_LOCATION = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        int ACCESS_COARSE_LOCATION = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        int INTERNET = ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET);
        int READ_PHONE_STATE = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);
        int READ_EXTERNAL_STORAGE = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        int WRITE_EXTERNAL_STORAGE = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        List<String> listPermissionsNeeded = new ArrayList<>();

        if (ACCESS_NETWORK_STATE != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.ACCESS_NETWORK_STATE);
        }

     /*   if (READ_PHONE_STATE != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_PHONE_STATE);
        }*/

    /*    if (READ_EXTERNAL_STORAGE != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
        if (WRITE_EXTERNAL_STORAGE != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }*/

        if (INTERNET != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.INTERNET);
        }
        if (ACCESS_FINE_LOCATION != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ACCESS_COARSE_LOCATION != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        }

        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_ID_MULTIPLE_PERMISSIONS: {

                Map<String, Integer> perms = new HashMap<>();
                // Initialize the map with both permissions
                perms.put(Manifest.permission.ACCESS_NETWORK_STATE, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.INTERNET, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.READ_PHONE_STATE, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.ACCESS_FINE_LOCATION, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.ACCESS_COARSE_LOCATION, PackageManager.PERMISSION_GRANTED);

                if (grantResults.length > 0) {
                    for (int i = 0; i < permissions.length; i++)
                        perms.put(permissions[i], grantResults[i]);


                    if (perms.get(Manifest.permission.ACCESS_NETWORK_STATE) == PackageManager.PERMISSION_GRANTED
                            && perms.get(Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED
                            && perms.get(Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED
                            && perms.get(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                            && perms.get(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
                            ) {
                        Log.d("msg", "All Permissions granted");
                        finish();
                        startActivity(new Intent(activity, WelcomeActivity.class));
                    } else {
                        Log.d("msg", "Some permissions are not granted ask again ");

                        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.INTERNET)
                                && ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_NETWORK_STATE)
                                && ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_PHONE_STATE)
                                && ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)
                                && ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                                ) {
                            showDialogOK("Permisions required for this app",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            switch (which) {
                                                case DialogInterface.BUTTON_POSITIVE:
                                                    //checkAndRequestPermissions();
                                                    break;
                                                case DialogInterface.BUTTON_NEGATIVE:
                                                    // proceed with logic by disabling the related features or quit the app.
                                                    break;
                                            }
                                        }
                                    });
                        } else {
                            Toast.makeText(this, "Go to settings and enable permissions", Toast.LENGTH_LONG)
                                    .show();
                        }
                    }
                }
            }
        }
    }
}
