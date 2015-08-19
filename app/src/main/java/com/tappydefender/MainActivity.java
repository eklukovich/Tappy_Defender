package com.tappydefender;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener
     {
     
     @Override
     protected void onCreate(Bundle savedInstanceState)
          {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);


          // Get a reference to the button in our layout
          final Button playButton = (Button) findViewById(R.id.buttonPlay);

          // Listen for clicks
          playButton.setOnClickListener(this);
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

     }
