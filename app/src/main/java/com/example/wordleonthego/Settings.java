package com.example.wordleonthego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class Settings extends AppCompatActivity {
    Spinner spinner;
    private static final String[] languages = {"Select Language", "English", "French", "Japanese", "Spanish"};
    private static final String SELECTED_LANGUAGE = "selected_language";

    public static Intent makeIntent(Context context) {
        return new Intent(context, Settings.class);
    }

    private void setupEndActivityButton() {
        Button btn = findViewById(R.id.english_back_button);
        btn.setOnClickListener(v -> {
            finish();
        });
    }

    private static Context updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
        configuration.setLayoutDirection(locale);

        return context.createConfigurationContext(configuration);
    }

    private static void persist(Context context, String language) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(SELECTED_LANGUAGE, language);
        editor.apply();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        spinner = findViewById(R.id.languageOptions);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, languages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedLang = parent.getItemAtPosition(position).toString();
                switch (selectedLang) {
                    case "English":
                        updateResources(Settings.this, "en");
                        persist(Settings.this, "en");
                        finish();
                        startActivity(getIntent());
                        break;
                    case "French":
                        updateResources(Settings.this, "fr");
                        persist(Settings.this, "fr");
                        finish();
                        startActivity(getIntent());
                        break;
                    case "Japanese":
                        updateResources(Settings.this, "ja");
                        persist(Settings.this, "ja");
                        finish();
                        startActivity(getIntent());
                        break;
                    case "Spanish":
                        updateResources(Settings.this, "es");
                        persist(Settings.this, "es");
                        finish();
                        startActivity(getIntent());
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        setupEndActivityButton();
    }
}