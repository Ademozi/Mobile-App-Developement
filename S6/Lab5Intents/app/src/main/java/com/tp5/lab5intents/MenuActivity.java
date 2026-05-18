package com.tp5.lab5intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuActivity extends AppCompatActivity {

    Button btnSms, btnCall, btnGoogle, btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);

        btnSms = findViewById(R.id.btnSMS);
        btnCall = findViewById(R.id.btnPhone);
        btnGoogle = findViewById(R.id.btnGoogle);
        btnReturn = findViewById(R.id.btnReturn);


        // receive username
        String username = getIntent().getStringExtra("username");

        Toast.makeText(
                this,
                "Welcome" + username,
                Toast.LENGTH_LONG
        ).show();


        // SMS Button
        btnSms.setOnClickListener( v -> {

            Intent intent =
                    new Intent(MenuActivity.this, SmsActivity.class);

            startActivity(intent);
        } );


        //IMPLICIT INTENT
        btnCall.setOnClickListener(v -> {

            Intent intent = new Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse("tel:555555")
            );

            startActivity(intent);
        });

        //ACTION_VIEW
        btnGoogle.setOnClickListener( v -> {

            Intent intent = new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.google.com")
            );

            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}