package com.tp4.translation;

import android.os.Bundle;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView text1;
    TextView sourceText;

    // This method runs when the activity starts.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect TextView with XML
        text1 = findViewById(R.id.text1);
        // Enable context menu on long press
        registerForContextMenu(text1);

        // connect sourceText with XML
        sourceText = findViewById(R.id.sourceText);

        // Event to start the webActivity
        sourceText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =
                        new Intent(MainActivity.this,
                                WebActivity.class);

                startActivity(intent);
            }
        });
    }

    // Create menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    // Menu click events
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.lang_en){
            changeLanguage("en");
        }

        else if(item.getItemId() == R.id.lang_fr){
            changeLanguage("fr");
        }

        else if(item.getItemId() == R.id.lang_ar){
            changeLanguage("ar");
        }

        return true;
    }

    // Change language method
    public void changeLanguage(String lang){

        // Locale represents a language/region.
        Locale myLocale = new Locale(lang);
        // Makes this language the app default.
        Locale.setDefault(myLocale);

        // Creates a configuration object.
        Configuration config = new Configuration();
        config.locale = myLocale;

        // access Resources
        Resources resources = this.getResources();

        resources.updateConfiguration(
                config,
                resources.getDisplayMetrics()
        );

        // Restart activity
        Intent intent = getIntent();

        finish();

        startActivity(intent);
    }

    // Create Context Menu
    // Android loads: menu_context.xml
    //when user long presses the TextView.
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){

        super.onCreateContextMenu(menu, v , menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.style1){

            // This applies the style dynamically.
            text1.setTextAppearance(this, R.style.style1);
            return true;
        }

        else if(item.getItemId() == R.id.style2){

            text1.setTextAppearance(this, R.style.style2);
            return true;
        }

        else if(item.getItemId() == R.id.style3){

            text1.setTextAppearance(this, R.style.style3);
            return true;
        }

        return super.onContextItemSelected(item);
    }



}

