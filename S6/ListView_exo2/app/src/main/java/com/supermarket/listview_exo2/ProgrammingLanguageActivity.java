package com.supermarket.listview_exo2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProgrammingLanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_programming_language);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView imageView = this.findViewById(R.id.img);
        TextView textView_name = this.findViewById(R.id.txt_name);
        TextView textView_description = this.findViewById(R.id.txt_description);

        imageView.setImageResource(getIntent().getIntExtra("logo", R.mipmap.ic_launcher));
        textView_name.setText(getIntent().getStringExtra("name"));
        textView_description.setText(getIntent().getStringExtra("description"));

    }
}