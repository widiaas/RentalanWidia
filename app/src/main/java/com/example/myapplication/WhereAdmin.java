package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class WhereAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().getDecorView().setSystemUiVisibility(
                 View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        setContentView(R.layout.activity_where_admin);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        CardView carduser = findViewById(R.id.cardtouser);
        CardView carditem = findViewById(R.id.cardtoitem);
        CardView cardtransaction = findViewById(R.id.cardtotransaction);
        ImageView iconuser = findViewById(R.id.icontouser);
        ImageView iconitem = findViewById(R.id.icontoitem);
        ImageView icontransaction = findViewById(R.id.icontotransaction);

        carduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WhereAdmin.this, ViewCustomerAdmin.class);
                startActivity(intent);
            }
        });
        iconuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WhereAdmin.this, ViewCustomerAdmin.class);
                startActivity(intent);
            }
        });
        carditem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WhereAdmin.this, ActivityViewBicycle.class);
                startActivity(intent);
            }
        });
        carditem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WhereAdmin.this, ActivityViewBicycle.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(WhereAdmin.this,MainActivity.class);
        startActivity(i);
    }
}