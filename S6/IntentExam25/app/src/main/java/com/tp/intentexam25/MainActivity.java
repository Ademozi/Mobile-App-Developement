package com.tp.intentexam25;

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

public class MainActivity extends AppCompatActivity {

    EditText edtNum, edtSMS;
    Button btnCall, btnMessage, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtNum = findViewById(R.id.edtNum);
        edtSMS = findViewById(R.id.edtSMS);
        btnCall = findViewById(R.id.btnCall);
        btnMessage = findViewById(R.id.btnMessage);
        btnExit = findViewById(R.id.btnExit);


        btnCall.setOnClickListener(v -> {

            String number = edtNum.getText().toString();

            if (number.isEmpty()){

                Toast.makeText(
                        this,
                        "Provide a Number",
                        Toast.LENGTH_LONG).show();
            }else{

                Intent intent = new Intent(
                        Intent.ACTION_DIAL,
                        Uri.parse("tel:" + number)
                );

                startActivity(intent);
            }
        });

        btnMessage.setOnClickListener(v -> {

            String number = edtNum.getText().toString();
            String sms = edtSMS.getText().toString();

            if (number.isEmpty() || sms.isEmpty()){

                Toast.makeText(
                        this,
                        "Provide a Number/SMS",
                        Toast.LENGTH_LONG).show();
            }else{

                Intent intent = new Intent(
                        Intent.ACTION_SENDTO,
                        Uri.parse("smsto:" + number)
                );

                intent.putExtra("sms_body", sms);

                startActivity(intent);

            }
        });

        btnExit.setOnClickListener(v -> {
            finish();
        });

    }
}