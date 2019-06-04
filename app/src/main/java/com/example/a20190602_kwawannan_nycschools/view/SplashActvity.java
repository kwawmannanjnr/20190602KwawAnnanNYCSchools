package com.example.a20190602_kwawannan_nycschools.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


public class SplashActvity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, com.example.a20190602_kwawannan_nycschools.view.MainActivity.class);
        SystemClock.sleep(3000);
        startActivity(intent);
        finish();

    }
}
