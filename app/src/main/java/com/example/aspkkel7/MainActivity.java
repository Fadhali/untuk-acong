package com.example.aspkkel7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    public static TextView scanResult;
    Button goScan, goLogout;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scanResult = findViewById(R.id.scanresult);
        goScan = findViewById(R.id.ScanBtn);
        goLogout = findViewById(R.id.LogoutBtn);

        goLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logout();

            }
        });

        goScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext() ,ScanbarcodeActivity.class));
            }
        });



    }
    private void Logout()
    {
        fAuth.signOut();
        finish();
        startActivity(new Intent(MainActivity.this,Login.class));
        Toast.makeText(MainActivity.this,"LOGOUT SUCCESSFUL", Toast.LENGTH_SHORT).show();

    }
}