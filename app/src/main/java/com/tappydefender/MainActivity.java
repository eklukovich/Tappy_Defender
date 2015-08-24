package com.tappydefender;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener
   {

      @Override
      protected void onCreate(Bundle savedInstanceState)
         {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Prepare to load fastest time
            SharedPreferences prefs;
            SharedPreferences.Editor editor;
            prefs = getSharedPreferences("HiScores", MODE_PRIVATE);

            // Get a reference to the button in our layout
            final Button playButton = (Button) findViewById(R.id.buttonPlay);

            // Get a reference to the TextView in our layout
            final TextView textFastestTime = (TextView) findViewById(R.id.textHiScore);

            // Listen for clicks
            playButton.setOnClickListener(this);

            // Load fastest time
            // if not available our high score = 1000000
            long fastestTime = prefs.getLong("fastestTime", 1000000);
            // Put the high score in our TextView
            textFastestTime.setText("Fastest Time:" + fastestTime);
         }

      @Override
      public void onClick(View v)
         {
            switch (v.getId())
               {
                  case R.id.buttonPlay:

                     // Create a new Intent object
                     Intent i = new Intent(this, GameActivity.class);
                     // Start our GameActivity class via the Intent
                     startActivity(i);
                     finish();

                     break;
               }

         }

      // If the player hits the back button, quit the app
      public boolean onKeyDown(int keyCode, KeyEvent event)
         {
            if (keyCode == KeyEvent.KEYCODE_BACK)
               {
                  finish();
                  return true;
               }
            return false;
         }

   }
