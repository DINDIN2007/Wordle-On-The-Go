package com.example.wordleonthego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class RulePage extends AppCompatActivity {
    public static Intent makeIntent(Context context) {
        return new Intent(context, RulePage.class);
    }

    private void setupEndActivityButton() {
        Button btn = findViewById(R.id.rules_back_button);
        btn.setOnClickListener(v -> {
            finish();
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule_page);
        setupEndActivityButton();
    }
}