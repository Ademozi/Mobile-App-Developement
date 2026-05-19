package com.tp.intentexo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText  edtNumero;
    RadioButton RdAppel, RdSMS;
    Button btnValider, btnAnnuler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        edtNumero = findViewById(R.id.edtNumero);
        RdAppel = findViewById(R.id.RdAppel);
        RdSMS = findViewById(R.id.RdSMS);
        btnValider = findViewById(R.id.btnValider);
        btnAnnuler = findViewById(R.id.btnAnnuler);


        btnValider.setOnClickListener(v -> {

            String number = edtNumero.getText().toString();

            if (number.isEmpty()){

                //Toast
                Toast.makeText(
                        this,
                        "Please Provide a Number",
                        Toast.LENGTH_SHORT).show();
            } else {

                if (RdSMS.isChecked()){
                    Intent intent = new Intent(MainActivity.this, SmsActivity.class);

                    // send data
                    intent.putExtra("number", number);
                    // start intent
                    startActivity(intent);
                } else if (RdAppel.isChecked()) {

                    Intent intent = new Intent(
                            Intent.ACTION_DIAL,
                            Uri.parse("tel:" + number)
                    );

                    startActivity(intent);

                }
            }
        });

        btnAnnuler.setOnClickListener( v -> {
            // close the App
            finish();
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}