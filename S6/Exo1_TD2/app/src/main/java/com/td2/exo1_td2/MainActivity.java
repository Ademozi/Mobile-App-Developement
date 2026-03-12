package com.td2.exo1_td2;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
    EditText edit;
    RadioButton rb1,rb2;
    TextView text;

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

        edit = this.findViewById(R.id.ed);
        rb1 = this.findViewById(R.id.r1);
        rb2 = this.findViewById(R.id.r2);
        text = this.findViewById(R.id.txt);

        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                calculate();
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
        });

    }


    public void convert(View view){
        calculate();
    }

    public void calculate(){
        String str = edit.getText().toString();

        if (str.isEmpty()){
            text.setTextColor(Color.RED);
            text.setText("Error!");
        }
        else {
            text.setTextColor(Color.BLACK);
            double input_d = Double.parseDouble(str);
            double d;
            if (rb1.isChecked()) {
                d = 153.25 * input_d;
                text.setText(d + " DZD");
            }

            if (rb2.isChecked()) {
                d = 0.0065 * input_d;
                text.setText(d + " Euro");
            }
        }
    }

}