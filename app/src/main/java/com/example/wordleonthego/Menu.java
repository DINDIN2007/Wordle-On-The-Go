package com.example.wordleonthego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Button english_Option, japanese_Option, spanish_Option, french_Option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        english_Option = (Button)findViewById(R.id.English);
        english_Option.setOnClickListener(v -> {
            // Intent englishPage = new Intent(Menu.this, English.class);
            Intent englishPage = English.makeIntent(Menu.this);
            startActivity(englishPage);
        });

        japanese_Option = (Button)findViewById(R.id.Japanese);
        japanese_Option.setOnClickListener(v -> {
            Intent japanesePage = Japanese.makeIntent(Menu.this);
            startActivity(japanesePage);
        });

        spanish_Option = (Button)findViewById(R.id.Spanish);
        spanish_Option.setOnClickListener(v -> {
            Intent spanishPage = Spanish.makeIntent(Menu.this);
            startActivity(spanishPage);
        });

        french_Option = (Button)findViewById(R.id.French);
        french_Option.setOnClickListener(v -> {
            Intent frenchPage = French.makeIntent(Menu.this);
            startActivity(frenchPage);
        });
    }

}