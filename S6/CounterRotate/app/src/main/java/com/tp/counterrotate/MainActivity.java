package com.tp.counterrotate;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView txtCounter;
    Button btnIncrement, btnRotate;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txtCounter = findViewById(R.id.txtCounter);
        btnIncrement = findViewById(R.id.btnIncrement);
        btnRotate = findViewById(R.id.btnRotate);

        // This runs when the Activity is being created again.
        if (savedInstanceState != null) {
            // savedInstanceState = It is the same Bundle you created earlier in onSaveInstanceState()
            counter = savedInstanceState.getInt("counter");
        } else {
            counter = 0; // important
        }

        txtCounter.setText(String.valueOf(counter));


        // Incrementation
        btnIncrement.setOnClickListener(v -> {
            counter++;
            txtCounter.setText(String.valueOf(counter));
        });


        //Screen Rotation
        btnRotate.setOnClickListener(view -> {

            // getting current rotation
            int current = getRequestedOrientation();

            if (current == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT){
                // Change it to Landscape
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            } else {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // for showing the same value when rotating
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // onSavedInstanceState = Save data before Activity is destroyed
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
    }
    // Bundle = a key-value storage box
    // outState = the box where you store data before destruction
}