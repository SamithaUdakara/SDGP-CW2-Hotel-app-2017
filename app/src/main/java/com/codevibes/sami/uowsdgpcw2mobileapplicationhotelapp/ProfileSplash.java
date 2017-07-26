package com.codevibes.sami.uowsdgpcw2mobileapplicationhotelapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;

public class ProfileSplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_splash);

        Handler myHandler = new Handler();
        myHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(ProfileSplash.this, Home.class));
                finish();
            }
        }, 3000);


    }

}
