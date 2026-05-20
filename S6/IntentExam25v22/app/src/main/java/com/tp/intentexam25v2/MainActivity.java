package com.tp.intentexam25v2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtNum, edtSMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtNum = findViewById(R.id.edtNum);
        edtSMS = findViewById(R.id.edtSMS);
    }

    public void call (View v){

        String number = edtNum.getText().toString();

        if (number.isEmpty()){

            Toast.makeText(this,"Enter a phone", Toast.LENGTH_SHORT).show();

        }else{

            Intent intent = new Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse("tel:" + number)
            );

            startActivity(intent);
        }
    }

    public void message (View v){

        String number = edtNum.getText().toString();
        String sms = edtSMS.getText().toString();

        if (number.isEmpty() || sms.isEmpty()){

            Toast.makeText(this, "Erreur Phone/SMS", Toast.LENGTH_SHORT).show();

        }else{

            Intent intent = new Intent(
                    Intent.ACTION_SENDTO,
                    Uri.parse("smsto:" + number)
            );

            intent.putExtra("sms_body", sms);

            startActivity(intent);

        }

    }

    public void exit (View v){
        finish();
    }
}