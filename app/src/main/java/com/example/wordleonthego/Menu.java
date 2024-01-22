package com.example.wordleonthego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Button english_Option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        english_Option = (Button)findViewById(R.id.English);
        english_Option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent englishPage = new Intent(Menu.this, English.class);
                Intent englishPage = English.makeIntent(Menu.this);
                startActivity(englishPage);
            }
        });
    }

}