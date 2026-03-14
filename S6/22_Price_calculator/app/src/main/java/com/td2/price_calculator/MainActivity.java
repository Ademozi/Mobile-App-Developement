package com.td2.price_calculator;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editPrice, editQuantity;
    RadioButton rb1, rb2, rb3;
    TextView textPet, textPat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editPrice = this.findViewById(R.id.price);
        editQuantity = this.findViewById(R.id.quantity);
        rb1 = this.findViewById(R.id.r1);
        rb2 = this.findViewById(R.id.r2);
        rb3 = this.findViewById(R.id.r3);
        textPet = this.findViewById(R.id.pet);
        textPat = this.findViewById(R.id.pat);

        rb1.setChecked(true);

    }

    public void calculate(View view){
        String price = editPrice.getText().toString();
        String quantity = editQuantity.getText().toString();

        if (price.isEmpty() || quantity.isEmpty()){
            textPet.setTextColor(Color.RED);
            textPat.setText("Fill all fields");
            textPet.setTextColor(Color.RED);
            textPet.setText("ERROR!");
        }

        else {
            double doublePrice = Double.parseDouble(price);
            double doubleQuantity = Double.parseDouble(quantity);
            double doublePat, doublePet;
            //PET
            doublePet = doublePrice * doubleQuantity;
            textPet.setText(doublePet + "DZD");
            //PAT
            if(rb1.isChecked()){
                doublePat = doublePet;
                textPat.setText(doublePat + "DZD");
            }
            if (rb2.isChecked()){
                doublePat = doublePet + (0.10 * doublePet);
                textPat.setText(doublePat + "DZD");
            }
            if (rb3.isChecked()){
                doublePat = doublePet + (0.20 * doublePet);
                textPat.setText(doublePat + "DZD");
            }
        }
    }
    public void initialize(View view){

        editPrice.setText("");
        editQuantity.setText("");

        textPat.setText("");
        textPet.setText("");

        rb1.setChecked(true);
    }

    public void exit(View view){
        finish();
    }

}