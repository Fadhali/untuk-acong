package com.example.aspkkel7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanbarcodeActivity extends AppCompatActivity {
    int MY_PERMISSIONS_REQUEST_CAMERA=0;
    ZXingScannerView scannerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanbarcode);
        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);

    }
    public void handleResult (Result result){
        MainActivity.scanResult.setText(result.getText());

        onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        scannerView.setResultHandler(this);
//        scannerView.startCamera();
//    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA},
                    MY_PERMISSIONS_REQUEST_CAMERA);
        }
        scannerView.setResultHandler(this::handleResult);
        scannerView.startCamera();
    }

}