package com.tp5.lab5intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SmsActivity extends AppCompatActivity {

    EditText editPhone, editMessage;
    Button btnSend, btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sms);

        editPhone = findViewById(R.id.editPhone);
        editMessage = findViewById(R.id.editMessage);
        btnSend = findViewById(R.id.btnSend);
        btnReturn = findViewById(R.id.btnReturn);

        btnSend.setOnClickListener(v -> {

            String phone = editPhone.getText().toString();

            String message = editMessage.getText().toString();

            Uri uri = Uri.parse("sms:" + phone);

            Intent intent = new Intent(Intent.ACTION_VIEW, uri);

            intent.putExtra("sms_body", message);

            startActivity(intent);
        });

        btnReturn.setOnClickListener(v -> finish());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}