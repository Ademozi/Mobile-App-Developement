package com.tp5.lab5intents;

import android.content.Intent;
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

    EditText editUser, editPassword;
    Button btnOk, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editUser = findViewById(R.id.editUser);
        editPassword = findViewById(R.id.editPassword);

        btnOk = findViewById(R.id.btnOk);
        btnExit = findViewById(R.id.btnExit);

        btnOk.setOnClickListener(v -> {

            String username = editUser.getText().toString();
            String password = editPassword.getText().toString();

            //Verification
            if (username.isEmpty() || password.isEmpty()) {

                // Toast
                Toast.makeText(
                        MainActivity.this,
                        "Fields are empty",
                        //Display duration
                        Toast.LENGTH_LONG
                ).show();

            } else if (username.equals("admin") && password.equals("1234")) {

                Intent intent = new Intent(MainActivity.this, MenuActivity.class);

                // send data
                intent.putExtra("username", username);

                startActivity(intent);

            }else {

                Toast.makeText(
                        MainActivity.this,
                        "Wrong username/password",
                        Toast.LENGTH_LONG
                ).show();
            }


        });

        btnExit.setOnClickListener(v -> finish());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}