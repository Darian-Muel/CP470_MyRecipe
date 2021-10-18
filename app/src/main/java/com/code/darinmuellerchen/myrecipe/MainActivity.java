package com.code.darinmuellerchen.myrecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "MainActivity";
    private Button startViewRecipes;
    private Button startHelpPage;
    private Button startAddRecipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startViewRecipes = findViewById(R.id.btnViewRecipes);
        startHelpPage = findViewById(R.id.btnHelp);
        startAddRecipes = findViewById(R.id.btnCreateRecipes);


        startViewRecipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewRecipesActivity.class);
                startActivity(intent);
            }
        });
        startHelpPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HelpActivity.class);
                startActivity(intent);
            }
        });
        startAddRecipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddRecipesActivity.class);
                startActivity(intent);
            }
        });

    }
}