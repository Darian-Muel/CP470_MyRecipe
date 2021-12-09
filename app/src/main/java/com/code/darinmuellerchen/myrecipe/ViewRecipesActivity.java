package com.code.darinmuellerchen.myrecipe;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.LuhnChecksumValidator;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ViewRecipesActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "ViewRecipesActivity";
    private Button btnFavourites;
    private Button btnBreakfast;
    private Button btnLunch;
    private Button btnDinner;
    private Button btnOther;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.type_select_page);
        btnFavourites = findViewById(R.id.btnFavourites);
        btnBreakfast = findViewById(R.id.btnBreakFast);
        btnLunch = findViewById(R.id.btnLunch);
        btnDinner = findViewById(R.id.btnDinner);
        btnOther = findViewById(R.id.btnOther);

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

        btnFavourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewRecipesActivity.this, FavouritesActivity.class);
                startActivity(intent);
            }
        });
        btnBreakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewRecipesActivity.this, BreakfastActivity.class);
                startActivity(intent);
            }
        });
        btnLunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewRecipesActivity.this, LunchActivity.class);
                startActivity(intent);
            }
        });
        btnDinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewRecipesActivity.this, DinnerActivity.class);
                startActivity(intent);
            }
        });
        btnOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewRecipesActivity.this, OtherActivity.class);
                startActivity(intent);
            }
        });
    }
}
