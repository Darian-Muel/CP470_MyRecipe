package com.code.darinmuellerchen.myrecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {
    private TextView instructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_page);

        instructions = findViewById(R.id.txtInstructions);
        instructions.setMovementMethod(new ScrollingMovementMethod());

    }




}