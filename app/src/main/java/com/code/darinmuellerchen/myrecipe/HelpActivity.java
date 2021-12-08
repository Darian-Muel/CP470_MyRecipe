package com.code.darinmuellerchen.myrecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {
    private TextView instructions;
    private TextView header;
    private Button btnShowVersion;
    private Button btnShowAuthors;
    private Button btnShowHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_page);

        instructions = findViewById(R.id.txtInstructions);
        header = findViewById(R.id.txtHelp);
        btnShowAuthors = findViewById(R.id.btnShowAuthors);
        btnShowHelp = findViewById(R.id.btnShowHelp);
        btnShowVersion = findViewById(R.id.btnShowVersionNum);


        instructions.setMovementMethod(new ScrollingMovementMethod());

        btnShowAuthors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                header.setText(R.string.Authors);
                instructions.setText(R.string.AuthorDisplay);
            }
        });

        btnShowHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                header.setText(R.string.Help);
                instructions.setText(R.string.Instructions);
            }
        });

        btnShowVersion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                header.setText(R.string.Version);
                instructions.setText(R.string.VersionDisplay);
            }
        });


    }




}