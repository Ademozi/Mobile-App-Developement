package com.tp.intentexo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SmsActivity extends AppCompatActivity {

    EditText edtSMS;
    Button btnValider2, btnAnnuler2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        edtSMS = findViewById(R.id.edtSMS);
        btnValider2 = findViewById(R.id.btnValider2);
        btnAnnuler2 = findViewById(R.id.btnAnnuler2);

        String number = getIntent().getStringExtra("number");

        btnValider2.setOnClickListener(v -> {

            String sms = edtSMS.getText().toString();

            if (sms.isEmpty()){

                Toast.makeText(
                        this,
                        "Please Provide a sms",
                        Toast.LENGTH_SHORT).show();
            } else {

                Intent intent = new Intent(Intent.ACTION_SENDTO,
                        // set the destination phone number
                        Uri.parse("smsto:" + number)
                );

                // Add the message text
                intent.putExtra("sms_body", sms);

                startActivity(intent);

            }
        });

        btnAnnuler2.setOnClickListener(v -> {

            Intent intent = new Intent(SmsActivity.this, MainActivity.class);

            startActivity(intent);
        });
    }
}