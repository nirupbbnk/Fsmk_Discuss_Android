package com.example.satti.discuss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.satti.discuss.R;
import com.example.satti.discuss.discuss;

//import com.parse.Parse;

public class SplashScreen extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //Parse.enableLocalDatastore(this);
        //Parse.initialize(this, "WsBqV89xRR4dpzIVgNeiG9PEOojvhVnRuBah0uif", "ktfv8KcDLoyHI9CswBfd4aBg0RF6Ul1hlcmoCd56");
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this, discuss.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);

    }}