package com.code.darinmuellerchen.myrecipe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "MainActivity";
    private Button startViewRecipes;
    private Button startHelpPage;
    private Button startAddRecipes;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startViewRecipes = findViewById(R.id.btnViewRecipes);
        startHelpPage = findViewById(R.id.btnHelp);
        startAddRecipes = findViewById(R.id.btnCreateRecipes);

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
