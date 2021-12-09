package com.code.darinmuellerchen.myrecipe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HelpActivity extends AppCompatActivity {
    private TextView instructions;
    private TextView header;
    private Button btnShowVersion;
    private Button btnShowAuthors;
    private Button btnShowHelp;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_page);

        instructions = findViewById(R.id.txtInstructions);
        header = findViewById(R.id.txtHelp);
        btnShowAuthors = findViewById(R.id.btnShowAuthors);
        btnShowHelp = findViewById(R.id.btnShowHelp);
        btnShowVersion = findViewById(R.id.btnShowVersionNum);

        bottomNavigationView = findViewById(R.id.bottom_navigator);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.create_navbar:
                        startActivity(new Intent(getApplicationContext(), AddRecipesActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home_navbar:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.help_navbar:
                        startActivity(new Intent(getApplicationContext(), HelpActivity.class));
                        overridePendingTransition(0,0);
                }
                return false;
            }
        });

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
